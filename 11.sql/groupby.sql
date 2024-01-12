select * from rental;
select * from customer;

select customer_id, count(rental_date)
from rental
group by customer_id;

SELECT customer_id, COUNT(*)
FROM rental
group by customer_id
ORDER BY 2 DESC;

SELECT customer_id, COUNT(*)
FROM rental
GROUP BY customer_id
HAVING COUNT(*) < 40
ORDER BY 2 DESC;
