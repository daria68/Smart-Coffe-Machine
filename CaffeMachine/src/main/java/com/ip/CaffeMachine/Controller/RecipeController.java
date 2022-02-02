package com.ip.CaffeMachine.Controller;

import java.io.IOException;
import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ip.CaffeMachine.Models.RecipeEntity;
import com.ip.CaffeMachine.Repo.RecipeRepo;
import com.ip.CaffeMachine.Repo.UserRepo;

@RestController
@RequestMapping("recipes")
public class RecipeController {

	@Autowired
	UserRepo userRepo;
    
    @Autowired
    RecipeRepo recipeRepo;
    
    @PostMapping(path = "/insert")
    public void processSampleAPI() {
    	ArrayList<RecipeEntity> list = (ArrayList<RecipeEntity>) recipeRepo.findAll();
    	if(list.isEmpty()) {
	    	ModelMapper modelMapper = new ModelMapper();
	    	
	    	final String uri = "https://api.sampleapis.com/coffee/hot";
	        RestTemplate restTemplate = new RestTemplate();
	        ArrayList result = restTemplate.getForObject(uri, ArrayList.class);
	        
	        // read de coffe recipes from the API
	        for(Object obj: result) {
	        	RecipeEntity coffe = modelMapper.map(obj, RecipeEntity.class);
	        	if(coffe.getTitle()== "" || coffe.getTitle().equals("puro")) {
	        		continue;
	        	}
	        	// save into the database
	        	recipeRepo.save(coffe);
	        }
	
	        try {
	        	ObjectMapper mapper = new ObjectMapper();
	            ArrayList l = mapper.readValue(ResourceUtils.getFile("classpath:drinks.json"), ArrayList.class);
	            for(Object obj: l) {
	            	RecipeEntity drink = modelMapper.map(obj, RecipeEntity.class);
	            	if(drink.getTitle()== "") {
	            		continue;
	            	}
	            	// save into the database
	            	recipeRepo.save(drink);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	       
	    }
    }
}
