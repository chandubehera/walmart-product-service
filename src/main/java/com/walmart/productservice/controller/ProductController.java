package com.walmart.productservice.controller;

import com.walmart.productservice.dto.ProductRequestDTO;
import com.walmart.productservice.dto.ProductResponseDTO;
import com.walmart.productservice.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponseDTO addProduct(@Valid @RequestBody ProductRequestDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequestDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/search")
    public List<ProductResponseDTO> searchProducts(@RequestParam String keyword) {
        return productService.searchProducts(keyword);
    }

    @PostMapping("/bulk-upload")
    public List<ProductResponseDTO> bulkUpload(@RequestBody List<ProductRequestDTO> products) {
        return productService.bulkUpload(products);
    }
}
