create table student (
	STUDENT_ID int AUTO_INCREMENT PRIMARY KEY,
	STUDENT_NAME VARCHAR(30),
	MAJOR_ID int,
	foreign key(MAJOR_ID) references major (MAJOR_ID)
);

create table major (
	MAJOR_ID int AUTO_INCREMENT PRIMARY KEY,
	MAJOR_NAME VARCHAR(30),
);

INSERT INTO major VALUES (null, "수학과");
INSERT INTO major VALUES (null, "컴공과");
INSERT INTO major VALUES (null, "국문과");


INSERT INTO student VALUES (null, "김남혁", 1);
INSERT INTO student VALUES (null, "박재현", 2);
INSERT INTO student VALUES (null, "박은혜", 3);

select s.STUDENT_NAME, m.MAJOR_NAME
FROM STUDENT AS s
JOIN MAJOR AS m
ON s.major_id = m.major_id;