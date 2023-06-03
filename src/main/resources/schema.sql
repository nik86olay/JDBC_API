create schema person

create table person.CUSTOMERS
(
    id           serial primary key,
    name         varchar(30),
    surname      varchar(30),
    age          int not null check ( age > 0 ),
    phone_number varchar(30)
);

create table person.ORDERS
(
    id           serial primary key,
    date         date not null,
    customer_id  int  not null,
    product_name varchar(30),
    amount       int  not null check ( amount >= 0 ),

    foreign key (customer_id) references person.CUSTOMERS (id)
);

insert into person.CUSTOMERS (name, surname, age, phone_number)
values ('AleXey', 'Pupkin', 2, '+999'),
       ('Lex', 'Luter', 33, '+564'),
       ('Ivan', 'Karasev', 20, ''),
       ('Toniy', 'Okroshkina', 45, '+123'),
       ('Alexey', 'Vich', 40, '+'),
       ('alexey', 'Valtarenovich', 77, '+666');

insert into person.ORDERS (date, customer_id, product_name, amount)
values ('2018/05/15', 1, 'tosol', 999),
       ('2023/02/20', 2, 'cocos', 564),
       ('1987/06/01', 3, 'barbos', 0),
       ('1999/09/30', 4, 'trotil', 123),
       ('2001/04/18', 6, 'crokodil', 666);

