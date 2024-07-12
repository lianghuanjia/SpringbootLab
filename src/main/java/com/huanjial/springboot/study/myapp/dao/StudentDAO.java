package com.huanjial.springboot.study.myapp.dao;

import com.huanjial.springboot.study.myapp.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findAllWithSortedLastName();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(int studentId);

    int deleteAllStudents();

}
