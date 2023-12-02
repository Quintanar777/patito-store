package com.patito.store.product.infrastructure.repository;

import com.patito.store.product.application.repository.ProductRepository;
import com.patito.store.product.domain.model.Product;
import com.patito.store.product.infrastructure.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductDboRepository implements ProductRepository {

    private final JpaProductRepository productRepository;

    public ProductDboRepository(JpaProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findByHawa(String hawa) {
        return ProductMapper.INSTANCE.productEntityToProduct(this.productRepository.findByHawa(hawa));
    }
}
