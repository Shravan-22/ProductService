package com.example.ProductService.ManyToManyCardinality;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class FlipkartCategories {
    @Id
    long id;
    String categoryName;

    @ManyToMany
    List<FlipkartProducts> p;
}
