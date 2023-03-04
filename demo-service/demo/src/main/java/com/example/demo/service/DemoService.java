package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jpa.EmployeeRepository;
import com.example.demo.jpa.UserRepository;
import com.example.demo.model.Employee;
import com.example.demo.model.UserLogin;

@Service
public class DemoService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public void saveUser(UserLogin user) {
		System.out.println("Inside Save User****");
		userRepository.save(user);
	}

	public List<UserLogin> getAllUsers() {

		return userRepository.findAll();

	}

	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();

	}

	public void saveEmployee(Employee employee) {

		employeeRepository.save(employee);
	}
}
