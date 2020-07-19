package com.example.springjpatutorial.service.impl;

import com.example.springjpatutorial.dao.UserDAO;
import com.example.springjpatutorial.dao.UserRepository;
import com.example.springjpatutorial.entity.User;
import com.example.springjpatutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> fetchAll() {
        return userRepository.fetchAll();
    }

    @Override
    public List<String> getAllUserNames() {
        return userDAO.getAllUserNames();
    }
}
