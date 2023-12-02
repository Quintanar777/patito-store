package com.patito.store.product.infrastructure.repository;

import com.patito.store.product.application.repository.ProductRepository;
import com.patito.store.product.domain.model.Product;
import com.patito.store.product.infrastructure.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDboRepository implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    public ProductDboRepository(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Product findByHawa(String hawa) {
        return ProductMapper.INSTANCE.productEntityToProduct(this.jpaProductRepository.findByHawa(hawa));
    }

    @Override
    public List<Product> getAll() {
        List<Product> response = new ArrayList<>();
        this.jpaProductRepository.findAll().forEach(productEntity -> {
            response.add(ProductMapper.INSTANCE.productEntityToProduct(productEntity));
        });
        return response;
    }
}
