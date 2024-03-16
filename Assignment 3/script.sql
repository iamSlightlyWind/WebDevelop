use master

drop database PT2

create database PT2

use PT2

CREATE TABLE Author (
    AuthorID INT PRIMARY KEY,
    AuthorName VARCHAR(150)
);

CREATE TABLE Paper (
    PaperID INT PRIMARY KEY,
    Title VARCHAR(150),
    PublicationDate DATE
);

CREATE TABLE Author_Paper (
    PaperID INT,
    AuthorID INT,
    FOREIGN KEY (PaperID) REFERENCES Paper(PaperID),
    FOREIGN KEY (AuthorID) REFERENCES Author(AuthorID)
);

INSERT INTO Author (AuthorID, AuthorName) VALUES
(1, 'John Smith'),
(2, 'Emily Johnson'),
(3, 'Michael Brown'),
(4, 'Sophia Martinez'),
(5, 'Emma Wilson'),
(6, 'Daniel Thompson'),
(7, 'Olivia Garcia'),
(8, 'James Rodriguez');

INSERT INTO Paper (PaperID, Title, PublicationDate) VALUES
(1001, 'AI Introduction', '2023-01-15'),
(1002, 'Quantum Computing', '2023-02-20'),
(1003, 'Renewable Energy', '2023-03-10'),
(1004, 'Neural Networks', '2023-04-05'),
(1005, 'Space Exploration', '2023-05-12'),
(1006, 'Healthcare ML', '2023-06-18'),
(1007, 'Blockchain Overview', '2023-07-25'),
(1008, 'Climate Mitigation', '2023-08-09'),
(1009, 'Big Data Analytics', '2023-09-14'),
(1010, 'Industry 4.0 Robotics', '2023-10-22'),
(1011, 'AI Ethics', '2023-11-30');

INSERT INTO Author_Paper (PaperID, AuthorID) VALUES
(1001, 1),
(1002, 2),
(1002, 3),
(1003, 4),
(1001, 2),
(1004, 1),
(1004, 3),
(1005, 5),
(1005, 7),
(1006, 6),
(1006, 8),
(1007, 7),
(1008, 5),
(1008, 8),
(1009, 6),
(1010, 6),
(1011, 5),
(1011, 7);

select * from Author
select * from Paper
select * from Author_Paper