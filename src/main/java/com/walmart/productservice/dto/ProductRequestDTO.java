package com.walmart.productservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequestDTO {

    @NotBlank(message = "Product name is required")
    private String name;

    private String description;

    @NotBlank(message = "Category is required")
    private String category;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be a positive number")
    private Double price;

    @NotNull(message = "Stock quantity is required")
    @Min(value = 0, message = "Stock quantity must be a positive number")
    private Integer stockQuantity;

    public ProductRequestDTO() {}

    // ✅ Private Constructor
    private ProductRequestDTO(ProductRequestDTOBuilder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.category = builder.category;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
    }

    // ✅ Builder Class
    public static class ProductRequestDTOBuilder {
        private String name;
        private String description;
        private String category;
        private Double price;
        private Integer stockQuantity;

        public ProductRequestDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductRequestDTOBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductRequestDTOBuilder category(String category) {
            this.category = category;
            return this;
        }

        public ProductRequestDTOBuilder price(Double price) {
            this.price = price;
            return this;
        }

        public ProductRequestDTOBuilder stockQuantity(Integer stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public ProductRequestDTO build() {
            return new ProductRequestDTO(this);
        }
    }

    // ✅ Static method to get a new Builder
    public static ProductRequestDTOBuilder builder() {
        return new ProductRequestDTOBuilder();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    @Override
    public String toString() {
        return "ProductRequestDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}
