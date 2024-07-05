drop database if exists solar_farm;
create database solar_farm;

create table solar_panel(
solar_panel_id int primary key auto_increment,
`section` varchar(100) not null,
`row` int not null,
`column` int not null,
`material` varchar(10) not null,
installation_year int not null,
is_tracked tinyint(1) not null
);




