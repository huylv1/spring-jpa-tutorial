package com.example.springjpatutorial.service.impl;

import com.example.springjpatutorial.dao.UserRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@Tag("service")
class UserServiceImplTest {

    @MockBean
    private UserRepository userRepository;

    @Test
    void fetchAll() {

    }
}