package com.walmart.productservice.service.impl;

import com.walmart.productservice.dto.ProductRequestDTO;
import com.walmart.productservice.dto.ProductResponseDTO;
import com.walmart.productservice.entity.Product;
import com.walmart.productservice.exception.ProductNotFoundException;
import com.walmart.productservice.repository.ProductRepository;
import com.walmart.productservice.service.ProductService;
import com.walmart.productservice.util.ProductMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO productDTO) {
        Product product = ProductMapper.toEntity(productDTO);
        return ProductMapper.toDTO(productRepository.save(product));
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        /*product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setStockQuantity(productDTO.getStockQuantity());*/

        product = Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .category(productDTO.getCategory())
                .price(productDTO.getPrice())
                .stockQuantity(productDTO.getStockQuantity())
                .build();

        return ProductMapper.toDTO(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found");
        }
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper::toDTO)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public List<ProductResponseDTO> searchProducts(String keyword) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(keyword);
        return products.stream().map(ProductMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDTO> bulkUpload(List<ProductRequestDTO> products) {
        List<Product> savedProducts = productRepository.saveAll(
                products.stream().map(ProductMapper::toEntity).collect(Collectors.toList())
        );
        return savedProducts.stream().map(ProductMapper::toDTO).collect(Collectors.toList());
    }
}
