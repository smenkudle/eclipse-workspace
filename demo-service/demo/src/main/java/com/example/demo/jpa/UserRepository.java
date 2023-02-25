package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserLogin;

@Repository
public interface UserRepository extends JpaRepository<UserLogin, Long> {

}
