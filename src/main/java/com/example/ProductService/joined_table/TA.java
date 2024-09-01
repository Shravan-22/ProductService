package com.example.ProductService.joined_table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@PrimaryKeyJoinColumn(name = "user_id")
@Entity(name="jt_ta")
public class TA extends User {
    private int numberOfQuestions;
    private String college;
}
