package com.patito.store.order.infrastructure.entity;

import com.patito.store.order.domain.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "order_patito")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_ip")
    private String userIp;
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "client_id")
    private Long clientId;
    @Column(name = "seller_id")
    private Long sellerId;
    private Double discount;
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;
    private Date eventDate;
}
