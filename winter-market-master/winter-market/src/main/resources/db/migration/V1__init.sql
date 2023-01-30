create table products
(
    id         bigserial primary key,
    title      varchar(255),
    price      int
    /*created_at timestamp default current_timestamp,
    update_at  timestamp default current_timestamp*/
);

insert into products (title, price)
values ('Milk', 80),
       ('Bread', 25),
       ('Cheese', 300);

create table users
(
    id       bigserial primary key,
    username varchar(36) not null,
    password varchar(80) not null
);

create table roles
(
    id   bigserial primary key,
    name varchar(50) not null
);

CREATE TABLE users_roles
(
    user_id bigint not null references users (id),
    role_id bigint not null references roles (id),
    primary key (user_id, role_id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password)
values ('bob', '$2a$12$IPu8IxdkKZWa16YKBWgFaeHSsQwtOb6Wi26a6l6ScMpKS5fyMhpka'),
       ('john', '$2a$12$5k3PV2vSQvrHXAQSgEYFmulHD9/6w0LzRTE0T553CsH.9I.66z/V6');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2);

create table orders
(
    id                  bigserial primary key,
    created_at          timestamp default current_timestamp,
    user_id             bigint not null references users (id),
    username            varchar(36) not null,
    title_product       varchar(255),
    product_quantity    int,
    price               int,
    total_amount        int
);