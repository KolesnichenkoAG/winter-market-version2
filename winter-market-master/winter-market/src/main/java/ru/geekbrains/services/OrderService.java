package ru.geekbrains.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.entities.Order;
import ru.geekbrains.repositories.OrderRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final UserService userService;
    private Order order;

    @PostConstruct
    public void init() {
        order = new Order();
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
