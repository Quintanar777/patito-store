package com.patito.store.product.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hawa;

    private Double price;

    private String description;

    private Integer stock;

    @Column(name = "discount_percentage")
    private Integer discountPercentage;

    @Column(name = "created_at")
    private Date createdAt;
}
