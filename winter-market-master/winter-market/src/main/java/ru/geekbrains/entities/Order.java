package ru.geekbrains.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "title_product")
    private String title_product;

    @Column(name = "product_quantity")
    private int product_quantity;

    @Column(name = "price")
    private int price;

    @Column(name = "total_amount")
    private int total_amount;

    @ManyToMany
    @JoinTable(name = "user_order",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Collection<User> users;

    @ManyToMany
    @JoinTable(name = "product_order",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Collection<Product> products;

}
