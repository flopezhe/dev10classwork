drop database if exists board_game_library_test;
create database board_game_library_test;
use board_game_library_test;

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
    
delimiter //

create procedure set_known_good_state()
begin

delete from publisher_board_game;
delete from board_game;
delete from publisher;
alter table board_game auto_increment = 1;
alter table publisher auto_increment = 1;
alter table publisher_board_game auto_increment = 1;

insert into publisher(`name`, established_date)
values
	('Test Publisher1', adddate(curdate(), interval -1 year)),
	('Test Publisher2', adddate(curdate(), interval -2 year)),
	('Test Publisher3', adddate(curdate(), interval -3 year));

insert into board_game(title, rating, minimum_players, maximum_players, checked_out, board_game_weight_id)
value 
	('Test Title1',9,1,4,0, (select board_game_weight_id from board_game_weight where weight = 'MEDIUM')),
	('Test Title2',8,2,5,1,(select board_game_weight_id from board_game_weight where weight = 'LIGHT')),
	('Test Title3',7,3,6,0,(select board_game_weight_id from board_game_weight where weight = 'MEDIUM'));
    
insert into publisher_board_game (publisher_id, board_game_id, published_date)
values
	(1, 1, adddate(curdate(), interval -1 year)),
	(1, 2, adddate(curdate(), interval -2 year)),
	(2, 1, adddate(curdate(), interval -3 year)),
	(2, 3, adddate(curdate(), interval -4 year));

end //

delimiter ;