package com.huanjial.springboot.study.myapp.rest;


import com.huanjial.springboot.study.myapp.entity.Employee;
import com.huanjial.springboot.study.myapp.service.EmployeeService;
import com.huanjial.springboot.study.myapp.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController() {
    }

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployees(){
        List<Employee> employeeList = employeeService.findAll();
        return employeeList;
    }

    @GetMapping("/employees/{employeeId}")
    Employee getEmployeeById(@PathVariable int employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);
        return employee;

    }


    @PostMapping("/employees")
    @Transactional
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    @Transactional
    public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.update(employee);
        EmployeeResponse response = new EmployeeResponse("Updated successfully", updatedEmployee);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/employees/{employeeId}")
    @Transactional
    public ResponseEntity deleteEmployeeById(@PathVariable int employeeId){
        employeeService.deleteById(employeeId);
        return (ResponseEntity) ResponseEntity.ok().body("Deleted Successfully");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleEmployeeNotFoundException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
