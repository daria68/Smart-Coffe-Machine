package com.ip.CaffeMachine.Controller;
import com.ip.CaffeMachine.CoffeMachineApplication;
import com.ip.CaffeMachine.Repo.UserRepo;
import org.springframework.boot.test.context.SpringBootTest;
import com.ip.CaffeMachine.Models.DrinkEntity;
import com.ip.CaffeMachine.Models.ProgramEntity;
import com.ip.CaffeMachine.Models.UserEntity;
import com.ip.CaffeMachine.Repo.DrinkRepo;
import com.ip.CaffeMachine.Repo.ProgramRepo;
import com.ip.CaffeMachine.Repo.RecipeRepo;
import com.ip.CaffeMachine.Request.DrinkRequest;
import com.ip.CaffeMachine.Response.DrinkResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;



import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = CoffeMachineApplication.class)
public class MakeControllerTest {


    @Autowired
    MakeController makeController;

    @Autowired
    RecipeRepo recipeRepo;

    @Autowired
    UserController userController;

    @Autowired
    DrinkRepo drinkRepo;

    @Autowired
    ProgramRepo programRepo;

    @BeforeEach
    void loginUser(){
        UserEntity user = new UserEntity();
        user.setUserId(Long.valueOf(1));
        user.setPassword("123");
        user.setUsername("oana");
        userController.loginUser(user);
    }

    @Test
    void makeDrink() {

        DrinkRequest drinkRequest = new DrinkRequest();
        drinkRequest.setTemperature(40.0);
        drinkRequest.setSugar(2.0);
        drinkRequest.setLiquid("Milk");
        drinkRequest.setTitle("Black");
        drinkRequest.setRecipeTitle("Berry tea");
        DrinkResponse response = makeController.makeDrink(drinkRequest);

        DrinkResponse rsp= new DrinkResponse();
        rsp.setTitle(drinkRequest.getTitle());
        rsp.setTemperature(drinkRequest.getTemperature());
        rsp.setLiquid(drinkRequest.getLiquid());
        rsp.setSugar(drinkRequest.getSugar());

        String description = recipeRepo.findByTitle(drinkRequest.getRecipeTitle()).getDescription();
        rsp.setDescription(description);
        assertEquals(rsp, response);
    }

    @Test
    void makeDrinkFromProgram() {

        Long programId = Long.valueOf(1);
        DrinkResponse drinkResponse = makeController.makeDrinkFromProgram(programId);

        ProgramEntity program = programRepo.findById(programId).get();
        DrinkEntity drink = drinkRepo.findById(program.getDrink().getId()).get();

        DrinkResponse response = new DrinkResponse();
        response.setTitle(drink.getTitle());
        response.setTemperature(drink.getTemperature());
        response.setLiquid(drink.getLiquid());
        response.setSugar(drink.getSugar());

        String description = drink.getRecipe().getDescription();
        response.setDescription(description);
        assertEquals( response, drinkResponse);

    }

}