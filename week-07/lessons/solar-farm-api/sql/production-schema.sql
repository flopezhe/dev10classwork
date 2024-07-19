drop database if exists solar;
create database solar;
use solar;

create table panel (
	panel_id int primary key auto_increment,
    section varchar(50) not null,
    `row` int not null,
    `column` int not null,
    year_installed int not null,
    material varchar(50) not null,
    is_tracking boolean not null,
    constraint uq_section_row_column
		unique(section, `row`, `column`)
);

insert into panel (section, `row`, `column`, year_installed, material, is_tracking)
		values
        ('The Ridge', 1, 1, 2020, 'POLY_SI', true),
        ('The Ridge', 1, 2, 2020, 'CD_TE', true),
        ('The Ridge', 1, 3, 2020, 'MONO_SI', true),
        ('Flats', 4, 1, 2020, 'A_SI', false),
        ('Flats', 5, 1, 2020, 'MONO_SI', false);