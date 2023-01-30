package ru.geekbrains.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.dtos.OrderDto;
import ru.geekbrains.entities.Order;
import ru.geekbrains.exceptions.ResourceNotFoundException;
import ru.geekbrains.services.OrderService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> findAllOrder() {
        return orderService.findAll().stream().map(p ->
                new OrderDto(p.getId(), p.getUsername(), p.getTitle_product(),
                        p.getProduct_quantity(), p.getPrice(), p.getTotal_amount())).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OrderDto findOrderById(@PathVariable Long id) {
        Order o = orderService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Заказ не найден, id:" + id));
        return new OrderDto(o.getId(), o.getUsername(), o.getTitle_product(), o.getProduct_quantity(), o.getPrice(), o.getTotal_amount());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
    }

}
