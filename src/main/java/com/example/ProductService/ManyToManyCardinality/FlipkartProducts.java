package com.example.ProductService.ManyToManyCardinality;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class FlipkartProducts {
    @Id
    long id;
    String productName;
    @ManyToMany(mappedBy = "p")
    List<FlipkartCategories> c;
}
