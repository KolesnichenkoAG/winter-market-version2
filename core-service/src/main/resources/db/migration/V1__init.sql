create table categories
(
    id         bigserial primary key,
    title      varchar(255) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into categories (title)
values ('Food'),
       ('Others');

create table products
(
    id          bigserial primary key,
    title       varchar(255),
    category_id bigint references categories (id),
    price       numeric(8, 2) not null,
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

insert into products (title, price, category_id)
values ('Milk', 80.20, 1),
       ('Bread', 25.60, 1),
       ('Cheese', 300.00, 1);

create table orders
(
    id          bigserial primary key,
    username    varchar(255) not null,
    address     varchar(255),
    phone       varchar(255),
    total_price numeric(8, 2),
    created_at  timestamp default current_timestamp,
    updated_at   timestamp default current_timestamp
);

create table orders_items
(
    id                bigserial primary key,
    product_id        bigint references products (id),
    order_id          bigint references orders (id),
    quantity          int,
    price_per_product numeric(8, 2),
    price             numeric(8, 2),
    created_at        timestamp default current_timestamp,
    updated_at        timestamp default current_timestamp
);