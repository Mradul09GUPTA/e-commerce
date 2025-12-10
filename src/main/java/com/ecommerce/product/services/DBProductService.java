package com.ecommerce.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.product.exception.ProductNotFound;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
@Service("DBProductService")
public class DBProductService implements ProductService  {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductByID(Long id) throws ProductNotFound {
        // TODO Auto-generated method stub
        //Long id = (Long)id;
         Product product = productRepository.findById(id).orElseThrow(()->new ProductNotFound("Product is "+ id + "not found"));
         return product;

        // throw new UnsupportedOperationException("Unimplemented method 'getProductByID'");
    }

    @Override
    public List<Product> getAllProduct() {
        // TODO Auto-generated method stub
       
       List<Product> products = productRepository.findAll();


       return products;
       
       
        // throw new UnsupportedOperationException("Unimplemented method 'getAllProduct'");

    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFound {
        // TODO Auto-generated method stub


         Product replaceproduct = productRepository.findById(id).orElseThrow(()->new ProductNotFound("Product is "+ id + "not found"));
        
        
        
         return null;
        //throw new UnsupportedOperationException("Unimplemented method 'replaceProduct'");
    }
    
}
