package com.ip.CaffeMachine.Controller;

import com.ip.CaffeMachine.Repo.RecipeRepo;
import com.ip.CaffeMachine.Repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

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
    
}
