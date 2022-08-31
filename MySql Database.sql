create database if not exists `ecommerce_cart`;
use `ecommerce_cart`;


drop table if exists `products`;
create table `products`(
id int Not Null auto_increment,
name varchar(78),
category varchar(70),
price varchar(70),
quantity varchar(70),
image varchar(777),
productdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
primary key(id)
);
select * from products;

