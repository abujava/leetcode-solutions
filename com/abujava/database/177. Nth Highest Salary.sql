-- https://leetcode.com/problems/nth-highest-salary/

Create table If Not Exists Employee (Id int, Salary int);
Truncate table Employee;
insert into Employee (id, salary) values ('1', '100');
insert into Employee (id, salary) values ('2', '200');
insert into Employee (id, salary) values ('3', '300');


------------------------------- Call -------------------------------
select getNthHighestSalary();

------------------------------- Solution -------------------------------
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    RETURN (
        select Salary from employee order by Salary desc offset N-1 limit 1
        );
END