package com.example.springjpatutorial.web;

import com.example.springjpatutorial.entity.User;
import com.example.springjpatutorial.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(UserController.class)
class UserControllerTest {

    @MockBean
    private UserService userService;


    @Autowired
    private MockMvc mvc;

    @Test
    void users() throws Exception {
        given(userService.fetchAll()).willReturn(Arrays.asList(
                    new User(1, "Joe", "joe@gmail.com", 12),
                    new User(2, "Lynda", "lynda@gmail.com", 14)
                ));

        mvc.perform(get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("Joe")));

    }

    @Test
    void userNames() {
    }
}