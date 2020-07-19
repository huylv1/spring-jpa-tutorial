package com.example.springjpatutorial.dao;

import com.example.springjpatutorial.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository
        extends JpaRepository<User, Integer> {

    @Query("from User u")
    public List<User> fetchAll();
}