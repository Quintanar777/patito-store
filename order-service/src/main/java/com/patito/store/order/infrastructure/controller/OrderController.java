package com.patito.store.order.infrastructure.controller;

import com.patito.store.order.application.service.OrderService;
import com.patito.store.order.domain.Order;
import com.patito.store.order.infrastructure.mapper.OrderMapper;
import com.patito.store.order.infrastructure.request.OrderRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody @Valid OrderRequest orderRequest,
                                         @RequestHeader(value = "X-Forwarded-For", required = false, defaultValue = "0.0.0.0") String userIp) {
        log.info("POST /orders body: {}", orderRequest.toString());
        Order order = OrderMapper.INSTANCE.orderRequestToOrder(orderRequest);
        order.setUserIp(userIp);
        return ResponseEntity.ok(this.orderService.createOrder(order));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        log.info("GET /orders");
        return ResponseEntity.ok(this.orderService.getAll());
    }
}
