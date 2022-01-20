package com.ip.CaffeMachine;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ip.CaffeMachine.Models.UserEntity;

@SpringBootApplication
public class CoffeMachineApplication {

	private static UserEntity currentUser = null;
	
	public static void main(String[] args) {
		SpringApplication.run(CoffeMachineApplication.class, args);
	}
	
	public static void setCurrentUser(UserEntity user) {
		currentUser = user;
	}
	
	public static UserEntity getCurrentUser() {
		return currentUser;
	}
	
}
