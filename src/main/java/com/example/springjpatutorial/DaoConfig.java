package com.example.springjpatutorial;

import com.example.springjpatutorial.dao.DatabaseType;
import com.example.springjpatutorial.dao.JdbcUserDAO;
import com.example.springjpatutorial.dao.MongoUserDAO;
import com.example.springjpatutorial.dao.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {
    @Bean
    @DatabaseType("MYSQL")
    public UserDAO jdbcUserDAO(){
        return new JdbcUserDAO();
    }

    @Bean
    @DatabaseType("MONGO")
    public UserDAO mongoUserDAO(){
        return new MongoUserDAO();
    }
}
