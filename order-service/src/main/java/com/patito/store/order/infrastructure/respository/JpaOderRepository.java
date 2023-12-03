package com.patito.store.order.infrastructure.respository;

import com.patito.store.order.infrastructure.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface JpaOderRepository extends CrudRepository<OrderEntity, Long> {
}
