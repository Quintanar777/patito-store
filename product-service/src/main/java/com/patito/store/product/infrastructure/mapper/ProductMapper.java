package com.patito.store.product.infrastructure.mapper;

import com.patito.store.product.domain.model.Product;
import com.patito.store.product.infrastructure.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "discountPercentage", target = "discountPercentage", defaultValue = "0")
    Product productEntityToProduct(ProductEntity productEntity);
}
