SELECT now();

SELECT * FROM language; -- language 테이블 조회
SELECT name FROM language; -- language 테이블의 name 컬럼 조회

SELECT language_id, name, last_update FROM language; -- 컬럼 별 조회

SELECT language_id AS "언어 ID", name FROM language; -- 문자열에 띄어쓰기 있으면 따옴표로 묶기
SELECT language_id AS 언어ID, name AS 이름, last_update AS "마지막 업데이트" FROM language;

SELECT * FROM film_actor LIMIT 50;

select database(); -- 현재 database 위치