package com.ecommerce.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product.dto.FakeProductDto;
import com.ecommerce.product.exception.ProductNotFound;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/product")
public class ProductContoller {
    @Autowired
    ProductService productService;


   @GetMapping("/{id}")
   public ResponseEntity<Product> getProductById(@PathVariable("id") int id) throws ProductNotFound {

      ResponseEntity<Product> response = new ResponseEntity<>(
        productService.getProductByID(id),
        HttpStatus.OK
       );


       return response;
   }
   

   @GetMapping()
   public ResponseEntity<List<Product>> getAllProduct(){
     ResponseEntity<List<Product>> response = new ResponseEntity<>(
        productService.getAllProduct(),
        HttpStatus.OK
       );


    return response;
   }

  

    @PutMapping("/{id}")
   public Product replaceProduct(@PathVariable("id") int id,@RequestBody FakeProductDto product){

      
        return productService.replaceProduct(id,product);
   }
   
    
    
}
