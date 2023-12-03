package com.patito.store.order.application.repository;

import com.patito.store.order.domain.Order;

import java.util.List;

public interface OrderRepository {
    Order create(Order order);

    List<Order> getAll();
}
