package com.example.ecommerce.entity;

import jakarta.persistence.*;

@Entity
public class CartItem {
    @Id @GeneratedValue
    private Long id;

    @OneToOne
    private Product product;

    private int quantity;

    // Getters & Setters
    public  void setId(Long id){
        id = this.id;
    }
    public void setQuantity(int quantity){
        quantity = this.quantity;
    }
    public void setProduct(Product product){
        product = product;
    }
    public Long getId(){
        return  id;
    }
    public int getQuantity(){
        return  quantity;
    }
    public Product getProduct(){
        return product;
    }
}
