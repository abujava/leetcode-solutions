-- Medium https://leetcode.com/problems/consecutive-numbers

Create table If Not Exists Logs (id int, num int);
Truncate table Logs;
insert into Logs (id, num) values ('1', '1');
insert into Logs (id, num) values ('2', '1');
insert into Logs (id, num) values ('3', '1');
insert into Logs (id, num) values ('4', '2');
insert into Logs (id, num) values ('5', '1');
insert into Logs (id, num) values ('6', '2');
insert into Logs (id, num) values ('7', '2');

------------------------------- Solution -------------------------------
WITH data AS (
    select *, lag(num) over (order by id) as prev_num, lead(num) over (order by id) as next_num from Logs
)
SELECT distinct num as ConsecutiveNums
FROM data
where data.num = data.prev_num and data.num = next_num;
