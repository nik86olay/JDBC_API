select product_name
from person.orders
         INNER JOIN person.customers
                    on orders.customer_id = customers.id
where lower(customers.name) = lower(:name)