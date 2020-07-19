package com.example.springjpatutorial.web;

import com.example.springjpatutorial.dao.UserDAO;
import com.example.springjpatutorial.dao.UserRepository;
import com.example.springjpatutorial.entity.User;
import com.example.springjpatutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/users")
    public List<User> users() {
        return userService.fetchAll();
    }

    @GetMapping("/user-namez")
    public List<String> userNames() {
        return userService.getAllUserNames();
    }
}
