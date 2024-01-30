-- create table Sanpham(maSP,tenSP,dongia)
create table Sanpham(
    maSP int primary key,
    tenSP nvarchar(50),
    dongia int
)

INSERT INTO Sanpham (maSP, tenSP, dongia) VALUES (1, N'Xoài', 20000);
INSERT INTO Sanpham (maSP, tenSP, dongia) VALUES (2, N'Mận', 40000);
INSERT INTO Sanpham (maSP, tenSP, dongia) VALUES (3, N'Mít', 50000);
INSERT INTO Sanpham (maSP, tenSP, dongia) VALUES (4, N'Me', 45000);
INSERT INTO Sanpham (maSP, tenSP, dongia) VALUES (5, N'Ổi', 34000);
INSERT INTO Sanpham (maSP, tenSP, dongia) VALUES (6, N'Sơ ri', 5000);
INSERT INTO Sanpham (maSP, tenSP, dongia) VALUES (7, N'Cóc', 7000);