select database();

use testdb;

CREATE TABLE person ( -- CREATE TABLE 테이블명
	person_id SMALLINT UNSIGNED, -- 필드 데이터타입,(comma로 구분)
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	eye_color ENUM('BR', 'BL', 'GR'),
	birth_date DATE,
	street VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(20),
	CONSTRAINT pk_person PRIMARY KEY (person_id) -- 기본키로 사용하곘다는 제약조건 명시
  -- CONSTRAINT 제약조건이름 PRIMARY KEY (필드이름)
);

show tables;
desc person;

CREATE TABLE favorite_food (
	person_id SMALLINT UNSIGNED,
    food VARCHAR(20),
    CONSTRAINT pk_favorite_food PRIMARY KEY(person_id, food)
);

desc favorite_food;

ALTER TABLE favorite_food
ADD CONSTRAINT fk_favorite_food_person_id
FOREIGN KEY (person_id)
REFERENCES person(person_id);



