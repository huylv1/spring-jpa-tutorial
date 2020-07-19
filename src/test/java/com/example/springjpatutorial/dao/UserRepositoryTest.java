package com.example.springjpatutorial.dao;

import com.example.springjpatutorial.CustomExtension;
import com.example.springjpatutorial.entity.User;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Tag("repository")
@ExtendWith(CustomExtension.class)
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