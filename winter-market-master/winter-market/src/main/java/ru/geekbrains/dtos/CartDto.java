package ru.geekbrains.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private List<CartItem> items;
    private int totalPrice;
    private int quantity;
}
