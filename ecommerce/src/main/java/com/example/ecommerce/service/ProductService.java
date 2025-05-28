package com.example.ecommerce.service;

import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepo;
    private final CartRepository cartRepo;

    public ProductService(ProductRepository productRepo, CartRepository cartRepo) {
        this.productRepo = productRepo;
        this.cartRepo = cartRepo;
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public List<CartItem> getCart() {
        return cartRepo.findAll();
    }

    public void addToCart(Long productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        CartItem cartItem = cartRepo.findByProductId(productId);
        if (cartItem == null) {
            cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        }
        cartRepo.save(cartItem);
    }

    public void removeFromCart(Long productId) {
        CartItem cartItem = cartRepo.findByProductId(productId);
        if (cartItem != null) {
            cartRepo.delete(cartItem);
        }
    }
}
