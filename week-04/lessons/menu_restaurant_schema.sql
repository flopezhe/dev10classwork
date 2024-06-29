drop database if exists menu_restaurant;
create database menu_restaurant;
use menu_restaurant;


create table menu_items(
	menu_id int primary key auto_increment,
	item_name varchar(50) not null,
	item_price decimal(5,2) not null
);

create table `order`(
	order_id int primary key auto_increment,
    customer_name varchar(100) not null,
    total decimal(8,2) not null,
    order_date datetime not null
);

create table order_items(
	order_item_id int primary key auto_increment,
    order_id int,
    menu_id int,
    constraint fk_order_items_order_id
		foreign key (order_id)
        references `order` (order_id),
	constraint fk_order_items_menu_id
		foreign key(menu_id)
        references menu_items(menu_id)
);

