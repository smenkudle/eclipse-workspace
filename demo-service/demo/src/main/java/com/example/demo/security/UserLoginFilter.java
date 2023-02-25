package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserLoginFilter {

	@Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
         
		System.out.println("Inside UserLoginFilter Confugure");
		
		http
        .cors().and()
        .headers().frameOptions().disable().and() // to access h2 console using local-host
        .csrf().disable() // to access h2 console using local-host
        .authorizeHttpRequests()
        .requestMatchers("/users").hasRole("admin")
        .requestMatchers("/employees").hasRole("manager")
        .anyRequest().authenticated()
        .and()
        .formLogin();

		
         return http.build();
    }
}
