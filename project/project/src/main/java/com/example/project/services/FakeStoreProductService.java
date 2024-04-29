package com.example.project.services;

import com.example.project.dtos.FakeStoreProductDto;
import com.example.project.models.Category;
import com.example.project.models.Product;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class FakeStoreProductService implements ProductService{
    private  RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product geSingleProduct(Long id){

        //FakeStoreProductDto fakeStoreProductDto=  restTemplate.getForObject
          //      ("http://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity("http://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
       // if(responseEntity.getStatusCode()== HttpStatusCode.valueOf(200)) put your check whatever you want to.
       FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        return fakeStoreProductDto.toProduct();
    }
    @Override
    public Product createProduct(String title, String description, String image, String Category, double price){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setCategory(Category);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setImage(image);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setTitle(title);

        FakeStoreProductDto response = restTemplate.postForObject("http://fakestoreapi.com/products", fakeStoreProductDto, FakeStoreProductDto.class);

        return response.toProduct();
    }

    // response entity, it has all the code that comes with the api. it contains everything that a response required.

    public List<Product> getAllProducts(){

        FakeStoreProductDto[] response = restTemplate.getForObject("http://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: response){
            products.add(fakeStoreProductDto.toProduct());
        }

        return products;
    }

}
