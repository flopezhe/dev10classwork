drop database if exists board_game_library;
create database board_game_library;
use board_game_library;

create table board_game_weight (
	board_game_weight_id int primary key auto_increment,
    weight varchar(25) not null
);
    
create table board_game (
	board_game_id int primary key auto_increment,
    title varchar(255) not null,
    rating decimal(3,1) not null default 5.0,
    minimum_players int not null,
    maximum_players int not null,
    checked_out bit default 0,
    board_game_weight_id int not null,
    constraint fk_board_game_board_game_weight_id
		foreign key (board_game_weight_id)
        references board_game_weight(board_game_weight_id)
);

create table publisher (
	publisher_id int primary key auto_increment,
    `name` varchar(255) not null,
    established_date date
);

create table publisher_board_game (
	publisher_board_game_id int primary key auto_increment,
    publisher_id int not null,
    board_game_id int not null,
    published_date date,
    constraint fk_publisher_board_game_publisher_id
		foreign key (publisher_id)
        references publisher(publisher_id),
    constraint fk_publisher_board_game_board_game_id
		foreign key (board_game_id)
        references board_game(board_game_id)
);

insert into board_game_weight(board_game_weight_id, weight) 
values 
	(1, 'CASUAL'),
    (2, 'LIGHT'),
    (3, 'MEDIUM'),
    (4, 'HEAVY');