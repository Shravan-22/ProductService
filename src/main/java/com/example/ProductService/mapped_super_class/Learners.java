package com.example.ProductService.mapped_super_class;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity(name="msc_learners")
public class Learners extends User {
    private String college;
    private String company;
}
