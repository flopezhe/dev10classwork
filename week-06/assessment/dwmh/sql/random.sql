use dwmh;

SELECT
    r.reservation_id,
    r.start_date,
    r.end_date,
    r.total,
    u.user_id,
    l.location_id
FROM reservation r
INNER JOIN `user` u ON r.guest_user_id = u.user_id
INNER JOIN location l ON l.location_id = r.location_id
WHERE l.location_id = 1;

select 
start_date,
end_date,
location_id
from reservation
where location_id=1;
SELECT 
*
FROM reservation r
inner join location l on l.user_id = r.guest_user_id
inner join `user` u on r.guest_user_id = u.user_id;
-- Error Code: 1054. Unknown column 'u.name' in 'field list'

select
r.reservation_id,
r.start_date,
r.end_date,
r.total,
u.user_id as guest_user_id
from reservation r
inner join `user` u on r.guest_user_id = u.user_id
where u.email = 'rklimpt1@paginegialle.it';

use dwmh_test;

select * from reservation;
delete from reservation
where reservation_id = 1;