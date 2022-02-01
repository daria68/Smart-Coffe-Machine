package com.ip.CaffeMachine.Controller;

import com.ip.CaffeMachine.Models.DrinkEntity;
import com.ip.CaffeMachine.Models.ProgramEntity;
import com.ip.CaffeMachine.Models.UserEntity;
import com.ip.CaffeMachine.Repo.DrinkRepo;
import com.ip.CaffeMachine.Repo.ProgramRepo;
import com.ip.CaffeMachine.Repo.RecipeRepo;
import com.ip.CaffeMachine.Request.ProgramRequest;
import com.ip.CaffeMachine.Response.ProgramResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.test.context.support.WithMockUser;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ProgramControllerTest {

    @Autowired
    UserController userController;

    @Autowired
    ProgramController programController;
    @Autowired
    ProgramRepo programRepo;
    @Autowired
    RecipeRepo recipeRepo;

    @BeforeEach
    void loginUser(){
        UserEntity user = new UserEntity();
        user.setUserId(Long.valueOf(1));
        user.setPassword("123");
        user.setUsername("oana");

        userController.loginUser(user);
    }

   //@WithMockUser(username = "oana", password = "123")
    @Test
    void createProgram() {
        ProgramEntity program = new ProgramEntity();
        DrinkEntity drink = new DrinkEntity();
        drink.setTemperature(40.0);
        drink.setSugar(2.0);
        drink.setLiquid("Milk");
        drink.setTitle("Black");
        drink.setRecipe( recipeRepo.findByTitle("Black"));

        program.setDrink(drink);
        ModelMapper modelMapper = new ModelMapper();
        ProgramRequest p = modelMapper.map(program, ProgramRequest.class);
        String response = programController.createProgram(p);

        assertEquals("New program was created!", response);
    }

    @Test
    void getProgram(){
        Long programId = Long.valueOf(1);

        Optional<ProgramEntity> u = programRepo.findById(programId);
        ProgramEntity program = u.get();
        ModelMapper modelMapper = new ModelMapper();
        ProgramResponse response = modelMapper.map(program, ProgramResponse.class);

        ProgramResponse rsp = programController.getProgram(programId);
        assertEquals(response, rsp);
    }
}