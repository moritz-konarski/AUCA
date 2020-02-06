/*
CREATE DATABASE LabTest;	-- create a database
*/
USE LabTest;				-- tells the program which database to use/work with

ALTER TABLE PassengerFlightBookings DROP CONSTRAINT FK__PassengerFlightBookings__Passengers;
ALTER TABLE PassengerFlightBookings DROP CONSTRAINT FK__PassengerFlightBookings__Flights;

DROP TABLE Flights;
DROP TABLE Passengers;
DROP TABLE PassengerFlightBookings;

create table Passengers (
	Id INT IDENTITY CONSTRAINT PK__Passengers PRIMARY KEY CLUSTERED,
	Name NVARCHAR(255) NOT NULL,
	PassportImage VARBINARY(MAX) NOT NULL,

	PassportNumber VARCHAR(20) NOT NULL,
	Nationality VARCHAR(255) NOT NULL,
	DateOfBirth DATETIME NOT NULL,
);

CREATE TABLE Flights (
	Id INT IDENTITY CONSTRAINT PK__Flights PRIMARY KEY CLUSTERED,
	DepartureAirportId INT NOT NULL,
	DepartureTime DATETIME2(7) NOT NULL,
	ArrivalAirportId INT NOT NULL,
	ArrivalTime DATETIME NOT NULL
);

CREATE TABLE PassengerFlightBookings (
	FlightId INT NOT NULL,
	PassengerId INT NOT NULL,
	ReservationDate DATETIME NOT NULL,
	CONSTRAINT PK__PassengerFlightBookings__FlightId__PassengerId	-- complex key to avoid duplicate bookings
		PRIMARY KEY (FlightId, PassengerId),
	CONSTRAINT FK__PassengerFlightBookings__Passengers FOREIGN KEY (PassengerId)
		REFERENCES Passengers(Id),
	CONSTRAINT FK__PassengerFlightBookings__Flights FOREIGN KEY (FlightId)
		REFERENCES Flights(Id),
);

