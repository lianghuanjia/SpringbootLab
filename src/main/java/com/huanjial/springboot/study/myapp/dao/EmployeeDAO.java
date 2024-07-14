package com.huanjial.springboot.study.myapp.dao;

import com.huanjial.springboot.study.myapp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
