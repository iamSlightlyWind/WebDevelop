-- use database Final
USE Final;

-- delete all tables (list the table names then delete them)
DROP TABLE Users;

-- create table Users (id, name, password)
CREATE TABLE Users
(
    id INT IDENTITY(1,1),
    name VARCHAR(25),
    password VARCHAR(25),
    active INT DEFAULT 1
);

select *
from Users