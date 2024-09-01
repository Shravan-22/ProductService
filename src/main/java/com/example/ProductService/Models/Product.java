package com.example.ProductService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Product {
    @Id
    private long id;

    private String productName;
    private String productDescription;
    private String description;

}
