-- drop database if exists drmh;
-- create database drmh;
use drmh;

create table guest(
guest_id int primary key auto_increment,
first_name varchar(25) not null,
last_name varchar(25) not null,
email_address varchar(50) not null,
phone_number int not null,
constraint uq_guest_email_address
	unique(email_address)
);

create table location (
location_id int primary key auto_increment,
address varchar(50) not null,
city varchar(25) not null,
state varchar(3) not null,
postal_code varchar(25) not null,
standard_rate int not null,
weekend_rate int not null,
host varchar(25) not null
);

