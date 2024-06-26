use bowls;

select 
	customer.customer_id,
    customer.last_name,
    login.user_name
from customer
inner join login on customer.customer_id = login.customer_id;

select *
from customer
inner join login on customer.customer_id = login.customer_id
where customer.last_name like 'M%'
order by login.user_name desc;

select 
	customer.customer_id,
    customer.last_name,
    login.user_name
from customer
left outer join login on customer.customer_id = login.customer_id;


