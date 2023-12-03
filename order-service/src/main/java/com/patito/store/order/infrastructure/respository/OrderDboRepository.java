package com.patito.store.order.infrastructure.respository;

import com.patito.store.order.application.repository.OrderRepository;
import com.patito.store.order.domain.Order;
import com.patito.store.order.infrastructure.entity.OrderEntity;
import com.patito.store.order.infrastructure.entity.ProductOrderEntity;
import com.patito.store.order.infrastructure.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderDboRepository implements OrderRepository {

    private final JpaOderRepository jpaOderRepository;
    private final JpaProductOrderRepository jpaProductOrderRepository;

    public OrderDboRepository(JpaOderRepository jpaOderRepository, JpaProductOrderRepository jpaProductOrderRepository) {
        this.jpaOderRepository = jpaOderRepository;
        this.jpaProductOrderRepository = jpaProductOrderRepository;
    }

    @Override
    public Order create(Order order) {
        OrderEntity orderEntity = OrderMapper.INSTANCE.orderToOrderEntity(order);
        OrderEntity savedOrder = this.jpaOderRepository.save(orderEntity);
        order.getHawas()
                .forEach(hawa -> this.jpaProductOrderRepository.save(new ProductOrderEntity(savedOrder.getId(), hawa)));
        Order responseOrder = OrderMapper.INSTANCE.orderEntityToOrder(savedOrder);
        responseOrder.setHawas(order.getHawas());
        return responseOrder;
    }

    @Override
    public List<Order> getAll() {
        List<Order> response = new ArrayList<>();
        this.jpaOderRepository.findAll()
                .forEach(orderEntity -> {
                    Order order = OrderMapper.INSTANCE.orderEntityToOrder(orderEntity);
                    List<String> hawas = this.jpaProductOrderRepository.findByOrderId(order.getId())
                            .stream()
                            .map(ProductOrderEntity::getHawa)
                            .toList();
                    order.setHawas(hawas);
                    response.add(order);
                });
        return response;
    }
}
