-- 1.actor 테이블 내 모든 컬럼이 포함된 전체 데이터(행) 조회
select * from actor;

-- 2.actor 테이블에서 last_name 컬럼만 포함된 전체 데이터 조회
select last_name
from actor;

select * from film;
-- 3.film 테이블에서 영화 제목, 영화 설명, 대여 기간(rental_duration), 대여 비용(rental_rate), 총 렌탈 비용(직접 생성할 새로운 컬럼)
-- 에 해당하는 데이터를 상위 10개만 조회
-- select title, description, rental_duration, count(rental_rate) as '총 렌탈 비용'
-- from film
-- group by

-- 4.actor 테이블에서 서로 다른(겹치지 않는) last_name열에 해당하는 모든 데이터 조회
select distinct last_name
from actor;

-- 5.address 테이블에서 서로 다른 postal_code열에 해당하는 모든 데이터 조회
select distinct postal_code
from address;

select * from film;
-- 6.film 테이블에서 영화 제목, 줄거리, rating(영화 등급), length(영화 러닝타임, minutes 기준) 열에 해당하는 모든 데이터를 조회하되,
-- 러닝타임이 3시간 이상인 데이터만 필터링하여 조회
select title, description, rating, length
from film
where length >= 180;

select * from payment;
-- 7.payment 테이블에서 payment_id, 금액, 지불날짜 열에 해당하는 모든 데이터를 조회하되, 2005년 8월 23일 자정 이후에 지불된 데이터만 필터링하여 조회
select payment_id, amount, payment_date
from payment
where payment_date > '2005-08-23';

-- 8.payment 테이블에서 payment_id, 금액, 지불날짜 열에 해당하는 모든 데이터를 조회하되, 지불날짜가 2005년 8월 23일만 해당하는 모든 데이터 조회
select payment_id, amount, payment_date
from payment
where payment_date between '2005-08-22 23:59:59' and '2005-08-24 00:00:00'; 

select * from customer;
-- 9.customer 테이블에서 모든 열에 해당하는 데이터를 조회하되, last_name이 s로 시작하고, first_name이 n으로 끝나는 데이터만 필터링하여 조회
select *
from customer
where last_name like 's%' and first_name like '%n';

-- 10.customer 테이블에서 모든 열에 해당하는 데이터를 조회하되, 휴면 사용자(active 컬럼 참고) 이거나, last_name이 m으로 시작하는 데이터만 필터링하여 조회
select *
from customer
where active = false or last_name like 'm%';

-- 11.category 테이블에서 모든 열에 해당하는 데이터를 조회하되, category_id가 4보다 크고,
-- name 열에 해당하는 데이터가 c로 시작하거나, s로 시작하거나, t로 시작하는 데이터로 필터링하여 조회
select *
from category
where category_id > 4 and
name like 'c%' or
name like 's%' or
name like 't%';

-- 12.address 테이블에서 phone, 구역(district) 컬럼을 조회하되,
-- 구역이 California, England, Taipei, West Java에 해당하는 구역만 필터링하고, district 컬럼을 기준으로 오름차순 정렬하여 조회
select phone, district
from address
where district = 'California' or
district = 'England' or
district = 'Taipei' or
district = 'West Java'
order by district;

select * from payment;
-- 13.payment 테이블에서 payment_id, 금액, 지불날짜 열에 해당하는 데이터를 조회하되,
-- 지불날짜가 2005년 8월 23일, 24일, 25일에 해당하는 데이터만 조회(IN, Date() 활용)
select payment_id, amount, payment_date
from payment
where IN(Date(payment_date) =)