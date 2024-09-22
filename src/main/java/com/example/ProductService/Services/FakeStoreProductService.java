package com.example.ProductService.Services;

import com.example.ProductService.DTO.FakeStoreDto;
import com.example.ProductService.Exceptions.ProductNotFoundException;
import com.example.ProductService.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service("fakestr")
public class FakeStoreProductService implements ProductService{

    @Override
    public Product getProductById(long id) throws ProductNotFoundException{
        //take the id from the controller/input, and call this endpoint:a
        //https://fakestoreapi.com/products/ + id
        String url = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = new RestTemplate();//we are getting the data from a different API
        FakeStoreDto fakestoreDto = restTemplate.getForObject(url, FakeStoreDto.class);
        //in the above line we are getting the data from API and storing it in DTO class for which ever data we asked for
        if(fakestoreDto == null){
            throw new ProductNotFoundException("Product with id:" + id + " not found");
        }
        return getFakeProduct(fakestoreDto);
    }

    @Override
    public Product createProduct(String name, String category, String description) {
        return null;
    }

    @Override
    public Product getProductWithId(long id) {
        return null;
    }

    @Override
    public Page<Product> getAllProducts(int pageSize, int pageNum) {
        return null;
    }

    //now we have to return the Models product type but we have the data in DTO type we have
    //to convert the DTO to product now

    private Product getFakeProduct(FakeStoreDto dto) {
        Product product = new Product();
        product.setName(dto.getCategory());
        product.setCategory(dto.getDescription());
        product.setDescription(dto.getTitle());
        return product;
    }
}
