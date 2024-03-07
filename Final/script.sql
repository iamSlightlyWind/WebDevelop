-- use database Final
USE Final;

-- delete all tables (list the table names then delete them)
DROP TABLE Users;
DROP TABLE UsersDetail;
drop table MessageGroup;
drop table Messages;

-- create table Users (id, name, password)
CREATE TABLE Users
(
    id INT IDENTITY(1,1),
    name VARCHAR(25),
    password VARCHAR(25),
    active INT DEFAULT 1
);

create table UserDetails
(
    userID int REFERENCES Users(id),
    firstName NVARCHAR(25),
    lastName NVARCHAR(25),
    email VARCHAR(50),
);

create table MessageGroup
(
    groupID int IDENTITY(1,1),
    userID int REFERENCES Users(id),
);

create table Messages
(
    groupID int REFERENCES MessageGroup(groupID),
    userID int REFERENCES Users(userID),
    message NVARCHAR(100),
    time DATETIME
);


select *
from Users
select *
from UserDetails
select *
from MessageGroup
select *
from Messages