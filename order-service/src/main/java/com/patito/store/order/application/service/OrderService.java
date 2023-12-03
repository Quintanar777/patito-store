package com.patito.store.order.application.service;

import com.patito.store.order.application.repository.OrderRepository;
import com.patito.store.order.domain.Order;
import com.patito.store.order.domain.OrderStatus;
import com.patito.store.order.infrastructure.respository.OrderDboRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderDboRepository;

    public OrderService(OrderDboRepository orderDboRepository) {
        this.orderDboRepository = orderDboRepository;
    }

    public Order createOrder(Order order) {
        order.setEventDate(new Date());
        order.setStatus(OrderStatus.PENDING);
        return this.orderDboRepository.create(order);
    }

    public List<Order> getAll() {
        return this.orderDboRepository.getAll();
    }
}
