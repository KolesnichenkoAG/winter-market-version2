package ru.geekbrains.winter.market.carts.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.winter.market.carts.model.Cart;
import ru.geekbrains.winter.market.api.ProductDto;
import ru.geekbrains.winter.market.carts.integrations.ProductServiceIntegration;


import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductServiceIntegration productServiceIntegration;
    private Cart cart;

    @PostConstruct
    public void init() {
        cart = new Cart();
        cart.setItems(new ArrayList<>());
    }

    public Cart getCurrentCart() {
        return cart;
    }

    public void add(Long productId) {
        ProductDto product = productServiceIntegration.getProductById(productId);
        cart.add(product);
    }

    public void remove(Long productId) {
        cart.remove(productId);
    }

    public void clear() {
        cart.clear();
    }
}
