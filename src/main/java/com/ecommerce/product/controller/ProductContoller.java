package com.ecommerce.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/product")
public class ProductContoller {
    @Autowired
    ProductService productService;


   @GetMapping("/{id}")
   public Product getProductById(@PathVariable("id") int id) {
       return productService.getProductByID(id);
   }
   

   @GetMapping()
   public List<Product> getAllProduct(){
    return productService.getAllProduct();
   }
   
    
    
}
