show databases;
use sakila;
show tables;

-- 1. actor 테이블에서 전체 열 조회
select * from actor;

-- 2. actor 테이블에서 first_name, last_name 컬럼 조회
select first_name, last_name from actor;

-- 3. actor 테이블에서 first_name과 last_name을 하나로 연결(concat)하여 Actor Name이라는 컬럼명으로 조회하고, 전부 대문자로 조회
select UPPER(CONCAT(first_name, last_name)) AS 'Actor Name'
from actor;

-- 4. actor 테이블에서 actor_id, first_name, last_name을 조회하되, first_name이 Joe인 데이터만 필터링하여 조회
select actor_id, first_name, last_name
from actor
where first_name = 'Joe';

-- 5.actor 테이블에서 actor_id, first_name, last_name을 조회하되, last_name 에 Gen이 포함된 actor를 필터링하여 조회
select actor_id, first_name, last_name
from actor
where last_name like "%Gen%";

-- 6.actor 테이블에서 actor_id, first_name, last_name을 조회하되, last_name에 LI(엘, 아이)가 포함된 데이터를 필터링하고, last_name, first_name 순서로 오름차순 정렬하여 조회
select actor_id, first_name, last_name
from actor
where last_name like "%LI%"
order by last_name, first_name;

-- 7.country 테이블에서 country_id, country 열을 조회하되, IN 연산자를 활용하여 country가 Afghanistan, Bangladesh, China 중에 속하는 데이터만 필터링하여 조회
select country_id, country
from country
where country in('Afghanistan', 'Bangladesh', 'China');

-- 8.actor 테이블에서 서로 동일한 last_name을 사용하는 배우(actor)들이 각각 몇 명인지 조회하고 싶을 때,
-- actor 테이블에서 last_name 컬럼과 해당 last_name을 사용하는 사람의 인원 수를 집계해주는 컬럼을 조회**
select last_name, count(last_name)
from actor
group by last_name;

-- 9.actor 테이블에서 last_name 컬럼과 해당 last_name을 사용하는 수를 집계해주는 컬럼을 조회하되,
-- 집계되는 컬럼의 별칭은 ‘Count of Last Name’ 이라고 짓고, last_name 카운트가 2 초과인 그룹만 필터링하여 조회
select last_name, count(last_name) as 'Count of Last Name'
from actor
group by last_name
having count(last_name) > 2;

-- 10.address 테이블의 정보(description) 조회
desc address;

-- 11.address 테이블의 총 행 수 조회
select COUNT(*) AS '총 행 수'
from address;

-- 12.address 테이블의 가상 상위 데이터 5개만 제한(LIMIT)하여 조회
select * 
from address
LIMIT 5;

select * from staff;
select * from address;
-- 13.staff 테이블의 별칭을 s, address 테이블의 별칭을 a로 짓고,
-- 두 테이블을 연결(JOIN)하여 address_id가 일치하는 first_name, last_name, address를 조회
select first_name, last_name, address
from address a
INNER JOIN staff s
ON s.address_id = a.address_id;

select * from payment;
select * from staff;
-- 14. staff 테이블의 별칭을 s, payment 테이블의 별칭을 p로 짓고,
-- 두 테이블을 연결(JOIN)하여 staff_id가 일치하는 조건의 staff_id, first_name, last_name 및 amount의 총 금액(sum) 컬럼을 조회하되,
-- payment_date가 2005-08-01 00:00:00 이후이고, 2005-08-02 00:00:00 ‘미만’인 데이터만 필터링하여 staff_id를 기준으로 묶어서(grouping) 조회**
select s.staff_id, s.first_name, s.last_name, count(p.amount) as 'sum'
from staff s
Inner JOIN payment p
ON s.staff_id = p.staff_id
where p.payment_date between '2005-08-01 00:00:00' and '2005-08-02 00:00:00'
group by staff_id;

select * from film;
select * from film_actor;
-- 15.film 테이블의 별칭을 f, film_actor 테이블의 별칭을 fa로 짓고, 두 테이블을 연결(JOIN)하여 각 film_id가 일치하는 조건의
-- title 및 해당 film에 참여한 총 actor의 수를 의미하는 컬럼 ‘총 배우 수’ 컬럼을 film 테이블의 title 별로(grouping) 조회
-- (단, 이대로 조회하면 결과 데이터가 총 997행이기 때문에 상위 20개의 행만 제한하여 조회) → 실행 결과 행의 수는 총 20개(로 제한, LIMIT 사용)
select f.title, count(fa.actor_id) as '총 배우 수'
from film f
Inner Join film_actor fa
ON f.film_id = fa.film_id
group by f.title
LIMIT 20;

-- 16.inventory 테이블의 정보(description) 조회
desc inventory;

-- 17.inventory 테이블의 데이터 상위 10개 조회
select * from inventory
LIMIT 10;

-- 18.film 테이블에서 title, description 컬럼을 조회하되, 상위 20개만 조회
select title, description
from film
LIMIT 20;

select * from film;
select * from inventory;
-- 19.ALABAMA DEVIL film이 모든 영화 대여점에 총 몇 개의 복제본(영화 필름)이 배포되어있는지 알고 싶을 때,
-- film 테이블의 별칭을 f, inventory 테이블의 별칭을 i로 짓고, 두 테이블을 연결(JOIN)하여 film_id 컬럼이 일치하는 조건의
-- title 및 film_id의 총 개수(count)를 ‘복제본’으로 별칭을 작성하여 title 별로 조회하되, title이 ‘ALABAMA DEVIL’인 film만 조회**
select f.title, count(i.film_id) as '복제본'
from film f
INNER JOIN inventory i
ON f.film_id = i.film_Id
where title = 'ALABAMA DEVIL';

select * from customer;
select * from payment;
-- 20.고객 별 총 사용 금액을 last_name을 오름차순 정렬하여 조회하고 싶을 때,
-- customer 테이블의 별칭을 c, payment 테이블의 별칭을 p로 짓고, 두 테이블을 customer_id컬럼으로 연결(JOIN)하여
-- first_name, last_name, amount의 총 액수를 조회하되, first_name, last_name 순으로 묶어서(grouping) last_name을 기준으로 오름차순하여 조회**
select c.first_name, c.last_name, count(p.amount)
from customer c
INNER JOIN payment p
ON c.customer_id = p.customer_id
group by c.first_name, c.last_name
order by last_name;