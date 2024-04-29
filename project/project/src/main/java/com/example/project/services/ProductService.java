package com.example.project.services;

import com.example.project.models.Product;

import java.util.List;

public interface ProductService {
    public Product geSingleProduct(Long id);
    public Product createProduct(String title, String description, String image, String Category, double price);
    public List<Product> getAllProducts();
}
