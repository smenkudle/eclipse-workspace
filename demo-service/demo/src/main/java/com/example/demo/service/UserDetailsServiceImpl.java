package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.jpa.UserRepository;
import com.example.demo.model.UserLogin;

@Service
@Profile(value = "sit")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println("Inside loadUserByUsername: " + username);
		List<UserLogin> list = userRepository.findAll();

		boolean userFound = false;
		UserLogin userLogin = null;

		for (UserLogin user : list) {
			System.out.println("User details: " + user);
			if (user.getUsername().equalsIgnoreCase(username)) {
				userFound = true;
				userLogin = user;
			}
		}

		if (!userFound) {
			new UsernameNotFoundException("User Not Found with username: " + username);
		}

		return UserDetailsImpl.build(userLogin);
	}

}
