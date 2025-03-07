package com.walmart.productservice.dto;

public class ProductResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String category;
    private Double price;
    private Integer stockQuantity;

    // ✅ Private Constructor
    private ProductResponseDTO(ProductResponseDTOBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.category = builder.category;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
    }

    // ✅ Builder Class
    public static class ProductResponseDTOBuilder {
        private Long id;
        private String name;
        private String description;
        private String category;
        private Double price;
        private Integer stockQuantity;

        public ProductResponseDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductResponseDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductResponseDTOBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductResponseDTOBuilder category(String category) {
            this.category = category;
            return this;
        }

        public ProductResponseDTOBuilder price(Double price) {
            this.price = price;
            return this;
        }

        public ProductResponseDTOBuilder stockQuantity(Integer stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public ProductResponseDTO build() {
            return new ProductResponseDTO(this);
        }
    }

    // ✅ Static method to get a new Builder
    public static ProductResponseDTOBuilder builder() {
        return new ProductResponseDTOBuilder();
    }
}
