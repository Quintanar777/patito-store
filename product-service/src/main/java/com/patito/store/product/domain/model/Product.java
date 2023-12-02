package com.patito.store.product.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Product {
    private String hawa;
    private Double price;
    private String description;
    private Integer stock;
    private Integer discountPercentage;
    private Date createdAt;
}
