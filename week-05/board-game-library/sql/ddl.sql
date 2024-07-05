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
    rating decimal(4,1) not null default 5.0,
    minimum_players int not null,
    maximum_players int not null,
    checked_out bit default 0,
    board_game_weight_id int not null,
    constraint fk_board_game_board_game_weight_id
		foreign key (board_game_weight_id)
        references board_game_weight(board_game_weight_id)
);

insert into board_game_weight(weight) 
values 
	('CASUAL'),
    ('LIGHT'),
    ('MEDIUM'),
    ('HEAVY');
    
delimiter //

create procedure set_known_good_state()
begin

delete from board_game;
alter table board_game auto_increment = 1;

insert into board_game(title, rating, minimum_players, maximum_players, checked_out, board_game_weight_id)
value 
	('Test Title1',9,1,4,0, (select board_game_weight_id from board_game_weight where weight = 'MEDIUM')),
	('Test Title2',8,2,5,1,(select board_game_weight_id from board_game_weight where weight = 'LIGHT')),
	('Test Title3',7,3,6,0,(select board_game_weight_id from board_game_weight where weight = 'MEDIUM'));

end //

delimiter ;