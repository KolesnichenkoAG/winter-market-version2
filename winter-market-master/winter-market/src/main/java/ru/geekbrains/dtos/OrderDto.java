package ru.geekbrains.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private String username;
    private String title_product;
    private int product_quantity;
    private int price;
    private int total_amount;

}
