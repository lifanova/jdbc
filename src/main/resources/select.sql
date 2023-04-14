select *
from netology.orders od
         join netology.customers cu on od.customer_id = cu.id
where name = :name;