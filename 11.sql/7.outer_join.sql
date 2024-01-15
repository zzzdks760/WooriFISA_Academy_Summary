SELECT a.x AS 'x of ta', b.x AS 'x of tb'
FROM ta a
LEFT JOIN tb b
ON b.x = a.x AND a.x > 1;

select * from ta;
select * from tb;