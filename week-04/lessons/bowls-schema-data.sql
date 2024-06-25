select * from sys.sys_config;
use airbnb_nyc;
select 
name,
host_name
from listing;
select * from listing;
select 
name,
neighbourhood,
host_name
from listing
where host_name= 'Andrea'
and availability_365=0;
select 
name,
neighbourhood,
host_name
from listing
where host_name = 'Andrea'
or availability_365=0;
select * from listing where price < 10.0;
select * from listing where last_review = '2019-05-06';
select * from listing where neighbourhood_group= 'Manhattan' and reviews_per_month is null;
select * from listing where neighbourhood_group= 'Manhattan' and reviews_per_month is not null;