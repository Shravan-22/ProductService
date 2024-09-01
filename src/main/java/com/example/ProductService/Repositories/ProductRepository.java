package com.example.ProductService.Repositories;

import com.example.ProductService.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // select * from products where name = {name} and category = {category}
    Product findFirstByNameAndCategory(String name, String category);

    // Find all products
    // select * from products
    List<Product> findAll();

    // Find product by Id
    // select * from products where id = {id}
    Product findById(long id);

    // Find all products by category
    // select * from products where category = {category}
    List<Product> findAllByCategory(String category);
}
