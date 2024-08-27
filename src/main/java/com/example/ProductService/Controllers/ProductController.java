package com.example.ProductService.Controllers;

import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    //will communicate which service class under the interface should be picked up
    @Autowired
    private ProductService productserive;

    @GetMapping("/Products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long productId) throws ProductNotFoundException {
        /*if(productId<1 || productId>20) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }*/



        Product product = productserive.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
    }
}
