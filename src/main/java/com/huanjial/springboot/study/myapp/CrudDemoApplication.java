package com.huanjial.springboot.study.myapp;

import com.huanjial.springboot.study.myapp.dao.*;
import com.huanjial.springboot.study.myapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class CrudDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsWithSortedLastName(studentDAO);
//            queryForStudentsWithMatchLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudentById(studentDAO);
            deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        int numOfDeletedRows = studentDAO.deleteAllStudents();
        System.out.printf("Deleted %d rows", numOfDeletedRows);
    }

    private void deleteStudentById(StudentDAO studentDAO) {
        int studentId = 1;
        studentDAO.delete(studentId);
        System.out.println("Deleted student.");
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        Student foundStudent = studentDAO.findById(studentId);

        foundStudent.setLastName("NewLastName");

        studentDAO.update(foundStudent);

        System.out.println("Update student: " + foundStudent);

    }

    private void queryForStudentsWithMatchLastName(StudentDAO studentDAO) {
        List<Student> studentList = studentDAO.findByLastName("Liang");
        for(Student student: studentList){
            System.out.println(student);
        }
    }

    private void queryForStudentsWithSortedLastName(StudentDAO studentDAO) {
        List<Student> studentList = studentDAO.findAllWithSortedLastName();

        for(Student tempStudent: studentList){
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // Get a list of students
        List<Student> studentList = studentDAO.findAll();

        // Display them
        for (Student tempStudent: studentList) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object...");
        Student student1 = new Student("Micky ", "Mouse", "mm@learnspringboot.com");
        studentDAO.save(student1);

        System.out.println("Retrieving student with id: "+student1.getId());

        Student myStudent = studentDAO.findById(student1.getId());

        System.out.println("found the student: "+myStudent);

    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating new student object...");
        Student student1 = new Student("Sam ", "Liang", "sl@learnspringboot.com");
        Student student2 = new Student("Luke ", "Warm", "lw@learnspringboot.com");
        Student student3 = new Student("Baicheng ", "Fang", "bf@learnspringboot.com");

        System.out.println("Saving the student ...");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

        System.out.println("Done saving");
    }

    // Use it to create a Student object
    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object...");
        Student student = new Student("Paul", "Dao", "paul@learnspringboot.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(student);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + student.getId());
    }


}
