USE DummyData;
GO

SELECT * FROM Zips;

ALTER TABLE Zips
DROP CONSTRAINT PK__Zips__3214EC273CBD8849;

ALTER TABLE Zips
DROP COLUMN ID;

TRUNCATE TABLE Zips;
GO

BULK INSERT Zips
FROM 'C:\Users\peter\eclipse-workspace\dummy-data-generation\src\main\resources\zip-code-resource.csv'
WITH (
    FIELDTERMINATOR = ',',
    ROWTERMINATOR = '\n'
);

SELECT * FROM Zips
WHERE StateAbv IN ('OH')

CREATE TABLE StateData (

	/* Id					INT					PRIMARY KEY IDENTITY, */
	State				VARCHAR(40)			NOT NULL,
	Abbreviation		VARCHAR(8)			NOT NULL

)

DROP TABLE StateData;
GO

ALTER TABLE StateData
DROP CONSTRAINT PK_ID;


ALTER TABLE StateData
DROP COLUMN Id;

SELECT * FROM StateData
ORDER BY State;

ALTER TABLE StateData
ALTER COLUMN State VARCHAR(40);

ALTER TABLE StateData
ALTER COLUMN Abbreviation VARCHAR(10);

TRUNCATE TABLE StateData;
GO

BULK INSERT StateData
FROM 'C:\Users\peter\eclipse-workspace\dummy-data-generation\src\main\resources\states.csv'
WITH (
    FIELDTERMINATOR = ',',
    ROWTERMINATOR = '\n',
	FIRSTROW = 2

);

SELECT * FROM CitiesAndStates;

SELECT * FROM CitiesAndStates
WHERE StateName IN ('Florida')

DROP TABLE CitiesAndStates;
GO

CREATE TABLE CitiesAndStates(

	Id				INT				PRIMARY KEY IDENTITY,
	CityName		VARCHAR(50)		NOT NULL,
	StateName		VARCHAR(30)		NOT NULL
)

TRUNCATE TABLE CitiesAndStates;
GO

BULK INSERT CitiesAndStates
FROM 'C:\Users\peter\eclipse-workspace\dummy-data-generation\src\main\resources\cities-and-states-resource.csv'
WITH (
    FIELDTERMINATOR = ',',
    ROWTERMINATOR = '\n',
	FIRSTROW = 2
);

SELECT * FROM Users;

