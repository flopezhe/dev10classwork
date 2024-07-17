drop database if exists dwmh_test;
create database dwmh_test;
use dwmh_test;

create table state (
	state_id int primary key auto_increment,
    `name` varchar(50) not null unique,
    usps_code varchar(2) not null unique
);

create table `user` (
	user_id int primary key auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(512) not null unique,
    phone varchar(50) not null    
);

create table location (
	location_id int primary key auto_increment,
	user_id int not null,
    address varchar(100) not null,
    city varchar(100) not null,
	postal_code varchar(20) not null,
	state_id int not null,
    standard_rate decimal(8, 2) not null,
	weekend_rate decimal(8, 2) not null,
    constraint fk_location_user_id
        foreign key (user_id)
        references user(user_id),
    constraint fk_location_state_id
        foreign key (state_id)
        references state(state_id)            
);

create table reservation (
	reservation_id int primary key auto_increment,
	location_id int not null,
    guest_user_id int not null,
    start_date date not null,
    end_date date not null,
    total decimal(10, 2) not null,
    constraint fk_reservation_location_id
        foreign key (location_id)
        references location(location_id),
    constraint fk_reservation_guest_user_id
        foreign key (guest_user_id)
        references user(user_id)    
);

delimiter //
create procedure set_known_good_state()
begin
	delete from reservation;
    delete from location;
    delete from `user`;
	delete from state;
    alter table reservation auto_increment=1;
    alter table location auto_increment=1;
	alter table `user` auto_increment=1;
    alter table state auto_increment=1;
    
    insert into state (`name`, usps_code)
		values 
        ('CA', '11'),
        ('NY','22');
    
    insert into `user` (first_name, last_name, email, phone)
		values
		('John', 'Doe', 'test@gmail.com', '1234567890'),
        ('Jane', 'Smith', 'email@yahoo.com','0987654321');
    
	insert into location (user_id, address, city, postal_code, state_id, standard_rate,weekend_rate) 
		values
		(1,'address1','city1','zip1',1,10.5,10.5),
		(2,'address2','city2','zip2',2,10.5,10.5);
    
	insert into reservation (location_id,guest_user_id,start_date,end_date,total) 
    values
		(1,1,'2025-02-02','2025-02-10',63),
        (2,2,'2025-01-01','2025-01-06',115.5);
        
end//
delimiter ;