drop database if exists pets;
create database pets;
use pets;

create table pet (
    id int primary key auto_increment,
    name varchar(255) not null,
    species varchar(255) not null,
    breed varchar(255) not null,
    description varchar(255) not null,
    dob date null,
    image_url text null
);

insert into pet (name, species, breed, description, dob, image_url)
    values
('Daisy', 'Dog', 'Cocker Spaniel', 'Blonde, brown eyes', '1996-09-11', 'https://imgur.com/kbOewjN'),
('Jimmy', 'Cat', 'Domestic Shorthair', 'Black, green eyes', '2007-07-07', 'https://imgur.com/zA1YfVS'),
('Gordon', 'Cat', 'Domestic Shorthair', 'White with orange markings', '2008-11-11', 'https://imgur.com/BohUJLX'),
('Diego', 'Cat', 'Domestic Shorthair', 'Black, golden eyes', null, 'https://imgur.com/OEW5F1R'),
('Lionel', 'Cat', 'Domestic Shorthair', 'Gray and brown tabby with white markings', null, 'https://imgur.com/5PCdGUm');

