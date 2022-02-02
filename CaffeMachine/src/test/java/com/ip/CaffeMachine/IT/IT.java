package com.ip.CaffeMachine.IT;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ip.CaffeMachine.CoffeMachineApplication;
import com.ip.CaffeMachine.Controller.UserController;
import com.ip.CaffeMachine.Models.DrinkEntity;
import com.ip.CaffeMachine.Models.ProgramEntity;
import com.ip.CaffeMachine.Models.UserEntity;
import com.ip.CaffeMachine.Repo.DrinkRepo;
import com.ip.CaffeMachine.Repo.ProgramRepo;
import com.ip.CaffeMachine.Repo.RecipeRepo;
import com.ip.CaffeMachine.Request.DrinkRequest;
import com.ip.CaffeMachine.Request.ProgramRequest;
import com.ip.CaffeMachine.Response.DrinkResponse;
import com.ip.CaffeMachine.Response.ProgramResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest(classes = CoffeMachineApplication.class)
class IT {

    @Autowired
    private WebApplicationContext webApplicationContext;
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    DrinkRepo drinkRepo;

    @Autowired
    ProgramRepo programRepo;

    @Autowired
    RecipeRepo recipeRepo;

    @Autowired
    UserController userController;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    @BeforeEach
    void loginUser(){
        UserEntity user = new UserEntity();
        user.setUserId(Long.valueOf(1));
        user.setPassword("123");
        user.setUsername("oana");
        userController.loginUser(user);
    }


    @Test
    void makeDrink_addProgram_getProgram() throws Exception {
        DrinkRequest drinkRequest = new DrinkRequest();
        drinkRequest.setTemperature(40.0);
        drinkRequest.setSugar(2.0);
        drinkRequest.setLiquid("Milk");
        drinkRequest.setTitle("Black");
        drinkRequest.setRecipeTitle("Berry tea");
        String jsonRequest = mapper.writeValueAsString(drinkRequest);
        MvcResult result = mockMvc
                .perform(get("/make").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andReturn();

        ModelMapper modelMapper = new ModelMapper();
        DrinkEntity drink= modelMapper.map(result.getResponse().getContentAsString(), DrinkEntity.class);

        ProgramEntity program = new ProgramEntity();
        program.setId(2L);
        program.setDrink(drink);


        ProgramRequest p = modelMapper.map(program, ProgramRequest.class);
        String jsonRequest2 = mapper.writeValueAsString(p);

        MvcResult result2 = mockMvc
                .perform(post("/programs/create").content(jsonRequest2).contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andReturn();

        Long programId = program.getId();

        MvcResult result3 = mockMvc
                .perform(get("/programs/{programId}",String.valueOf(programId)).contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andReturn();

        Optional<ProgramEntity> u = programRepo.findById(programId);
        ProgramEntity prg = u.get();
        ProgramResponse response = modelMapper.map(prg, ProgramResponse.class);
        String stringResponse = mapper.writeValueAsString(response);
        assertEquals(stringResponse, result3.getResponse().getContentAsString());
    }

    @Test
    void createUser_loginUser() throws Exception {
        UserEntity user = new UserEntity();
        user.setPassword("1234");
        user.setUsername("oana_2");
        String jsonRequest = mapper.writeValueAsString(user);

        MvcResult result = mockMvc
                .perform(post("/users/register").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andReturn();

        MvcResult result2 = mockMvc
                .perform(get("/users/login").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andReturn();
        assertEquals("User has logged in!", result2.getResponse().getContentAsString());

    }
   @Test
    void loginUser_makeDrinkFromProgram() throws Exception {
       UserEntity user = new UserEntity();
       user.setPassword("123");
       user.setUsername("oana");
       String jsonRequest = mapper.writeValueAsString(user);
       MvcResult result2 = mockMvc
               .perform(get("/users/login").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andDo(print())
               .andReturn();

       Long programId = Long.valueOf(1);
       ProgramEntity program = programRepo.findById(programId).get();
       DrinkEntity drink = drinkRepo.findById(program.getDrink().getId()).get();
       DrinkResponse response = new DrinkResponse();
       response.setTitle(drink.getTitle());
       response.setTemperature(drink.getTemperature());
       response.setLiquid(drink.getLiquid());
       response.setSugar(drink.getSugar());
       String description = drink.getRecipe().getDescription();
       response.setDescription(description);

       String stringResponse = mapper.writeValueAsString(response);

       MvcResult result = mockMvc
               .perform(get("/make/program/{programId}",String.valueOf(programId)).contentType(MediaType.APPLICATION_JSON)).andDo(print())
               .andReturn();
       assertEquals(stringResponse, result.getResponse().getContentAsString());
   }

}