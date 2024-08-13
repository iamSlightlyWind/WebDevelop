USE [master]
GO

IF EXISTS (SELECT *
FROM sys.databases
WHERE name = 'StudentDB')
	DROP DATABASE StudentDB
GO

CREATE DATABASE StudentDB
GO

use StudentDB
GO
create table Users
(
	Username varchar(20) primary key,
	Password varchar(20)
)

go
create table Account
(
	username varchar(20) primary key,
	password varchar(20),
	role int
)
go
insert into Account
values('sa', '123', 1)
insert into Account
values('admin', 'admin', 1)
insert into Account
values
	('123', '123', 2)
insert into Account
values('456', '456', 2)
go

Create Table Student
(
	RollNo varchar(10),
	Name varchar(30),
	mark float,
	PRIMARY KEY (RollNo)
)
GO
INSERT INTO Student
	(RollNo,Name,Mark)
VALUES
	('A1', 'Le Man', 5)
INSERT INTO Student
	(RollNo,Name,Mark)
VALUES
	('A2', 'Tran Dao', 9)
INSERT INTO Student
	(RollNo,Name,Mark)
VALUES
	('B1', 'Dang Xuan', 8)
INSERT INTO Student
	(RollNo,Name,Mark)
VALUES
	('B2', 'Phan Ha', 7)
INSERT INTO Student
	(RollNo,Name,Mark)
VALUES
	('B3', 'Hoang Thu', 8)
INSERT INTO Student
	(RollNo,Name,Mark)
VALUES
	('B4', 'Nguyen Dong', 7)
INSERT INTO Student
	(RollNo,Name,Mark)
VALUES
	('C2', 'Pham Thu', 7)
GO



select *
from student
GO
