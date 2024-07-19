drop database if exists solar_farm_test;
create database solar_farm_test;
use solar_farm_test;

create table solar_panel (
    solar_panel_id int primary key auto_increment,
    section varchar(50) not null,
    `row` int not null,
    `column` int not null,
    year_installed char(4) not null,
    is_tracking bit not null,
    material varchar(20) not null,
    constraint uq_section_id_row_column
        unique(section, `row`, `column`)
);

delimiter //
create procedure set_known_good_state()
begin
    delete from solar_panel;
    alter table solar_panel auto_increment=1;

    insert into solar_panel (section, `row`, `column`, year_installed, material, is_tracking)
        values
        ('The Ridge', 1, 1, '2020', 'POLY_SI', true),
        ('The Ridge', 1, 2, '2019', 'MONO_SI', true),
        ('Flats', 1, 1, '2017', 'A_SI', true),
        ('Flats', 2, 6, '2017', 'CD_TE', true),
        ('Flats', 3, 7, '2000', 'CIGS', false);
end//
delimiter ;