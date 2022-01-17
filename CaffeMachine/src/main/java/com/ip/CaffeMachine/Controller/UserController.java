package com.ip.CaffeMachine.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ip.CaffeMachine.Models.UserEntity;
import com.ip.CaffeMachine.Repo.UserRepo;

//ENDPOINTS
@RestController
@RequestMapping("users") //http://localhost:8080/users + ....
public class UserController {

	@Autowired
	UserRepo userRepo;

	/*@GetMapping(value = "/findAll")
	public List<UserEntity> getUsers(){
		// we don't need them in the project
		return userRepo.findAll();
	}*/
	
	@PostMapping(path = "/new",
				consumes = {MediaType.APPLICATION_JSON_VALUE} // good practice: sometimes Postman confuses them with XMLs (Oana)
	)
	public String createUser(@RequestBody UserEntity user){
		userRepo.save(user);
		return "Created a new user!";
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
}
