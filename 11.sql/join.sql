desc customer;

desc address;

-- 예전 방식
SELECT c.first_name, c.last_name, a.address
FROM customer AS c JOIN address AS a LIMIT 100;

SELECT c.first_name, c.last_name, a.address
FROM customer AS c JOIN address AS a
WHERE c.address_id = a.address_id;

SELECT c.first_name, c.last_name, a.address
FROM customer AS c INNER JOIN address AS a
ON c.address_id = a.address_id -- 조인 조건 기술
WHERE a.postal_code = 52137;