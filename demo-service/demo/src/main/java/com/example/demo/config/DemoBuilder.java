package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;
import com.example.demo.model.UserLogin;
import com.example.demo.service.DemoService;

import jakarta.annotation.PostConstruct;

@Component
public class DemoBuilder {

	@Autowired
	private DemoService demoService;

	@PostConstruct
	public void buildData() {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode("admin");
		System.out.println("Encoded password for user:" + encoder.encode("user"));
		System.out.println("Encoded password for employee:" + encoder.encode("employee"));

		UserLogin user = new UserLogin();
		user.setId(1L);
		user.setUsername("admin");
		user.setPassword(password);
		user.setRole("admin");

		demoService.saveUser(user);

		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("Somnath");
		employee.setSalary(3000L);

		demoService.saveEmployee(employee);

	}
}
