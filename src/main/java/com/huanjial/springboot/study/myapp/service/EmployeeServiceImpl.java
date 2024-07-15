package com.huanjial.springboot.study.myapp.service;

import com.huanjial.springboot.study.myapp.entity.Employee;
import com.huanjial.springboot.study.myapp.repo.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.websocket.server.PathParam;
import jdk.jshell.spi.ExecutionControlProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
    }

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        try{
            Optional<Employee> result = employeeRepository.findById(id);
            if (!result.isPresent()){
                throw new EntityNotFoundException("Employee not found with id: "+id);
            }
            return result.get();
        }catch (Exception ex){
            throw new RuntimeException("Exception raise: " + ex.getMessage());
        }
    }

    @Override
    public Employee save(Employee employee) {
        try{
            return employeeRepository.save(employee);
        }catch (Exception exception){
            throw exception;
        }
    }

    @Override
    public Employee update(Employee employee) {
        try{
            Optional<Employee> result = employeeRepository.findById(employee.getId());
            if (!result.isPresent()){
                throw new EntityNotFoundException("Employee not found with id: "+employee.getId());
            }
            Employee retrieveEmployee = result.get();
            retrieveEmployee.setLastName(employee.getLastName());
            retrieveEmployee.setFirstName(employee.getFirstName());
            retrieveEmployee.setEmail(employee.getEmail());
            return employeeRepository.save(retrieveEmployee);
        }catch (Exception exception){
            throw exception;
        }
    }

    @Override
    public void deleteById(int employeeId) {
        try{
            Optional<Employee> result = employeeRepository.findById(employeeId);
            if (!result.isPresent()){
                throw new EntityNotFoundException("Employee not found with id: "+employeeId);
            }
            employeeRepository.deleteById(employeeId);
        }catch (Exception exception){
            throw exception;
        }
    }


}
