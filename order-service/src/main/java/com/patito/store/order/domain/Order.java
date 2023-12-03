package com.patito.store.order.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Order {
    private Long id;
    private String userIp;
    private List<String> hawas;
    private Long storeId;
    private Long clientId;
    private Long sellerId;
    private Double discount;
    private OrderStatus status;
    private Date eventDate;
}
