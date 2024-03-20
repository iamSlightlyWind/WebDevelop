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

create table FriendStatus(
    userID int REFERENCES Users(id),
    friendID int REFERENCES Users(id),
    status int
);

CREATE TABLE UserDetails
(
    id INT REFERENCES Users(id),
    firstName NVARCHAR(25),
    lastName NVARCHAR(25),
    email VARCHAR(50)
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
('rachelr_89', 'G#fJ5s2x', 1),
('bparker24', 'T9m@Lq7z', 1),
('lscott_78', 'W3p$K@8z', 1),
('jmurphy56', 'X%tF2l9q', 1),
('megcarter93', 'H@rP6s5t', 1);

-- Inserting user details into the UserDetails table
INSERT INTO UserDetails (id, firstName, lastName, email) VALUES
(1, 'Rachel', 'Reed', 'rachel.reed@example.com'),
(2, 'Brandon', 'Parker', 'brandon.parker@example.com'),
(3, 'Lauren', 'Scott', 'lauren.scott@example.com'),
(4, 'Joshua', 'Murphy', 'joshua.murphy@example.com'),
(5, 'Megan', 'Carter', 'megan.carter@example.com');