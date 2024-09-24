package com.example.ProductService.OneToManyCardinality;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Entity
public class Batch {
    @Id
    long id;
    String name;
    @OneToMany(mappedBy = "b", cascade = CascadeType.ALL)
    List<Learner> l;
}
//persist = add to both the tables simultaneously
//remove = will delete both from both the tables simultaneously
//merge = will update the existing tables when updated in both tables simultaneously
//ALL = will update irrespective persist, remove, merge it will update any action
