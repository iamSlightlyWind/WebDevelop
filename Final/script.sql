-- drop Final database
DROP DATABASE Final;

-- create Final database
CREATE DATABASE Final;

-- use database Final
USE Final;

-- create table Users (id, name, password)
CREATE TABLE Users
(
    id INT IDENTITY(1,1) PRIMARY KEY,
    name VARCHAR(25),
    password VARCHAR(25),
    active INT DEFAULT 1
);

CREATE TABLE UserDetails
(
    userID INT REFERENCES Users(id),
    firstName NVARCHAR(25),
    lastName NVARCHAR(25),
    email VARCHAR(50)
);

create table MessageGroup
(
    groupID int IDENTITY(1,1) PRIMARY KEY,
    userID int REFERENCES Users(id),
);

create table Messages
(
    groupID int REFERENCES MessageGroup(groupID),
    userID int REFERENCES Users(id),
    message NVARCHAR(100),
    time DATETIME
);



USE Final;
select *
from Users
select *
from UserDetails
select *
from MessageGroup
select *
from Messages
