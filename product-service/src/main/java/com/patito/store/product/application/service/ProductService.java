package com.patito.store.product.application.service;

import com.patito.store.product.application.repository.ProductRepository;
import com.patito.store.product.domain.model.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findByHawa(final String hawa) {
        return Optional.ofNullable(this.productRepository.findByHawa(hawa));
    }
}
