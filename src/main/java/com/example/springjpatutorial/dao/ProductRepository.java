package com.example.springjpatutorial.dao;


import com.example.springjpatutorial.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Integer> { }

