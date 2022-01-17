package com.ip.CaffeMachine;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ip.CaffeMachine.Models.UserEntity;

@SpringBootApplication
public class CoffeMachineApplication {

	private static UserEntity currentUser = null;
	
	public static void main(String[] args) {
		//System.out.println(verifyIfIsDay());
		SpringApplication.run(CoffeMachineApplication.class, args);
	}
	
	public static void setCurrentUser(UserEntity user) {
		currentUser = user;
	}
	
	public static UserEntity getCurrentUser() {
		return currentUser;
	}
	
	public static boolean verifyIfIsDay() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");  
		LocalDateTime now = LocalDateTime.now();  
		int currentHour =  Integer.parseInt(dtf.format(now));
		if(currentHour > 19 && currentHour < 5) {
			// the night period is between: 7 PM and 5 AM
			return false;
		}
		return true;
	}

}
