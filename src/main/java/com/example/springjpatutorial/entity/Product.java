package com.example.springjpatutorial.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Product")
public class Product {

    @Id
    private int id;

    private String name;

    private double price;
}
