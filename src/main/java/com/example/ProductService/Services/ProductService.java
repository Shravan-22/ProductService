package com.example.ProductService.Services;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Models.Product;
import org.springframework.data.domain.Page;


public interface ProductService {

    public Product getProductById(long id) throws ProductNotFoundException;

    public Product createProduct(String name, String category,
                                        String description);

    public Product getProductWithId(long id) throws ProductNotFoundException;

    public Page<Product> getAllProducts(int pageSize, int pageNum);
}
