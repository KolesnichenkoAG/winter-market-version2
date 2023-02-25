package ru.geekbrains.winter.market.carts.model;

import lombok.Data;
import ru.geekbrains.winter.market.api.ProductDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
    private BigDecimal totalPrice;

    public Cart() {
        this.items = new ArrayList<>();
    }

    /*public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }*/

    public void add(ProductDto product) {
        for (CartItem item : items) {
            if (product.getId().equals(item.getProductId())) {
                item.incrementQuantity();
                recalculate();
                return;
            }
        }
        items.add(new CartItem(product.getId(), product.getTitle(), 1, product.getPrice(), product.getPrice()));
        recalculate();
    }

    public void remove(Long productId) {
        if (items.removeIf(item -> item.getProductId().equals(productId))) {
            recalculate();
        }
    }

    private void recalculate() {
        totalPrice = BigDecimal.ZERO;
        items.forEach(i -> totalPrice = totalPrice.add(i.getPrice()));
    }

    public void clear() {
        items.clear();
        totalPrice = BigDecimal.ZERO;
    }

    /*public void deleteProductInCart(ProductDto product) {
        ;
        totalPrice -= product.getPrice();
    }*/

    public void change(ProductDto product, int delta) {
        if (delta == 1) {
            add(product);
        }
        /*if (delta == -1) {
            deleteProductInCart(product);
        }*/
    }
}
