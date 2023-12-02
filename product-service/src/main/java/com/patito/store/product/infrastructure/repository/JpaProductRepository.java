package com.patito.store.product.infrastructure.repository;

import com.patito.store.product.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface JpaProductRepository extends CrudRepository<ProductEntity, Long> {
    ProductEntity findByHawa(String hawa);
}
