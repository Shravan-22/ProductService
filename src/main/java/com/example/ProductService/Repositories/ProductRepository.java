package com.example.ProductService.Repositories;

import com.example.ProductService.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // select * from products where name = {name} and category = {category}
    Product findFirstByNameAndCategory(String name, String category);

    // Find all products
    // select * from products
    List<Product> findAll();

    // Find product by Id
    // select * from products where id = {id}

    Product findById(long id);

    // Find all products by category
    // select * from products where category = {category}
    List<Product> findAllByCategory(String category);

    //when we dont know if we 1 or 0 then we have to use optional were if it is 1 it gives that output
    //if the id is not present then it will return null instead of error

    //Optional<Product> findById(long id);


    //select category, name from products p
    List<Product> findAllByCategoryAndName(String category, String name);

    //select name from products p where name LIKE "%de%"
    List<Product> findAllByNameLike(String word);

    //when you want your own query then you can write in below format for HQL query were we class name for retrieving the data
    @Query("select p from Products p where p.id = :id")
    Product SelectById(long id);//we can write anything we want here


    //when you want you wn query you can write int eh format for SQL query
    @Query(value = "select * from Products p where p.id = :id", nativeQuery = true)
    Product SelectById2(long id);
}
