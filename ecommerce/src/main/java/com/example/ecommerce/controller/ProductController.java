package com.example.ecommerce.controller;


import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/cart")
    public List<CartItem> viewCart() {
        return service.getCart();
    }

    @PostMapping("/cart/{productId}")
    public void addToCart(@PathVariable Long productId) {
        service.addToCart(productId);
    }

    @DeleteMapping("/cart/{productId}")
    public void removeFromCart(@PathVariable Long productId) {
        service.removeFromCart(productId);
    }
}
