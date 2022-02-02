package com.ip.CaffeMachine.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.ip.CaffeMachine.MqttGateway;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ip.CaffeMachine.CoffeMachineApplication;
import com.ip.CaffeMachine.Exception.CustomException;
import com.ip.CaffeMachine.Models.DrinkEntity;
import com.ip.CaffeMachine.Models.ProgramEntity;
import com.ip.CaffeMachine.Models.UserEntity;
import com.ip.CaffeMachine.Repo.DrinkRepo;
import com.ip.CaffeMachine.Repo.ProgramRepo;
import com.ip.CaffeMachine.Repo.RecipeRepo;
import com.ip.CaffeMachine.Repo.UserRepo;
import com.ip.CaffeMachine.Request.DrinkRequest;
import com.ip.CaffeMachine.Response.DrinkResponse;
import com.ip.CaffeMachine.Response.RecipeResponse;
//ENDPOINTS
@RestController
@RequestMapping("make") //http://localhost:8080/make + ....
public class MakeController {
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ProgramRepo programRepo;
	
	@Autowired
	RecipeRepo recipeRepo;
	
	@Autowired
	DrinkRepo drinkRepo;
	@Autowired
	MqttGateway mqttGateway;
    @GetMapping( 
    			consumes = {MediaType.APPLICATION_JSON_VALUE},
    			produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public DrinkResponse makeDrink(@RequestBody DrinkRequest drink) {
    	// if it's night time do not let the user make coffe
    	// make drink without saving into the database


    	if(!verifyIfIsDay() && verifyIfContainsCoffe(drink)) {
    		throw new CustomException("It's too late for coffee :)");

    	}else {
    	DrinkResponse response = new DrinkResponse();
    	response.setTitle(drink.getTitle());
    	response.setTemperature(drink.getTemperature());
    	response.setLiquid(drink.getLiquid());
    	response.setSugar(drink.getSugar());

    	String description =  recipeRepo.findByTitle(drink.getRecipeTitle()).getDescription();
    	response.setDescription(description);
		mqttGateway.senToMqtt("The drink is done", "mytopic");
    	return response;

    	}
    }
    
    
    @GetMapping(path="/program/{programId}",
			produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public DrinkResponse makeDrinkFromProgram(@PathVariable Long programId) {
    	// if it's night time do not let the user make coffe
    	
    	ProgramEntity program = programRepo.findById(programId).get();
    	DrinkEntity drink = drinkRepo.findById(program.getDrink().getId()).get();
    	
    	ModelMapper modelMapper = new ModelMapper();
    	DrinkRequest requestDrink = modelMapper.map(drink, DrinkRequest.class);
    	
    	if(!verifyIfIsDay() && verifyIfContainsCoffe(requestDrink)){
    		throw new CustomException("It's too late for coffee :)");
    	}else {
    	DrinkResponse response = new DrinkResponse();
    	response.setTitle(drink.getTitle());
    	response.setTemperature(drink.getTemperature());
    	response.setLiquid(drink.getLiquid());
    	response.setSugar(drink.getSugar());
    	
    	String description = drink.getRecipe().getDescription();
    	response.setDescription(description);

		String text;
		text = "The drink from program no. " + programId.toString() + " is done!";
		mqttGateway.senToMqtt(text, "mytopic");
    	return response;
    	}
    }
    
    private boolean verifyIfContainsCoffe(DrinkRequest drink) {
    	ArrayList<String> ingredients = recipeRepo.findByTitle(drink.getRecipeTitle()).getIngredients();
    	for(String ingredient: ingredients) {
    		if(ingredient.equalsIgnoreCase("coffee") || ingredient.contentEquals("espresso") || ingredient.equalsIgnoreCase("espresso")) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private boolean verifyIfIsDay() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");  
		LocalDateTime now = LocalDateTime.now();  
		int currentHour =  Integer.parseInt(dtf.format(now));
		UserEntity currentUser = CoffeMachineApplication.getCurrentUser();
		
		if(currentUser == null) {
			throw new CustomException("You need to be logged in to do this operation!"); 
		}else {
			 if((currentHour >= Integer.parseInt(dtf.format(currentUser.getDayEnd())) && currentHour <= 24) || 
						(currentHour >= 0 && currentHour <= Integer.parseInt(dtf.format(currentUser.getDayStart())))) {
					return false;
				}
		}
		
		return true;
	}
}
