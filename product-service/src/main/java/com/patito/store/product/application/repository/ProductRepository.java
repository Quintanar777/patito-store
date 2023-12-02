package com.patito.store.product.application.repository;

import com.patito.store.product.domain.model.Product;

public interface ProductRepository {
    Product findByHawa(final String hawa);
}
