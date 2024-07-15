package com.huanjial.springboot.study.myapp.service;

import com.huanjial.springboot.study.myapp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee getEmployeeById(int id);

    Employee save(Employee employee);
}
