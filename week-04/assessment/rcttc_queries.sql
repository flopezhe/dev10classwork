-- QUERIES FOR DML ONLY
use rcttc;

select
*
from rcttc_import;

use tiny_theaters;

select 
*
from tickets;

select *
from `show`
where theater_id = 1;
-- show id 1 send in the clowns 2024 03 01
-- show id 2 send in the clowns 2024 09 21
-- show id 3 the dress 2024 01 05 
-- show id 4 tell me what to think 2024 12-21

-- Error Code: 1055. Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'tiny_theaters.tickets.ticket_id' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by

select 
*
from tickets 
where show_id in (1,2,3,4);
-- single reservation customer id 7 8 10 15 18 19 22 25 26 
-- ticket id 25 26 29 41 50 51 59 67 68

select 
*
from theater;
-- theater id is 1

select
*
from customer
where first_name = 'Liv';

select 
*
from tickets
where customer_id = 65;

-- QUERIES for QUERY SECTION

select 
*
from `show`
where date(show_date) >='2024-10-01'
and date (show_date) <= '2024-12-31';

select *
from customer;

select
*
from customer
where email_address like '%.com';



select
* 
from `show`
order by show_price asc
limit 3;

-- Error Code: 1146. Table 'tiny_theaters.ticket' doesn't exist

select distinct
c.first_name,
c.customer_id,
s.show_name
from customer c
inner join tickets t on c.customer_id = t.customer_id
inner join `show` s on t.show_id = s.show_id;

select 
c.first_name,
t.ticket_seat,
s.show_name,
th.theater_name
from customer c
inner join tickets t on c.customer_id = t.customer_id
inner join `show` s on t.show_id = s.show_id
inner join theater th on s.theater_id = th.theater_id;

select
*
from customer
where `home_address` = '';

select 
*
from customer c
inner join tickets t on c.customer_id = t.customer_id
inner join `show` s on t.show_id = s.show_id
inner join theater th on s.theater_id = th.theater_id;

select distinct
c.first_name,
c.customer_id,
count(t.ticket_id)
from customer c
inner join tickets t on c.customer_id = t.customer_id
group by customer_id;


-- count by show
select
s.show_id,
s.show_name,
sum(s.show_price) as total_revenue
from tickets t
inner join `show` s on t.show_id = s.show_id
group by s.show_id, s.show_name;
-- by theater
select
th.theater_name,
sum(s.show_price) as total_revenue
from tickets t
inner join `show` s on t.show_id = s.show_id
inner join theater th on s.theater_id = th.theater_id
group by th.theater_id;

-- customer who spent the most
select distinct
c.first_name,
c.last_name,
c.customer_id,
sum(s.show_price) as total_spent
from customer c
inner join tickets t on c.customer_id = t.customer_id
inner join `show` s on t.show_id= s.show_id
group by customer_id 
order by total_spent desc
limit 1;

-- who spent the most in 2024
select distinct
c.first_name,
sum(s.show_price) as total_spent
from customer c
inner join tickets t on c.customer_id = t.customer_id
inner join `show` s on t.show_id= s.show_id
where date(s.show_date) >='2024-01-01'
and date (s.show_date) <= '2024-12-31'
group by c.customer_id
order by total_spent desc
limit 1;





