create schema netology;

create table netology.customers
(
    id           bigserial primary key,
    name         varchar not null,
    surname      varchar not null,
    age          smallint check ( age > 0 and age < 100 ),
    phone_number varchar not null
);

create table netology.orders
(
    id           bigserial primary key,
    date         timestamp not null default now(),
    customer_id  bigint references customers (id),
    product_name varchar   not null unique,
    amount       integer check ( amount > 0 )
);

create INDEX index_customers
    on customers (name);

-- Inserts
insert into CUSTOMERS (name, surname, age, phone_number)
values ('Alexey', 'Ivanov', 25, '+7(917)322-21-55');
insert into CUSTOMERS (name, surname, age, phone_number)
values ('Alexey', 'Petrov', 22, '+7(910)455-98-32');

insert into ORDERS (product_name, customer_id, amount)
values ('Bread', 1, 5);
insert into ORDERS (product_name, customer_id, amount)
values ('Milk', 2, 20);
