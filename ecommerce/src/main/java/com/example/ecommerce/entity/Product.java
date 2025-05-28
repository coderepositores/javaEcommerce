package com.example.ecommerce.entity;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private double price;

    public Long getId(){
        return  id;
    }
    public String getName(){
        return name;
    }
    public  double getPrice(){
        return price;
    }
    public void setId(Long id){
        id = this.id;
    }
    public void setName(String name){
        name = this.name;
    }
    public  void setPrice(double price){
        price = this.price;
    }

}
