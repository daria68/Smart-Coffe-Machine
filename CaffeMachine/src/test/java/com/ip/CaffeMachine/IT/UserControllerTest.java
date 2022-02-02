package com.ip.CaffeMachine.IT;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ip.CaffeMachine.CoffeMachineApplication;
import com.ip.CaffeMachine.Models.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = CoffeMachineApplication.class)
class UserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void createUser() throws Exception {

        UserEntity user = new UserEntity();
        user.setPassword("123");
        user.setUsername("oana");
        String jsonRequest = mapper.writeValueAsString(user);

        MvcResult result = mockMvc
                .perform(post("/users/register").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andReturn();
        assertEquals("This username already exists", result.getResponse().getContentAsString());
    }
    @Test
    void loginUser() throws Exception {

        UserEntity user = new UserEntity();
        user.setPassword("123");
        user.setUsername("oana");
        String jsonRequest = mapper.writeValueAsString(user);

        MvcResult result = mockMvc
                .perform(get("/users/login").content(jsonRequest).contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andReturn();
        assertEquals("User has logged in!", result.getResponse().getContentAsString());

    }


    @Test
    public void givenHomePageURI_whenMockMVC() throws Exception {
        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(get("/welcome")).andExpect(status().isOk()).andReturn();
         assertEquals("Welcome",mvcResult.getResponse().getContentAsString());
    }



}