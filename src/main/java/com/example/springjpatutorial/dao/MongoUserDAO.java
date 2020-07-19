package com.example.springjpatutorial.dao;

import java.util.Arrays;
import java.util.List;

public class MongoUserDAO  implements UserDAO {
    @Override
    public List<String> getAllUserNames() {
        System.out.println("**** Getting usernames from MongoDB *****");
        return Arrays.asList("Bond","James","Bond");
    }
}