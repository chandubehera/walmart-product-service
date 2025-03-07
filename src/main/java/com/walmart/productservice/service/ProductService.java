package com.walmart.productservice.service;

import com.walmart.productservice.dto.ProductRequestDTO;
import com.walmart.productservice.dto.ProductResponseDTO;
import java.util.List;

public interface ProductService {

    ProductResponseDTO addProduct(ProductRequestDTO productDTO);

    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productDTO);

    void deleteProduct(Long id);

    ProductResponseDTO getProductById(Long id);

    List<ProductResponseDTO> searchProducts(String keyword);

    List<ProductResponseDTO> bulkUpload(List<ProductRequestDTO> products);
}
