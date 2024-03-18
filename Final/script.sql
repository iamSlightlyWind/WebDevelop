USE master

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
    id INT REFERENCES Users(id),
    firstName NVARCHAR(25),
    lastName NVARCHAR(25),
    email VARCHAR(50)
);

create table FriendStatus(
    userID int REFERENCES Users(id),
    friendID int REFERENCES Users(id),
);

create table MessageGroup
(
    groupID int PRIMARY KEY,
    user1ID int REFERENCES Users(id),
    user2ID int REFERENCES Users(id)
);

create table Messages
(
    groupID int REFERENCES MessageGroup(groupID),
    senderID int REFERENCES Users(id),
    message NVARCHAR(100),
    time DATETIME
);

CREATE PROCEDURE InsertMessage
    @groupID int,
    @senderID int,
    @message nvarchar(100)
AS
BEGIN
    INSERT INTO Messages(groupID, senderID, message, time)
    VALUES (@groupID, @senderID, @message, GETDATE())
END

-- Inserting users into the Users table
INSERT INTO Users (name, password, active) VALUES
('Rachel', 'rachelr_89', 1),
('Brandon', 'bparker24', 1),
('Lauren', 'lscott_78', 1),
('Joshua', 'jmurphy56', 1),
('Megan', 'megcarter93', 1);

-- Inserting user details into the UserDetails table
INSERT INTO UserDetails (id, firstName, lastName, email) VALUES
(1, 'Rachel', 'Reed', 'rachel.reed@example.com'),
(2, 'Brandon', 'Parker', 'brandon.parker@example.com'),
(3, 'Lauren', 'Scott', 'lauren.scott@example.com'),
(4, 'Joshua', 'Murphy', 'joshua.murphy@example.com'),
(5, 'Megan', 'Carter', 'megan.carter@example.com');

