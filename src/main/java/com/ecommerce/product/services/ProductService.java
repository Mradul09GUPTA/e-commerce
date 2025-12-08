package com.ecommerce.product.services;

import java.util.List;

import com.ecommerce.product.model.Product;

public interface ProductService {
    Product getProductByID(int id);
    List<Product> getAllProduct();
    
    
}
