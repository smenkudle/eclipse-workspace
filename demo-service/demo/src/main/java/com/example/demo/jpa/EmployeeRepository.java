package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.UserLogin;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
