drop database if exists solar_farm;
create database solar_farm;
use solar_farm;

create table solar_panel (
    solar_panel_id int primary key auto_increment,
    solar_panel_section varchar(50) not null,
    solar_panel_row int not null,
    solar_panel_column int not null,
    year_installed char(4) not null,
    is_tracking int not null,
    material varchar(20) not null,
    constraint uq_section_id_row_column
        unique(solar_panel_section, solar_panel_row, solar_panel_column)
);