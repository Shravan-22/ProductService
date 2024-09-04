package com.example.ProductService.OneToManyCardinality;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Batch {
    @Id
    long id;
    String name;
    @OneToMany(mappedBy = "b")
    List<Learner> l;
}
