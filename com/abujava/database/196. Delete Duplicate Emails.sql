-- Easy https://leetcode.com/problems/delete-duplicate-emails

Create table If Not Exists Person (Id int, Email varchar(255));
Truncate table Person;
insert into Person (id, email) values ('1', 'john@example.com');
insert into Person (id, email) values ('2', 'bob@example.com');
insert into Person (id, email) values ('3', 'john@example.com');

------------------------------- MS SQL Server -------------------------------
DELETE e
FROM Person AS e
    INNER JOIN Person AS d
ON e.email = d.email
WHERE d.id < e.id;
