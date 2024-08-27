package com.example.ProductService.Services;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Models.Product;

public interface ProductService {

    public Product getProductById(long id) throws ProductNotFoundException;
}
