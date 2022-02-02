package com.ip.CaffeMachine.Controller;

import com.ip.CaffeMachine.CoffeMachineApplication;
import com.ip.CaffeMachine.Models.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = CoffeMachineApplication.class)
class UserControllerTest {

    @Autowired
    UserController userController;

    @Test
    void loginUser() {
        UserEntity user = new UserEntity();
        user.setUserId(Long.valueOf(1));
        user.setPassword("123");
        user.setUsername("oana");

        String response = userController.loginUser(user);
        assertEquals("User has logged in!", response);
    }
    @Test
    void createUser(){
        UserEntity user = new UserEntity();
        user.setUserId(Long.valueOf(1));
        user.setPassword("123");
        user.setUsername("oana");

        String response = userController.createUser(user);
        assertEquals("This username already exists", response);

    }
}