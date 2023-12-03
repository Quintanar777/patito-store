package com.patito.store.order.infrastructure.mapper;

import com.patito.store.order.domain.Order;
import com.patito.store.order.infrastructure.entity.OrderEntity;
import com.patito.store.order.infrastructure.request.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderEntity orderToOrderEntity(Order order);

    Order orderEntityToOrder(OrderEntity orderEntity);

    @Mapping(source = "discount", target = "discount", defaultValue = "0.0")
    Order orderRequestToOrder(OrderRequest orderRequest);
}
