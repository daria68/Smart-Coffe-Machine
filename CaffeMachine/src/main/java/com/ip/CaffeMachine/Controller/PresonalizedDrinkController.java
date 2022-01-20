package com.ip.CaffeMachine.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ip.CaffeMachine.CoffeMachineApplication;
import com.ip.CaffeMachine.Exception.CustomException;
import com.ip.CaffeMachine.Models.ProgramEntity;
import com.ip.CaffeMachine.Models.RecipeEntity;
import com.ip.CaffeMachine.Models.UserEntity;
import com.ip.CaffeMachine.Repo.PersonalizedDrinkRepo;
import com.ip.CaffeMachine.Repo.ProgramRepo;
import com.ip.CaffeMachine.Repo.RecipeRepo;
import com.ip.CaffeMachine.Repo.UserRepo;
import com.ip.CaffeMachine.Request.PersonalizedDrinkRequest;
import com.ip.CaffeMachine.Request.ProgramRequest;

//ENDPOINTS
@RestController
@RequestMapping("personalized") //http://localhost:8080/personalized + ....
public class PresonalizedDrinkController {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ProgramRepo programRepo;
	
	@Autowired
	RecipeRepo recipeRepo;
	
	@Autowired	
	PersonalizedDrinkRepo personalizedDrinkRepo;
	
	@PostMapping(path= "/create", 
			consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public String createPersonalizedDrink(@RequestBody PersonalizedDrinkRequest drink) {
    	UserEntity currentUser = CoffeMachineApplication.getCurrentUser();
    	if(currentUser == null) {
			throw new CustomException("You need to be logged in to do this operation!"); 
		}
    	
//    	ModelMapper modelMapper = new ModelMapper();
//    	ProgramEntity p = modelMapper.map(program, ProgramEntity.class);
    	
//    	programRepo.save(p);
    	
    	return "New personalized drink was created!";
    }
}
