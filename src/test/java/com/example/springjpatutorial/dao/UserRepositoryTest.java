package com.example.springjpatutorial.dao;

import com.example.springjpatutorial.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void fetchAll() {
        List<User> users = userRepository.fetchAll();
        then(users).isNotEmpty();
        then(users.size()).isEqualTo(5);
    }
}