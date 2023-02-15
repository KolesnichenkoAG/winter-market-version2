create table users
(
    id         bigserial primary key,
    username   varchar(36) not null,
    password   varchar(80) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table roles
(
    id         bigserial primary key,
    name       varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

CREATE TABLE users_roles
(
    user_id    bigint not null references users (id),
    role_id    bigint not null references roles (id),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
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
