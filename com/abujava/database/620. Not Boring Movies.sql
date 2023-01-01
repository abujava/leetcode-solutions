-- (Easy) 620. Not Boring Movies https://leetcode.com/problems/not-boring-movies/

Create table If Not Exists cinema (id int, movie varchar(255), description varchar(255), rating float);
Truncate table cinema;
insert into cinema (id, movie, description, rating) values ('1', 'War', 'great 3D', '8.9');
insert into cinema (id, movie, description, rating) values ('2', 'Science', 'fiction', '8.5');
insert into cinema (id, movie, description, rating) values ('3', 'irish', 'boring', '6.2');
insert into cinema (id, movie, description, rating) values ('4', 'Ice song', 'Fantacy', '8.6');
insert into cinema (id, movie, description, rating) values ('5', 'House card', 'Interesting', '9.1');

-- Solution
select * from cinema where id % 2 != 0 and description != 'boring' order by rating desc;

-- This question have a bug, Directly submit query if it not runs.