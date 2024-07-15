package com.huanjial.springboot.study.myapp.response;


import com.huanjial.springboot.study.myapp.entity.Employee;

public class EmployeeResponse {
    private String message;
    private Employee employee;

    public EmployeeResponse() {
    }

    public EmployeeResponse(String message, Employee employee) {
        this.message = message;
        this.employee = employee;
    }

    // Getters and setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
