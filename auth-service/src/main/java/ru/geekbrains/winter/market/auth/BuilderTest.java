package ru.geekbrains.winter.market.auth;

import ru.geekbrains.winter.market.auth.entities.User;

public class BuilderTest {

    public static void main(String[] args) {
        User user = User.builder()
                .username("Ivan")
                .password("password")
                .build();

        System.out.println(user);
    }
}
