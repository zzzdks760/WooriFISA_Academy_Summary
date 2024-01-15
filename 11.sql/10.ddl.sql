-- 7.ddl.sql
SELECT database();

use testdb;

CREATE TABLE person (
-- 컬럼명 컬럼타입,
	person_id SMALLINT UNSIGNED,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    eye_color ENUM('BR', 'BL', 'GR'),
	birth_date DATE,
	street VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(20),
    CONSTRAINT pk_person PRIMARY KEY (person_id)
    -- person 테이블에 제약 조건을 지정할건데,
    -- 제약 조건의 이름은 pk_person
    -- 제약 조건 내용은 person_id 필드를 기본키로 지정하겠다
);

show tables;

-- 테이블 메타정보 조회
DESC person;


-- favorite food 테이블 생성
CREATE TABLE favorite_food (
	person_id SMALLINT UNSIGNED,
    food VARCHAR(20),
    CONSTRAINT pk_favorite_food PRIMARY KEY(person_id, food)
);

-- 테이블 정보 조회
DESC favorite_food;

DESC person;

ALTER TABLE favorite_food 
ADD CONSTRAINT fk_favorite_food_person_id
FOREIGN KEY (person_id)
REFERENCES person (person_id);

DESC favorite_food;

show databases;

SELECT *
FROM information_schema.REFERENTIAL_CONSTRAINTS
WHERE table_name = 'favorite_food';

DESC person;

ALTER TABLE person MODIFY person_id
SMALLINT UNSIGNED AUTO_INCREMENT;
-- Error Code: 1833. 
-- Cannot change column 'person_id': 
-- used in a foreign key constraint 'fk_favorite_food_person_id' of table 'testdb.favorite_food'

SET foreign_key_checks = 0;

SET foreign_key_checks = 1;

-- 추가
INSERT INTO person (first_name, last_name, eye_color, birth_date, street)
VALUES ('STERINE', 'LEE', 'BR', '1999-05-02', 'MILD TASTE STREET');

INSERT INTO person (first_name, last_name, eye_color, birth_date, street)
VALUES ('SUNGMIN', 'AHN', 'BR', '1998-05-17', 'KIMPO');

INSERT INTO favorite_food (person_id, food) VALUES (1, 'pizza');

SELECT * FROM favorite_food;
SELECT * FROM person;

-- 업데이트
UPDATE person
SET street = 'SPIDER STREET',
state = 'NA',
country = 'USA',
postal_code = '14231'
WHERE person_id = 1;

select * from person;

-- safe 기능
set sql_safe_updates = 0;
set sql_safe_updates = 1;
-- 삭제
DELETE FROM person;

ALTER TABLE favorite_food DROP FOREIGN KEY
fk_favorite_food_person_id;

select * from person;















show databases;
use market;
show tables;

drop database market;
create database market;
use market;



CREATE TABLE product (
	product_id INT NOT NULL AUTO_INCREMENT,
    date DATETIME,
    item VARCHAR(20),
    brand VARCHAR(20),
    quantity INT NOT NULL,
    price INT NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (product_id)
);

desc product;

INSERT INTO product (date, item, brand, quantity, price)
VALUES ('2023-06-12 09:03:21', '김밥', '하림', 1, 14000);
select * from product;

INSERT INTO product (date, item, brand, quantity, price)
VALUES
('2023-01-29 01:00:21','카누','농심',2,152200),
('2023-02-28 01:00:21','Cinema','오리온',3,3980),
('2023-03-02 03:00:21','용가리','하림',1,4980),
('2023-04-13 12:00:21','Salary','대상',2,5480),
('2023-05-02 20:00:21','삼양라면','삼양식품',8,9480),
('2023-05-02 01:00:21','Pizza','크라운제과',7,7480),
('2023-05-03 01:00:21','Pizza','대상',5,20000),
('2023-08-03 17:00:21','빵파레','빙그레',8,20000),
('2023-09-04 18:00:21','새우깡','농심',5,20000),
('2023-10-03 19:00:21','pasta','오리온',1,20000),
('2023-12-03 02:00:21','짜장면','종원이형',4,8000),
('2023-12-04 04:00:21','coffee','starbucks',1,5000),
('2023-03-02 06:00:21','치킨너겟','하림',3,20000),
('2023-04-02 10:10:21','닭가슴살','하림',5,20000),
('2023-05-02 12:00:21','햄','하림',6,20000),
('2023-06-12 13:00:21','3분카레','오뚜기',13,20000),
('2023-07-02 05:00:21','둥지냉면','농심',2,20000),
('2023-08-04 03:00:21','생칼국수','하림',20,20000),
('2023-09-04 04:00:21','중화짬뽕','하림',100,20000),
('2023-10-02 22:01:21','까르보나라','하림',5,20000),
('2023-02-02 05:02:21','불닭볶음면','종원이형',10,20000),
('2023-03-02 10:03:56','신라면','농심',1,20000),
('2023-03-02 11:00:21','가쓰오','하림',1,20000),
('2023-03-03 11:00:46','간짜장','오뚜기',1,2150),
('2023-03-01 11:00:35','쫄면','하림',4,15000),
('2023-03-02 10:01:41','가쓰오우동','하림',1,25000),
('2023-03-02 21:02:31','김밥','CJ',8,14000),
('2023-06-12 09:03:21','김밥','하림',1,14000),
('2023-05-02 09:04:21','김밥','하림',2,14000),
('2023-03-02 21:00:21','쌀국수','삼양',7,12000),
('2023-06-16 11:00:21','짬뽕순두부','종원이형',5,12000),
('2023-03-02 12:00:21','해주냉면','하림',1,12000),
('2023-07-05 12:00:21','유니짜장','오리온',6,12000),
('2023-03-02 13:00:21','가벼운 고단백','하림',4,2000),
('2023-03-02 13:00:21','무거운 저단백','하림',3,2000),
('2023-06-12 14:00:21','비비고 왕교자','CJ',100,2000),
('2023-03-03 15:00:21','심야식당','하림',5,6200),
('2023-03-12 18:00:21','치킨','하림',8,20000),
('2023-03-14 19:00:21','트러플 파스타','하림',4,20000),
('2023-03-15 15:00:21','돈까스','하림',17,10480);