package com.example.ProductService.mapped_super_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name="msc_ta")
public class TA extends User {
    private int numberOfQuestions;
    private String college;
}
