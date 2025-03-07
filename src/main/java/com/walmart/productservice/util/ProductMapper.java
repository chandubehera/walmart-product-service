package com.walmart.productservice.util;

import com.walmart.productservice.dto.ProductRequestDTO;
import com.walmart.productservice.dto.ProductResponseDTO;
import com.walmart.productservice.entity.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequestDTO dto) {
        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .price(dto.getPrice())
                .stockQuantity(dto.getStockQuantity())
                .build();
    }

    public static ProductResponseDTO toDTO(Product entity) {
        return ProductResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .category(entity.getCategory())
                .price(entity.getPrice())
                .stockQuantity(entity.getStockQuantity())
                .build();
    }
}
