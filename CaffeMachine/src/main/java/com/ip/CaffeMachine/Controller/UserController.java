package com.ip.CaffeMachine.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ip.CaffeMachine.CoffeMachineApplication;
import com.ip.CaffeMachine.Exception.CustomException;
import com.ip.CaffeMachine.Models.UserEntity;
import com.ip.CaffeMachine.Repo.UserRepo;
import com.ip.CaffeMachine.Request.DayIntervalRequest;

//ENDPOINTS
@RestController
@RequestMapping("users") //http://localhost:8080/users + ....
public class UserController {

	@Autowired
	UserRepo userRepo;
	
	@PostMapping(path = "/register",
				consumes = {MediaType.APPLICATION_JSON_VALUE} // good practice: sometimes Postman confuses them with XMLs (Oana)
	)
	public String createUser(@RequestBody UserEntity user){
		if(userRepo.findByUsername(user.getUsername())!= null) {
			return "This username already exists";
		}
	
		userRepo.save(user);
		return "New user has been created!";
	}
	
	@GetMapping(path = "/login",
			consumes = {MediaType.APPLICATION_JSON_VALUE} 
	)
	public String loginUser(@RequestBody UserEntity user){
		List<UserEntity> allUsers = userRepo.findAll();
		
		for(UserEntity u : allUsers) {
			if(user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword())) {
				CoffeMachineApplication.setCurrentUser(u);
				return "User has logged in!";
			}
		}
		
		return "User doesn't exists or the password is incorect!";
		
	}
	
	@GetMapping(path = "/logout")
	public String logoutUser(){
		CoffeMachineApplication.setCurrentUser(null);
		return "You logged out! See you next time :)";
		
	}
	
	@PutMapping(path = "/update/{id}", 
				consumes = {MediaType.APPLICATION_JSON_VALUE}
	)
	public String updateUser (@PathVariable long id, @RequestBody UserEntity user){
		UserEntity updatedUser = userRepo.findById(id).get();
		updatedUser.setUsername(user.getUsername());
		userRepo.save(updatedUser);

		return "User updated!";
	}
	
	@DeleteMapping(path = "/delete/{id}", 
				   consumes = {MediaType.APPLICATION_JSON_VALUE}
	)
	public String deleteUser(@PathVariable long id){
		UserEntity deleteUser = userRepo.findById(id).get();
		userRepo.delete(deleteUser);
		return "User has been deleted!";
	}
	
	@PutMapping(path= "/day/interval", 
			consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public String updateInterval(@RequestBody DayIntervalRequest interval) {
    	UserEntity currentUser = CoffeMachineApplication.getCurrentUser();
    	if(currentUser == null) {
			throw new CustomException("You need to be logged in to do this operation!"); 
		}
    	UserEntity updatedUser = userRepo.findById(currentUser.getUserId()).get();
		
    	updatedUser.setDayStart(interval.getDayStart());
    	updatedUser.setDayEnd(interval.getDayEnd());
    	userRepo.save(updatedUser);
    	return "Your day interval has been set";
    }
}
