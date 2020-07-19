package com.example.springjpatutorial.service;

import com.example.springjpatutorial.entity.User;

import java.util.List;

public interface UserService {
    List<User> fetchAll();

    List<String> getAllUserNames();
}
