use gravel_family;

-- Solve each task by writing a query below the task description.
-- Each task describes the expected result.
-- Unfortunately, tasks must be verified manually. :(

-- Example: 
-- Count the number of customer in Toronto
-- Expected: 14
select 
count(c.customer_id)
from customer c
where c.city = 'Toronto';

-- How many employees have the last_name 'Soyle'?
-- Expected: 12
select
count(e.last_name)
from employee e
where e.last_name = 'Soyle';

-- How many projects are there in the database?
-- Expected: 1121
select
count(p.project_id) project_count
from project p;

-- What's the earliest project start_date?
-- Expected: 2017-09-23
select 
min(p.start_date)
from project p;

-- What's the latest employee start_date?
-- Expected: 2020-08-25
select
max(e.start_date) latest_start_date
from employee e;

-- Count customers per city.
-- Expected: 88 Rows
select 
c.city,
count(*) 
from customer c
group by c.city;


-- Count customers per postal_code.
-- Expected: 84 Rows
select
c.postal_code,
count(*) as customer_count
from customer c
group by c.postal_code;

-- Count employees per last_name.
-- Expected: 3 Rows
select
e.last_name,
count(*)
from employee e
group by e.last_name;

-- Count the number of projects per city.
-- Expected: 88 Rows
-- Error Code: 1055. Expression #1 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'gravel_family.p.project_id' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by

select
c.city,
count(p.project_id)
from customer c
left outer join project p on c.customer_id=p.customer_id
group by c.city;

-- Count the number of projects per city.
-- Sort by the count descending and select the top 10 rows.
-- Expected: 10 Rows

select 
c.city,
count(p.project_id) as project_amount
from customer c
left outer join project p on c.customer_id=p.customer_id
group by c.city
order by count(p.project_id) desc
limit 10;


-- Which postal_code has the most projects?
-- Expected: M3H

-- Count the number of projects per start_date year.
-- Expected: 4 Rows

-- Count the number of employees per project in the M3H postal_code.
-- Group by project_id, sort by count descending.
-- Expected: 39 Rows

-- Calculate the total cost per project in the 'M3H' postal_code.
-- (Hint: sum a calculation)
-- Expected: 39 Rows

-- What's the most expensive project in the 'M3H' postal_code?
-- Expected: 18828.00

-- How many projects did each employee work on?
-- Expected: 33 Rows

-- How many employees worked on more than 140 projects?
-- Expected: 10 Rows

-- How many projects cost more than $20,000?
-- Expected: 55 Rows

-- Across all projects, what are the total costs per item?
-- Select the item name and sum.
-- Sort by the sum desc;
-- Expected: 18 Rows

-- Across all projects, what are the total costs per item category?
-- Select the category name and sum.
-- Sort by the sum desc;
-- Expected: 7 Rows

-- What's the average 'Standard Labor' cost per city?
-- Expected: 88 Rows

-- Challenge: Which customer has the first project of 2019?
-- (Requires a subquery.)
-- Expected: Starkie 2019-01-01