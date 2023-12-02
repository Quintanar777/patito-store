package com.patito.store.product.infrastructure.mapper;

import com.patito.store.product.domain.model.Product;
import com.patito.store.product.infrastructure.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product productEntityToProduct(ProductEntity productEntity);
}
