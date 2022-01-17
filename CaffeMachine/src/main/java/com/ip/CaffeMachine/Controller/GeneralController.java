package com.ip.CaffeMachine.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ip.CaffeMachine.Models.CoffeRecipeEntity;
import com.ip.CaffeMachine.Models.UserEntity;
import com.ip.CaffeMachine.Repo.CoffeRecipeRepo;
import com.ip.CaffeMachine.Repo.UserRepo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    CoffeRecipeRepo coffeRecipeRepo;

    @GetMapping(path = "/welcome")
    public String getPage() {
        return "Welcome";
    }
    
    // TODO: de apelat la deschiderea aplicatiei + de verificat daca exista deja in baza de date
    @PostMapping(path = "/SampleAPI")
    public void processSampleAPI() {
    	ModelMapper modelMapper = new ModelMapper();
    	
    	final String uri = "https://api.sampleapis.com/coffee/hot";
        RestTemplate restTemplate = new RestTemplate();
        ArrayList result = restTemplate.getForObject(uri, ArrayList.class);
        
        for(Object obj: result) {
        	CoffeRecipeEntity coffe = modelMapper.map(obj, CoffeRecipeEntity.class);
        	// save into the database
            coffeRecipeRepo.save(coffe);
        }
    }
    
    @GetMapping(path = "/coffe_recipe/{id}")
	public String updateUser (@PathVariable Long id){
    	// get the first ingredient from a type of coffe
    	
		CoffeRecipeEntity coffe = coffeRecipeRepo.findById(id).get();
		ArrayList array = coffe.getIngredients();
	
		return array.get(0).toString();
	}
}
