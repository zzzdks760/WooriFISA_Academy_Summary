CREATE TABLE TODO (
	id INT(5) unsigned NOT NULL AUTO_INCREMENT,
	title VARCHAR(255),
	description VARCHAR(255),
	due_date DATE,
	is_completed BOOLEAN DEFAULT false,
	PRIMARY KEY (`id`)
);

INSERT INTO TODO (title, description, due_date) VALUES ('숙제하기', '수학, 영어 숙제를 한다', '2022-04-05');
INSERT INTO TODO (title, description, due_date) VALUES ('조깅하기', '공원에서 1시간 동안 조깅을 한다.', '2022-05-07');
INSERT INTO TODO (title, description, due_date) VALUES ('빨래하기', '빨래를 모아서 세탁기를 돌린다.', '2022-04-04');
INSERT INTO TODO (title, description, due_date) VALUES ('피아노치기', '학원에서 피아노를 연습한다.', '2022-04-09');
INSERT INTO TODO (title, description, due_date) VALUES ('강아지 밥주기', '강아지에게 사료를 준다.', '2022-04-07');
commit;