package com.ecommerce.product.services;

import java.util.List;

import com.ecommerce.product.dto.FakeProductDto;
import com.ecommerce.product.exception.ProductNotFound;
import com.ecommerce.product.model.Product;

public interface ProductService {
    Product getProductByID(int id) throws ProductNotFound;

    List<Product> getAllProduct();

    Product replaceProduct(int id, FakeProductDto product);

}
