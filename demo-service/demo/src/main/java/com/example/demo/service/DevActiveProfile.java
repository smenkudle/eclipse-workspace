package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Profile(value = "dev")
public class DevActiveProfile {

	@Value("${spring.profiles.active:Default}")
	private String activeProfile;

	@PostConstruct
	public void postConstruct() {
		System.out.print("*****************Active Profile: " + activeProfile + "*****************");
	}

}
