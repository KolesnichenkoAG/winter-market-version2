package ru.geekbrains.dtos;

import lombok.Data;
import ru.geekbrains.entities.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
    private int totalPrice;
    private int quantity;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void add(Product product) { // TODO: Доработать в ДЗ
        for (CartItem item : items) {
            if (item.getProductId().equals(product.getId())) {
                item.incrementQuantity();
                totalPrice += product.getPrice();
                return;
            }
        }
        items.add(new CartItem(product.getId(), product.getTitle(), 1, product.getPrice(), product.getPrice()));
        recalculate();
    }

    private void recalculate() {
        totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += item.getPrice();
        }
    }

    public void clear() {
        items.clear();
        totalPrice = 0;
    }

    public void deleteProductInCart(Product product) {
            quantity = quantity-1;
            totalPrice -= product.getPrice();
    }

    public void change(Product product, int delta) {
        if (delta == 1) {
            add(product);
            totalPrice += product.getPrice();
        }
        if (delta == -1) {
            deleteProductInCart(product);
        }
    }
}
