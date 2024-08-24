package com.example.ProductService.Services;

import com.example.ProductService.DTO.FakeStoreDto;
import com.example.ProductService.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{

    @Override
    public Product getProductById(long id) {
        //take the id from the controller/input, and call this endpoint:a
        //https://fakestoreapi.com/products/ + id
        String url = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = new RestTemplate();//we are getting the data from a different API
        FakeStoreDto fakestoreDto = restTemplate.getForObject(url, FakeStoreDto.class);
        //in the above line we are getting the data from API and storing it in DTO class for which ever data we asked for
        return getFakeProduct(fakestoreDto);
    }

    //now we have to return the Models product type but we have the data in DTO type we have
    //to convert the DTO to product now

    private Product getFakeProduct(FakeStoreDto dto) {
        Product product = new Product();
        product.setProductName(dto.getCategory());
        product.setProductDescription(dto.getDescription());
        product.setDescription(dto.getTitle());
        return product;
    }
}
