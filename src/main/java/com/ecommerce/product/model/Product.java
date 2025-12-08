package com.ecommerce.product.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends Base {
    private String title;
    private Double price;
    private Category category;
   

}
