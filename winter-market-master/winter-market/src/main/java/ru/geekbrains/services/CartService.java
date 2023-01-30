package ru.geekbrains.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.dtos.Cart;
import ru.geekbrains.entities.Product;
import ru.geekbrains.exceptions.ResourceNotFoundException;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;
    private Cart tempCart;

    @PostConstruct
    public void init() {
        tempCart = new Cart();
    }

    public Cart getCurrentCart() {
        return tempCart;
    }

    public void add(Long productId) {
        Product product = productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException
                ("Не удаеться добавить продукт с id: " + productId + " в корзину. Продукт не найден"));
        tempCart.add(product);
    }

    public void clearCart() {
        tempCart.clear();
    }

    public void changeQuantity(Long productId, int delta) {
        Product product = productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException
                ("Не удаеться добавить продукт с id: " + productId + " в корзину. Продукт не найден"));
        tempCart.change(product, delta);
    }
}
