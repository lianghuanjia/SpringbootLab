package com.huanjial.springboot.study.myapp.service;

import com.huanjial.springboot.study.myapp.dao.EmployeeDAO;
import com.huanjial.springboot.study.myapp.entity.Employee;
import jakarta.websocket.server.PathParam;
import jdk.jshell.spi.ExecutionControlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl() {
    }

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        try{
            Employee employee = employeeDAO.getEmployeeById(id);
            return employee;
        }catch (Exception ex){
            throw new RuntimeException("Exception raise: " + ex.getMessage());
        }
    }

    @Override
    public Employee save(Employee employee) {
        try{
            return employeeDAO.saveEmployee(employee);
        }catch (Exception exception){
            throw exception;
        }
    }

    @Override
    public Employee update(Employee employee) {
        try{
            return employeeDAO.updateEmployee(employee);
        }catch (Exception exception){
            throw exception;
        }
    }


}
