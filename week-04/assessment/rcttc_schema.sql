-- DDL
-- use rcttc;
drop database if exists tiny_theaters;
create database tiny_theaters;

use tiny_theaters;


create table theater(
theater_id int primary key auto_increment,
theater_name varchar(50) not null,
theater_address varchar(100) not null,
theater_phone varchar(15) not null,
theater_email varchar(25) not null
);

create table `show`(
show_id int primary key auto_increment,
show_name varchar(100) not null,
show_date date not null,
show_price decimal(6,2) not null,
theater_id int not null,
constraint fk_theater_theater_id
foreign key(theater_id)
references theater(theater_id)
);




create table customer (
customer_id int primary key auto_increment,
email_address varchar(100) null,
first_name varchar(25) not null,
last_name varchar(25) not null,
phone_number varchar(15) not null,
`home_address` varchar(100) not null
);

create table tickets (
ticket_id int primary key auto_increment,
ticket_seat varchar(10) not null,
customer_id int not null,
show_id int not null,
constraint fk_customer_customer_id
foreign key( customer_id)
references customer(customer_id),
constraint fk_show_show_id
foreign key( show_id)
references `show`(show_id)
);


