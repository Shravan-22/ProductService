package com.example.ProductService.OneToOneCardinality;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Wife {
    @Id
    long id;
    String name;
    @OneToOne
    Husband h;
}
