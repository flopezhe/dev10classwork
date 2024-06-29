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


    



        
        
        