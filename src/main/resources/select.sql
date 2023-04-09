select *
from orders od
         join customers cu on od.customer_id = cu.id
where name = ?;