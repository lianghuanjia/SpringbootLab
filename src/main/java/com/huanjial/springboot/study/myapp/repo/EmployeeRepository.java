package com.huanjial.springboot.study.myapp.repo;

import com.huanjial.springboot.study.myapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
