SELECT * FROM category;

SELECT * FROM category WHERE category_id = 14; -- category_id 가 14인 데이터만 조회 (한줄씩 true/false 체크)

SELECT * FROM customer
WHERE first_name = 'KAREN';

SELECT first_name, last_name FROM actor WHERE first_name = 'NICK';

SELECT * FROM film;

SELECT CONCAT(title, '의 줄거리', description) AS Summary
FROM film;

SELECT * FROM customer
WHERE first_name = 'VIRGINIA' AND last_name = 'BLUE';

SELECT * FROM customer
WHERE first_name = 'VIRGINIA' AND last_name = 'GREEN';

-- film_category 테이블에서 category가 Animation이거나 Games인 모든 열 조회
select * from film_category
where category_id = 2 or category_id = 10;

-- customer 테이블에서 (first_name이 ‘STEVEN’이거나 last_name이 ‘YOUNG’이고) 
-- create_date가 2006년 1월 1일 이후인 회원 조회
select * from customer 
where (first_name = 'STEVEN' or last_name = 'YOUNG') and create_date >= '2006-01-01'; 

select * from rental;
-- 동등 조건(Equality)
-- actor 테이블에서 first_name이 ‘GRACE’인 배우(Actor)의 데이터 조회
select * from actor
where first_name = 'GRACE';

-- 부등 조건
-- category 테이블에서 name이 Family가 아닌 모든 카테고리 조회
select * from category
where name != 'Family';

-- 범위 조건
-- rental 테이블에서 rental_date가 2005-05-25 이전에 빌려간 회원의 id와 대여 날짜를 조회
select customer_id, rental_date from rental where rental_date < '2005-05-25';

-- rental 테이블에서 rental_date가 2005-05-24부터 2005-05-25 사이의 rental_date 열 조회
select rental_date from rental where rental_date >= '2005-5-24' and rental_date <= '2005-05-25';

select rental_date from rental where rental_date between '2005-05-24 23:00:00' and '2005-05-25';

-- rental 테이블에서 customer_id가 155번인 대여기록 중 rental_id, customer_id, return_date 열만 조회
select rental_id, customer_id, return_date from rental where customer_id = 155;

-- 
select * from customer;
select * from film_category;
select * from category;
-- customer 테이블에서 first_name이 B로 시작하는 회원의 데이터를 모두 조회하고 first_name을 fn으로 last_name은 ln으로 바꿔서 조회
select first_name as fn, last_name as ln from customer where first_name like "B%";

-- film 테이블에서 rental_duration이 4일 이상인 film을 제외하고 film_id를 기준으로 내림차순 정렬 조회
select * from film where rental_duration > 4
order by film_id desc; 

-- film 테이블에서 release_year가 6으로 끝나는 해이면서 length가 100부터 200사이의 title을 조회
select title from film where release_year LIKE '%6' and length between 100 and 200;

-- customer 테이블에서 first_name중 B를 포함하고 있고 last_name은 W로 시작하는 customer_id 기준 모든 열을 내림차순으로 조회
select * from customer where first_name like '%B%' and last_name like 'W%' order by customer_id desc;

-- film_category에서 name이 A로 시작하는 열 조회
select * from film_category where category_id = 1 and category_id = 2;
