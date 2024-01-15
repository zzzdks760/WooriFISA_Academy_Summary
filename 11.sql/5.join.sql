use testdb;

select a.x as 'x of ta', b.x as 'x of tb'
from ta a, tb b;

-- ANSI CROSS JOIN
SELECT a.x 'x of ta', b.x AS 'x of tb'
FROM ta a CROSS JOIN tb b;

-- 등가 조인
SELECT a.x 'x of ta', b.x AS 'x of tb'
FROM ta a, tb b
WHERE b.x = a.x;

-- ANSI NATURAL JOIN
SELECT a.x 'x of ta', b.x AS 'x of tb'
FROM ta a NATURAL JOIN tb b;

SELECT a.x 'x of ta', b.x AS 'x of tb', c.x AS 'x of tc'
FROM ta a, tb b, tc c
WHERE a.x = b.x
AND b.x = c.x;

SELECT a.x AS 'x of ta', b.x AS 'x of tb'
FROM ta a, tb b
WHERE b.x >= a.x;

select * from ta;
select * from tb;
select * from tc;

show tables;