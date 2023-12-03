package com.patito.store.order.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_order")
public class ProductOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    private String hawa;

    public ProductOrderEntity(Long orderId, String hawa) {
        this.orderId = orderId;
        this.hawa = hawa;
    }

    public ProductOrderEntity() {
    }
}
