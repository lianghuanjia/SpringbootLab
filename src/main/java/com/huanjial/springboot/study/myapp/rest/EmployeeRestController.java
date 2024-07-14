package com.huanjial.springboot.study.myapp.rest;


import com.huanjial.springboot.study.myapp.dao.EmployeeDAO;
import com.huanjial.springboot.study.myapp.entity.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    public EmployeeRestController() {
    }

    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployees(){
        List<Employee> employeeList = employeeDAO.findAll();
        return employeeList;
    }
}
