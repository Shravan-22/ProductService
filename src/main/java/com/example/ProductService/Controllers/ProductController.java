package com.example.ProductService.Controllers;

import com.example.ProductService.DTO.CreateProductRequestDto;
import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Services.ProductService;
import com.example.ProductService.Services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Products")
@RestController
public class ProductController {
    //will communicate which service class under the interface should be picked up
    @Autowired
    @Qualifier("dbImpl")
    private ProductService productserive;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long productId) throws ProductNotFoundException {
        /*if(productId<1 || productId>20) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }*/



        Product product = productserive.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(200));
    }

    @PostMapping()
    public Product createProduct(@RequestBody CreateProductRequestDto RequestDto) {
        System.out.println(RequestDto);
        return productserive.createProduct(RequestDto.getName(), RequestDto.getCategory(),
                RequestDto.getDescription());
    }

    /*@GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) throws ProductNotFoundException {
        Product product = productserive.getProductWithId(productId);
        return ResponseEntity.ok(product);
    }*/


    //pagination
    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(
            @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum
    ) {
        Page<Product> products = productserive.getAllProducts(pageSize, pageNum);
        return ResponseEntity.ok(products);
    }

}
