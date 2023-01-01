-- (Easy) 182. Duplicate Emails https://leetcode.com/problems/duplicate-emails

Create table If Not Exists Person (id int, email varchar(255));
Truncate table Person;
insert into Person (id, email) values ('1', 'a@b.com');
insert into Person (id, email) values ('2', 'c@d.com');
insert into Person (id, email) values ('3', 'a@b.com');

-- Solution
select email as Email from Person group by email having count(*) > 1;