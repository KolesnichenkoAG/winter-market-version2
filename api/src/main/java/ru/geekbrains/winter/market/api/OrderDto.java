package ru.geekbrains.winter.market.api;

import java.math.BigDecimal;

public class OrderDto {
    private Long id;
    private String username;
    private String title_product;
    private int product_quantity;
    private BigDecimal price;
    private BigDecimal total_amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle_product() {
        return title_product;
    }

    public void setTitle_product(String title_product) {
        this.title_product = title_product;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public OrderDto(Long id, String username, String title_product, int product_quantity, BigDecimal price, BigDecimal total_amount) {
        this.id = id;
        this.username = username;
        this.title_product = title_product;
        this.product_quantity = product_quantity;
        this.price = price;
        this.total_amount = total_amount;
    }

    public OrderDto() {
    }
}
