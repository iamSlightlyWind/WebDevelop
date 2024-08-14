USE master
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

create table Account
(
	username varchar(20) primary key,
	password varchar(20),
	role int
)
Create Table Student
(
	RollNo varchar(10),
	Name varchar(30),
	mark float,
	PRIMARY KEY (RollNo)
)

insert into Account
values
	('sa', '123', 1),
	('admin', 'admin', 1),
	('123', '123', 2),
	('456', '456', 2)
go


INSERT INTO Student
	(RollNo,Name,Mark)
VALUES
	('A1', 'Le Man', 5),
	('A2', 'Tran Dao', 9),
	('B1', 'Dang Xuan', 8),
	('B2', 'Phan Ha', 7),
	('B3', 'Hoang Thu', 8),
	('B4', 'Nguyen Dong', 7),
	('C2', 'Pham Thu', 7)
GO

create or alter procedure register
	@username varchar(20),
	@password varchar(20),
	@role int,
	@result int output
as
begin
	if not exists(select *
	from Account
	where username = @username)
	begin
		insert into Account
		values
			(@username, @password, @role)
		set @result = 1
	end
	else
	begin
		set @result = -1
	end
end
go

select * from Account
select * from Student