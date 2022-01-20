package com.ip.CaffeMachine.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ip.CaffeMachine.Models.RecipeEntity;
import com.ip.CaffeMachine.Repo.RecipeRepo;
import com.ip.CaffeMachine.Repo.UserRepo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("")
//Every request handling method of the controller class automatically serializes return objects into HttpResponse.
public class GeneralController {
    @Autowired
    UserRepo userRepo;
    
    @Autowired
    RecipeRepo recipeRepo;

    @GetMapping(path = "/welcome")
    public String getPage() {
        return "Welcome";
    }
    
    // TODO: de apelat la deschiderea aplicatiei + de verificat daca exista deja in baza de date
    @PostMapping(path = "/insert/recipes")
    public void processSampleAPI() {
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
            ArrayList list = mapper.readValue(ResourceUtils.getFile("classpath:drinks.json"), ArrayList.class);
            for(Object obj: list) {
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
