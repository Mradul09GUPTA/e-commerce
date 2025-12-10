package com.ecommerce.product.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends Base {
    private String name;
    private String description;

}
