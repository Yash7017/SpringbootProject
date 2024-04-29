package com.example.project.controllers;

import com.example.project.dtos.ErrorDto;
import com.example.project.models.Product;
import com.example.project.services.FakeStoreProductService;
import com.example.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.project.dtos.createProductRequestDto;

import java.util.List;

@RestController
public class productController {

    private ProductService productService;
    //ProductService productService = new FakeStoreProductService();

    public  productController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody createProductRequestDto ProductRequestDto){
    return productService.createProduct(ProductRequestDto.getTitle(),
            ProductRequestDto.getDescription(),
            ProductRequestDto.getImage(),
            ProductRequestDto.getCategory(),
            ProductRequestDto.getPrice());

    }
    @GetMapping("/productso")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> responseData=  productService.getAllProducts();
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(responseData, HttpStatusCode.valueOf(404));
        return responseEntity;
    }

    // jakson library, take java object and convert in json , and vice versa.
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id){
    return productService.geSingleProduct(id);

    }
    public  void deleteProduct(Long id){

    }

//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ErrorDto> HandleNullPointerException(){
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage("something went wrong, try again. ");
//        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto,HttpStatusCode.valueOf(404));
//        return responseEntity;
//    }
}
