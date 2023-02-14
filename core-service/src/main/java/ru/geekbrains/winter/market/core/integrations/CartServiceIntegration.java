package ru.geekbrains.winter.market.core.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.geekbrains.winter.market.api.CartDto;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final WebClient cartServiceWebClient;

    public CartDto getCurrentCart() { // данный метод позволяет получить продукт по вебклайн
        return cartServiceWebClient.get()
                .uri("/api/v1/cart")
                .retrieve()
                .bodyToMono(CartDto.class)
                .block();
    }

    public void clear() {
        cartServiceWebClient.get()
                .uri("/api/v1/cart/clear")
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
