package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.UserLogin;
import com.example.demo.service.DemoService;

@RestController
public class DemoController {

	@Autowired
	private DemoService demoService;

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@GetMapping("/admin/login")
	public String adminLogin() {
		return "Hello Admin!";
	}

	@GetMapping("/users/all")
	public List<UserLogin> getUsers() {
		return demoService.getAllUsers();
	}

	@GetMapping("/employees/all")
	public List<Employee> getEmployees() {
		return demoService.getAllEmployees();
	}

	// there is no use of exposing error as this is reserved
	@GetMapping("/errors")
	public String helloError() {
		return "Something is wrong!";
	}
}
