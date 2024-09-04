package com.example.ProductService.Services;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("dbImpl")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        /*Optional<Product> op = productRepository.findById(id);
        if (op.isPresent()) {
            Product product = op.get();
            return product;
        }
        else{
            return new ProductNotFoundException("product with id " + id + "is not present");
        }*/
        //the above code is for optional query
        return null;
    }

    @Override
    public Product createProduct(String name, String category, String description) {

        Product product = productRepository.findFirstByNameAndCategory(name, category);
        if (product != null) {
            return product;
        }
        Product p = new Product();
        p.setName(name);
        p.setCategory(category);
        p.setDescription(description);
        p=productRepository.save(p);
        System.out.println(p.getId());
        return p;
    }

    @Override
    public Product getProductWithId(long id) throws ProductNotFoundException {
        Optional<Product> product = Optional.ofNullable(productRepository.findById(id));
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ProductNotFoundException("Product not found with ID: " + id);
        }
    }
}
