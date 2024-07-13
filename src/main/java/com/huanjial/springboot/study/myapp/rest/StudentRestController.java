package com.huanjial.springboot.study.myapp.rest;

import com.huanjial.springboot.study.myapp.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> studentList;

    @PostConstruct
    // @PostConstruct is an annotation used in Java to indicate that a method should be invoked after the bean's
    // initialization but before it is made available for use. It is part of the javax.annotation package. This method
    // is typically used for performing any initialization tasks that need to occur after the bean is fully initialized
    // but before it is used by any other code.
    public void loadData(){
        studentList = new ArrayList<>();

        studentList.add(new Student("Sam", "Liang"));
        studentList.add(new Student("Caitlyn", "Vi"));
        studentList.add(new Student("Caroline", "Moonlight"));
    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    @GetMapping("/students/{indexNum}")
    public Student getStudentById(@PathVariable int indexNum) {
        if (indexNum < 0 || indexNum >= studentList.size()){
            throw new StudentNotFoundException("Index not found - " + indexNum);
        }
        return studentList.get(indexNum);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException err){
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(err.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
