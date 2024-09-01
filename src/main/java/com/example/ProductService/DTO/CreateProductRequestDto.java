package com.example.ProductService.DTO;

import lombok.Data;

@Data
public class CreateProductRequestDto {
    String name;
    String category;
    String description;
}
