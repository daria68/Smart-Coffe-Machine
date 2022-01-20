package com.ip.CaffeMachine.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ip.CaffeMachine.CoffeMachineApplication;
import com.ip.CaffeMachine.Exception.CustomException;
import com.ip.CaffeMachine.Models.ProgramEntity;
import com.ip.CaffeMachine.Models.RecipeEntity;
import com.ip.CaffeMachine.Models.UserEntity;
import com.ip.CaffeMachine.Repo.ProgramRepo;
import com.ip.CaffeMachine.Repo.RecipeRepo;
import com.ip.CaffeMachine.Repo.UserRepo;
import com.ip.CaffeMachine.Request.ProgramRequest;
import com.ip.CaffeMachine.Response.ProgramResponse;

//ENDPOINTS
@RestController
@RequestMapping("programs") //http://localhost:8080/programs + ....
public class ProgramController {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ProgramRepo programRepo;
	
	@Autowired
	RecipeRepo recipeRepo;
	
	@PostMapping(path= "/create", 
			consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public String createProgram(@RequestBody ProgramRequest program) {
    	UserEntity currentUser = CoffeMachineApplication.getCurrentUser();
    	if(currentUser == null) {
			throw new CustomException("You need to be logged in to do this operation!"); 
		}
    	
    	ModelMapper modelMapper = new ModelMapper();
    	ProgramEntity p = modelMapper.map(program, ProgramEntity.class);
    	p.setUser(currentUser);
    	
    	if(program.getRecipeTitle()!= null && program.getPersonalizedDrink()!= null) {
    		return "You need to choose one of them!";
    	}
    	
    	if(program.getRecipeTitle()== null && program.getPersonalizedDrink()== null) {
    		return "You need to choose one of them!";
    	}
    	
    	if(program.getRecipeTitle()!= null) {
    		RecipeEntity recipe = recipeRepo.findByTitle(program.getRecipeTitle());
    		p.setRecipe(recipe);
    	}else{
    		p.setPersonalizedDrink(program.getPersonalizedDrink());
    	}
    	
    	programRepo.save(p);
    	
    	return "New program was created!";
    }
	
	@GetMapping(path= "/{programId}", 
			produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ProgramResponse getProgram(@PathVariable Long programId) {
    	UserEntity currentUser = CoffeMachineApplication.getCurrentUser();
    	if(currentUser == null) {
			throw new CustomException("You need to be logged in to do this operation!"); 
		}
    	ModelMapper modelMapper = new ModelMapper();
    	ProgramEntity program = programRepo.findById(programId).get();
    	if(program == null) {
    		throw new CustomException("The program doesn't exists in the DB");
    	}
    	ProgramResponse response = modelMapper.map(program, ProgramResponse.class);
    	
    	return response;
    }
	
	@PutMapping(path= "/update/{programId}", 
			consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public String updateProgram(@PathVariable Long programId, @RequestBody ProgramRequest program) {
    	UserEntity currentUser = CoffeMachineApplication.getCurrentUser();
    	if(currentUser == null) {
			throw new CustomException("You need to be logged in to do this operation!"); 
		}
    	ProgramEntity updatedProgram = programRepo.findById(programId).get();
    	updatedProgram.setDay(program.getDay());
    	updatedProgram.setPersonalizedDrink(program.getPersonalizedDrink());
    	updatedProgram.setRecipe(recipeRepo.findByTitle(program.getRecipeTitle()));
    	updatedProgram.setStartingTime(program.getStartingTime());
    	
    	programRepo.save(updatedProgram);
    	
    	return "Program was updated!";
    }
	
	@DeleteMapping(path = "/delete/{programId}")
	public String deleteUser(@PathVariable Long programId){
		ProgramEntity deleteProgram = programRepo.findById(programId).get();
		programRepo.delete(deleteProgram);
		return "Program has been deleted!";
	}
}
