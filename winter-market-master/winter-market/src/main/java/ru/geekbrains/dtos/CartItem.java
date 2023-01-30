package ru.geekbrains.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.entities.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private Long productId;
    private String productTitle;
    private int quantity;
    private int pricePerProduct;
    private int price;

    public void incrementQuantity() {
        quantity++;
        //price = price.add(pricePerProduct);
    }

    public void decrementQuantity() {
        quantity--;
    }
}
