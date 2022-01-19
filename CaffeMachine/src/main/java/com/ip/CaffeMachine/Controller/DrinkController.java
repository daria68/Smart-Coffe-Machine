package com.ip.CaffeMachine.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ip.CaffeMachine.CoffeMachineApplication;
import com.ip.CaffeMachine.Exception.CustomException;
import com.ip.CaffeMachine.Models.UserEntity;
import com.ip.CaffeMachine.Repo.RecipeRepo;
import com.ip.CaffeMachine.Repo.UserRepo;
import com.ip.CaffeMachine.Request.DrinkRequest;
import com.ip.CaffeMachine.Response.DrinkResponse;
//ENDPOINTS
@RestController
@RequestMapping("drinks") //http://localhost:8080/drinks + ....
public class DrinkController {
	@Autowired
    UserRepo userRepo;
    
    @Autowired
    RecipeRepo recipeRepo;
    
    @GetMapping(path= "/make", 
    			consumes = {MediaType.APPLICATION_JSON_VALUE},
    			produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public DrinkResponse makeDrink(@RequestBody DrinkRequest drink) {
    	// if it's night time do not let the user make coffe
    	if(!verifyIfIsDay() && verifyIfContainsCoffe(drink)) {
    		throw new CustomException("It's too late for coffee :)");
    	}else {
    	DrinkResponse response = new DrinkResponse();
    	response.setTitle(drink.getTitle());
    	response.setTemperature(drink.getTemperature());
    	response.setLiquid(drink.getLiquid());
    	response.setSugar(drink.getSugar());
    	String description = recipeRepo.findByTitle(drink.getTitle()).getDescription();
    	response.setDescription(description);
    	return response;
    	}
    }
    
    public boolean verifyIfContainsCoffe(DrinkRequest drink) {
    	ArrayList<String> ingredients = recipeRepo.findByTitle(drink.getTitle()).getIngredients();
    	for(String ingredient: ingredients) {
    		if(ingredient.equalsIgnoreCase("coffee") || ingredient.contentEquals("espresso") || ingredient.equalsIgnoreCase("espresso")) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean verifyIfIsDay() {
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
