package com.example.ProductService.OneToManyCardinality;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Learner {
    @Id
    long id;
    String name;
    @ManyToOne
    Batch b;
}
