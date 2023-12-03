package com.patito.store.order.infrastructure.respository;

import com.patito.store.order.infrastructure.entity.ProductOrderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaProductOrderRepository extends CrudRepository<ProductOrderEntity, Long> {
    List<ProductOrderEntity> findByOrderId(Long orderId);
}
