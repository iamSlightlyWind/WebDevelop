IF EXISTS (SELECT 1 FROM sys.databases WHERE name = 'PRJ321_SU20')
BEGIN
    ALTER DATABASE [PRJ321_SU20] SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE [PRJ321_SU20];
END
GO

CREATE DATABASE [PRJ321_SU20]
GO


USE [PRJ321_SU20]
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 7/5/2020 9:57:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee](
	[id] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
	[dob] [date] NOT NULL,
	[gender] [bit] NOT NULL,
 CONSTRAINT [PK_Employee] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employee_Skill]    Script Date: 7/5/2020 9:57:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee_Skill](
	[eid] [int] NOT NULL,
	[sid] [int] NOT NULL,
 CONSTRAINT [PK_Employee_Skill] PRIMARY KEY CLUSTERED 
(
	[eid] ASC,
	[sid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Skill]    Script Date: 7/5/2020 9:57:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Skill](
	[id] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Skill] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 7/5/2020 9:57:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[id] [int] NOT NULL,
	[name] [varchar](150) NOT NULL,
	[dob] [date] NOT NULL,
	[gender] [bit] NOT NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student_Skill]    Script Date: 7/5/2020 9:57:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student_Skill](
	[suid] [int] NOT NULL,
	[skid] [int] NOT NULL,
 CONSTRAINT [PK_Student_Skill] PRIMARY KEY CLUSTERED 
(
	[suid] ASC,
	[skid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Employee] ([id], [name], [dob], [gender]) VALUES (1, N'Anna', CAST(N'1976-04-03' AS Date), 0)
INSERT [dbo].[Employee] ([id], [name], [dob], [gender]) VALUES (2, N'Michel', CAST(N'1988-11-13' AS Date), 1)
INSERT [dbo].[Employee] ([id], [name], [dob], [gender]) VALUES (3, N'Alex', CAST(N'1985-07-06' AS Date), 1)
INSERT [dbo].[Employee] ([id], [name], [dob], [gender]) VALUES (4, N'Kim', CAST(N'1986-09-22' AS Date), 0)
INSERT [dbo].[Skill] ([id], [name]) VALUES (1, N'C#')
INSERT [dbo].[Skill] ([id], [name]) VALUES (2, N'Java')
INSERT [dbo].[Skill] ([id], [name]) VALUES (3, N'Database System')
INSERT [dbo].[Skill] ([id], [name]) VALUES (4, N'Algorithm')
INSERT [dbo].[Student] ([id], [name], [dob], [gender]) VALUES (1, N'Anna', CAST(N'1976-04-03' AS Date), 0)
INSERT [dbo].[Student] ([id], [name], [dob], [gender]) VALUES (2, N'Michel', CAST(N'1988-11-13' AS Date), 1)
INSERT [dbo].[Student] ([id], [name], [dob], [gender]) VALUES (3, N'Alex', CAST(N'1985-07-06' AS Date), 1)
INSERT [dbo].[Student] ([id], [name], [dob], [gender]) VALUES (4, N'Kim', CAST(N'1986-09-22' AS Date), 0)
ALTER TABLE [dbo].[Employee_Skill]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Skill_Employee] FOREIGN KEY([eid])
REFERENCES [dbo].[Employee] ([id])
GO
ALTER TABLE [dbo].[Employee_Skill] CHECK CONSTRAINT [FK_Employee_Skill_Employee]
GO
ALTER TABLE [dbo].[Employee_Skill]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Skill_Skill] FOREIGN KEY([sid])
REFERENCES [dbo].[Skill] ([id])
GO
ALTER TABLE [dbo].[Employee_Skill] CHECK CONSTRAINT [FK_Employee_Skill_Skill]
GO
ALTER TABLE [dbo].[Student_Skill]  WITH CHECK ADD  CONSTRAINT [FK_Student_Skill_Skill] FOREIGN KEY([skid])
REFERENCES [dbo].[Skill] ([id])
GO
ALTER TABLE [dbo].[Student_Skill] CHECK CONSTRAINT [FK_Student_Skill_Skill]
GO
ALTER TABLE [dbo].[Student_Skill]  WITH CHECK ADD  CONSTRAINT [FK_Student_Skill_Student] FOREIGN KEY([suid])
REFERENCES [dbo].[Student] ([id])
GO
ALTER TABLE [dbo].[Student_Skill] CHECK CONSTRAINT [FK_Student_Skill_Student]
GO
