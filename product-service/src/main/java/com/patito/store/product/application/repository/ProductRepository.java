package com.patito.store.product.application.repository;

import com.patito.store.product.domain.model.Product;

import java.util.List;

public interface ProductRepository {
    Product findByHawa(final String hawa);

    List<Product> getAll();
}
