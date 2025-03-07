package com.walmart.productservice.entity;

public class ProductBuilder {
    private String name;
    private String description;
    private String category;
    private Double price;
    private Integer stockQuantity;

    public ProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder description(String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder category(String category) {
        this.category = category;
        return this;
    }

    public ProductBuilder price(Double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder stockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
        return this;
    }

    public Product build() {
       // return new Product(null, name, description, category, price, stockQuantity);
        return Product.builder()
                .name(name)
                .description(description)
                .category(category)
                .price(price)
                .stockQuantity(stockQuantity)
                .build();
    }


    public static ProductBuilder builder() {
        return new ProductBuilder();
    }
}
