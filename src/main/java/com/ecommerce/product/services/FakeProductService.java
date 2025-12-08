package com.ecommerce.product.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.product.dto.FakeProductDto;
import com.ecommerce.product.exception.ProductNotFound;
import com.ecommerce.product.model.Category;
import com.ecommerce.product.model.Product;

@Service
public class FakeProductService implements ProductService {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public Product getProductByID(int id) throws ProductNotFound {
        // TODO Auto-generated method stub

        FakeProductDto fakeProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeProductDto.class);

        if (fakeProductDto == null) {
            throw new ProductNotFound("Product Not Found" + id);
        }
        Product product = convertFakeProductToProduct(fakeProductDto);

        return product;
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getProductByID'");
    }

    @Override
    public List<Product> getAllProduct() {

        FakeProductDto[] allFakeProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeProductDto[].class);
        if (allFakeProductDtos == null) {
            return List.of(); // or throw exception
        }
        // TODO Auto-generated method stub
        List<Product> allProducts = new ArrayList<>();

        for (FakeProductDto fakeProductDto : allFakeProductDtos) {
            allProducts.add(convertFakeProductToProduct(fakeProductDto));
        }

        return allProducts;

        // throw new UnsupportedOperationException("Unimplemented method
        // 'getAllProduct'");
    }

    private Product convertFakeProductToProduct(FakeProductDto fakeProductDto) {

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

    @Override
    public Product replaceProduct(int id, FakeProductDto product) {
        // TODO Auto-generated method stub

        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeProductDto.class);
        HttpMessageConverterExtractor<FakeProductDto> responseExtractor = new HttpMessageConverterExtractor(
                FakeProductDto.class, restTemplate.getMessageConverters());
        FakeProductDto fakeStoreProductDto = restTemplate.execute(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT,
                requestCallback,
                responseExtractor);

        // restTemplate.put( "https://fakestoreapi.com/products/" + id, product);
        return convertFakeProductToProduct(fakeStoreProductDto);

    }

}
