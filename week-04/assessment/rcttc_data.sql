-- DML
 use rcttc;

 insert into tiny_theaters.customer (first_name, last_name, email_address, phone_number, home_address)
 select distinct
     customer_first,
	 customer_last,
     customer_email,
     customer_phone,
    customer_address
  from 
     rcttc.rcttc_import;
    


 insert into tiny_theaters.theater(theater_name, theater_address,theater_phone,theater_email)
 select distinct
	 theater,
	 theater_address,
     theater_phone,
    theater_email 
 from 
	 rcttc.rcttc_import;



    
insert into tiny_theaters.`show`(show_name, show_date, show_price, theater_id)
select distinct
	i.`show`,
	i.`date`,
	i.ticket_price,
    t.theater_id
from
	rcttc.rcttc_import i
inner join tiny_theaters.theater t on i.theater = t.theater_name ;


insert into tiny_theaters.tickets(ticket_seat, customer_id, show_id)
select distinct
	i.seat,
    c.customer_id,
    s.show_id
from rcttc.rcttc_import i
inner join tiny_theaters.customer c on c.last_name  = i.customer_last
inner join tiny_theaters.`show` s on s.show_name = i.`show` and s.show_date = i.`date`;


use tiny_theaters;

update `show` set 
	show_price = 22.25
where show_id = 5;

update customer set 
	phone_number = '1-801-EAT-CAKE'
where customer_id = 48;

-- update seats for 2 customers to sit together
-- ticket id 98 to B4 ticket ID 99(C1) OR 100 (B4) TO C2 TICKET ID 101 TO A4
update tickets set 
ticket_seat = 'B4'
where ticket_id = 98;

update tickets set 
ticket_seat = 'C2'
where ticket_id = 100;

update tickets set 
ticket_seat = 'A4'
where ticket_id = 101;

-- delete single reservation tix
-- single reservation customer id 7 8 10 15 18 19 22 25 26 
-- ticket id 25 26 29 41 50 51 59 67 68
delete from tickets 
where ticket_id in (25, 26, 29,41, 50, 51, 59, 67, 68);

-- delete liv fake customer
-- customer id 65
-- ticket id 173 174 
delete from tickets 
where ticket_id in (173,174);

delete from customer
where customer_id = 65;






    



        
        
        