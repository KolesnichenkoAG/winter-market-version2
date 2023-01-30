package ru.geekbrains.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.dtos.Cart;
import ru.geekbrains.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.add(id);
    }

    @GetMapping
    public Cart getCurrentCart() {
        return cartService.getCurrentCart();
    }

    @GetMapping("/clear")
    public void clearCart() {
        cartService.clearCart();
    }

    @GetMapping("/change/{id}")
    public void changeQuantity(@PathVariable Long id, @RequestParam int delta) {
        cartService.changeQuantity(id, delta);
    }
}
