package com.ecommerce.product.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.product.dto.FakeProductDto;
import com.ecommerce.product.model.Category;
import com.ecommerce.product.model.Product;

@Service
public class FakeProductService implements ProductService {
    @Autowired 
    RestTemplate restTemplate;
    

    @Override
    public Product getProductByID(int id) {
        // TODO Auto-generated method stub
         
       FakeProductDto fakeProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeProductDto.class);
       Product product = convertFakeProductToProduct(fakeProductDto);

        return product;
        //throw new UnsupportedOperationException("Unimplemented method 'getProductByID'");
    }

    @Override
    public List<Product> getAllProduct() {

        FakeProductDto[] allFakeProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products",FakeProductDto[].class);
         if (allFakeProductDtos == null) {
    return List.of(); // or throw exception
}
        // TODO Auto-generated method stub
        List<Product>allProducts = new ArrayList<>();

        for(FakeProductDto fakeProductDto:allFakeProductDtos){
          allProducts.add(convertFakeProductToProduct(fakeProductDto));
        }
        
        return allProducts;
        
        
        //throw new UnsupportedOperationException("Unimplemented method 'getAllProduct'");
    }

    private Product convertFakeProductToProduct(FakeProductDto fakeProductDto){
        
        Product product = new Product();
        product.setId(fakeProductDto.getId());
        product.setPrice(fakeProductDto.getPrice());
        product.setTitle(fakeProductDto.getTitle());

        Category category = new Category();
        category.setDescription(fakeProductDto.getDescription());
        category.setName(fakeProductDto.getCategory());

        product.setCategory(category);
        return product;
    }
    
}
