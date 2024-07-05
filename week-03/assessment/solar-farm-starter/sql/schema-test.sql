drop database if exists solar_farm_test;
create database solar_farm_test;

create table solar_panel(
solar_panel_id int primary key auto_increment,
`section` varchar(100) not null,
`row` int not null,
`column` int not null,
`material` varchar(10) not null,
installation_year int not null,
is_tracked tinyint(1) not null
);

delimiter //

create procedure set_known_good_state()
begin
	delete from solar_panel;
    alter table solar_panel auto_increment=1;
    
    isert into solar_panel(`section`, `row`,`column`,`material`,installation_year,is_tracked)
    values (`section`,1,1,