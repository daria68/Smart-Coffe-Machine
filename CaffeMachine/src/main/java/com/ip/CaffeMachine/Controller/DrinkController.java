package com.ip.CaffeMachine.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ip.CaffeMachine.Repo.CoffeRecipeRepo;
import com.ip.CaffeMachine.Repo.UserRepo;

//ENDPOINTS
@RestController
@RequestMapping("drinks") //http://localhost:8080/drinks + ....
public class DrinkController {
	@Autowired
    UserRepo userRepo;
    
    @Autowired
    CoffeRecipeRepo coffeRecipeRepo;
}
