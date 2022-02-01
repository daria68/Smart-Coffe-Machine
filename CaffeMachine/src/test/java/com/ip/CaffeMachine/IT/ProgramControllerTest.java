package com.ip.CaffeMachine.IT;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ip.CaffeMachine.Controller.UserController;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
class ProgramControllerTest {

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
        user.setPassword("123");
        user.setUsername("oana");
        userController.loginUser(user);
    }

    @Test
    void createProgram() throws Exception {
        ProgramEntity program = new ProgramEntity();
        DrinkEntity drink = new DrinkEntity();
        drink.setTemperature(40.0);
        drink.setSugar(2.0);
        drink.setLiquid("Milk");
        drink.setTitle("Black");
        program.setDrink(drink);

        ModelMapper modelMapper = new ModelMapper();
        ProgramRequest p = modelMapper.map(program, ProgramRequest.class);
        String jsonRequest = mapper.writeValueAsString(p);

        MvcResult result = mockMvc
                .perform(post("/programs/create").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andReturn();

        assertEquals("New program was created!", result.getResponse().getContentAsString());

    }

    @Test
    void getProgram() throws Exception {

        Long programId = Long.valueOf(1);

        Optional<ProgramEntity> u = programRepo.findById(programId);
        ProgramEntity program = u.get();
        ModelMapper modelMapper = new ModelMapper();
        ProgramResponse response = modelMapper.map(program, ProgramResponse.class);
        String stringResponse = mapper.writeValueAsString(response);
        MvcResult result = mockMvc
                .perform(get("/programs/{programId}",String.valueOf(programId)).contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andReturn();
        assertEquals(stringResponse, result.getResponse().getContentAsString());

    }
}