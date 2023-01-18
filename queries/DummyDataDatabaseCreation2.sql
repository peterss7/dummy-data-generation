USE MASTER;
GO

DROP DATABASE IF EXISTS DummyData;
GO

CREATE DATABASE DummyData;
GO

USE DummyData;
GO

CREATE TABLE Users (
	ID				INTEGER				NOT NULL IDENTITY PRIMARY KEY,
	Username		NVARCHAR(30)		NOT NULL UNIQUE,
	Password		NVARCHAR(30)		NOT NULL,
	FirstName		NVARCHAR(30)		NOT NULL,
	LastName		NVARCHAR(30)		NOT NULL,
	Phone			NVARCHAR(12)			NULL,
	Email			NVARCHAR(255)		NULL,
	IsReviewer		BIT					NOT NULL,
	IsAdmin			BIT					NOT NULL,	
	BufferColumn	NVARCHAR(1)			NULL
);

SELECT * FROM Users;

DROP TABLE Users;

TRUNCATE TABLE dbo.Users;
GO

BULK INSERT  dbo.Users
FROM 'C:\Users\peter\eclipse-workspace\dummy-data-generation\src\main\resources\prs-database-users.csv'
WITH
(
	FORMAT = 'CSV',	
	ROWTERMINATOR = '0x0a',
	--DATAFILETYPE = 'CHAR',
	FIRSTROW = 2
);
GO

CREATE TABLE Vendors
(
	Id			INTEGER			NOT NULL IDENTITY PRIMARY KEY,
	Code		VARCHAR(30)		NOT NULL UNIQUE,
	Name		VARCHAR(30)		NOT NULL,
	Address		VARCHAR(30)		NOT NULL,
	City		VARCHAR(30)		NOT NULL,
	State		VARCHAR(2)		NOT NULL,
	Zip			VARCHAR(5)		NOT NULL,
	Phone		VARCHAR(12)		NULL,
	Email		VARCHAR(255)	NULL
);

SELECT * FROM Vendors;

DROP TABLE Vendors;

TRUNCATE TABLE dbo.Vendors;
GO

BULK INSERT  dbo.Vendors
FROM 'C:\Users\peter\eclipse-workspace\dummy-data-generation\src\main\resources\prs-database-vendors.csv'
WITH
(
	FORMAT = 'CSV',	
	ROWTERMINATOR = '0x0a',
	--DATAFILETYPE = 'CHAR',
	FIRSTROW = 2
);
GO

ALTER TABLE Vendors
ALTER COLUMN Name VARCHAR(100)

ALTER TABLE Vendors
ALTER COLUMN State VARCHAR(30);

SELECT * FROM Vendors


CREATE TABLE dbo.CitiesAndStates (

	Id				INT					NOT NULL IDENTITY PRIMARY KEY,
	CityName		VARCHAR(40)			NOT NULL,
	StateName		VARCHAR(40)			NOT NULL
);

DROP TABLE dbo.CitiesAndStates;

TRUNCATE TABLE dbo.CitiesAndStates;
GO

BULK INSERT  dbo.CitiesAndStates
FROM 'C:\Users\peter\eclipse-workspace\dummy-data-generation\src\main\resources\cities-and-states-resource.csv'
WITH
(
	FORMAT = 'CSV',	
	ROWTERMINATOR = '0x0a',
	--DATAFILETYPE = 'CHAR',
	FIRSTROW = 2
);
GO

CREATE TABLE Zips (
	ID				INTEGER				NOT NULL IDENTITY PRIMARY KEY,
	ZipCode		NVARCHAR(30)		NULL,
	StateAbv	NVARCHAR(10)	NULL,
);

DROP TABLE Zips;

TRUNCATE TABLE dbo.Zips;
GO

BULK INSERT  dbo.Zips
FROM "C:\Users\peter\eclipse-workspace\dummy-data-generation\zip_code_database_short_version.csv"
WITH
(
	FORMAT = 'CSV',	
	ROWTERMINATOR = '0x0a',
	--DATAFILETYPE = 'CHAR',
	FIRSTROW = 2
);
GO