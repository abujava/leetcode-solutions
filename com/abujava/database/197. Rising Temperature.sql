-- Easy https://leetcode.com/problems/rising-temperature/

Create table If Not Exists Weather (id int, recordDate date, temperature int);
Truncate table Weather;
insert into Weather (id, recordDate, temperature) values ('1', '2015-01-01', '10');
insert into Weather (id, recordDate, temperature) values ('2', '2015-01-02', '25');
insert into Weather (id, recordDate, temperature) values ('3', '2015-01-03', '20');
insert into Weather (id, recordDate, temperature) values ('4', '2015-01-04', '30');

select id
from (select id, temperature, recordDate,
lag(temperature) over (order by recordDate) as prev_temp,
lag(recordDate) over (order by recordDate) as prev_day
from Weather) as sub
where temperature > prev_temp and DATEDIFF(day, recordDate, prev_day) = -1