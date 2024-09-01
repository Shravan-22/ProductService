package com.example.ProductService.joined_table;

import jakarta.persistence.*;
import lombok.Data;

//@Setter
//@Getter
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name="jt_users")
public class User {
    @Id
    private int id;
    private String name;
    private String password;
    private String email;

}