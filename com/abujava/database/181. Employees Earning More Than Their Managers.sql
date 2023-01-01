-- (Easy) 181. Employees Earning More Than Their Managers https://leetcode.com/problems/employees-earning-more-than-their-managers

Create table If Not Exists Employee (id int, name varchar(255), salary int, managerId int);
Truncate table Employee;
insert into Employee (id, name, salary, managerId) values ('1', 'Joe', '70000', '3');
insert into Employee (id, name, salary, managerId) values ('2', 'Henry', '80000', '4');
insert into Employee (id, name, salary, managerId) values ('3', 'Sam', '60000', null);
insert into Employee (id, name, salary, managerId) values ('4', 'Max', '90000', null);

-- Solution
select e.name as Employee from Employee e join employee m on e.managerId = m.id and e.salary > m.salary;
