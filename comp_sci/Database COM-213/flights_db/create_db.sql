-- A database for an airport management situation

/* SECTION PEOPLE */
-- table for persons: pilots, cabin crew, passengers
-- 
CREATE TABLE Persons (
  ID INT IDENTITY CONSTRAINT PK__Persons PRIMARY KEY CLUSTERED,
  Name NVARCHAR(255) NOT NULL,
  DateOfBirth DATETIME NOT NULL,
  PassportNumber VARCHAR(40) NOT NULL,
  Nationality INT NOT NULL,
  CONSTRAINT UK__Persons__PassportNumber__Nationality 
    UNIQUE (PassportNumber, Nationality)
);

-- table for pilots
CREATE TABLE Pilots (
  ID INT IDENTITY CONSTRAINT PK__Pilots PRIMARY KEY CLUSTERED,
  PersonId INT NOT NULL,
  CONSTRAINT FK__Pilots__Persons FOREIGN KEY (PersonId) 
    REFERENCES Persons(ID)
);

-- table for cabin crew
CREATE TABLE CabinCrew (
  ID INT IDENTITY CONSTRAINT PK__CabinCrew PRIMARY KEY CLUSTERED,
  PersonId INT NOT NULL
  CONSTRAINT FK__CabinCrew__Persons FOREIGN KEY (PersonId) 
    REFERENCES Persons(ID)
);

-- table for passengers
CREATE TABLE Passengers (
  ID INT IDENTITY CONSTRAINT PK__Passengers PRIMARY KEY CLUSTERED,
  PersonId INT NOT NULL,
  NeedsAssistance BIT NOT NULL  -- for example elderly people, wheelchair-bound
  CONSTRAINT FK__Passengers__Persons FOREIGN KEY (PersonId) 
    REFERENCES Persons(ID)
);

/* SECTION PLACES */
-- table of countries
CREATE TABLE Countries (
  ID INT IDENTITY CONSTRAINT PK__Countries PRIMARY KEY CLUSTERED,
  Name VARCHAR(255) NOT NULL,
  CountryAbbreviation VARCHAR(20) NOT NULL    -- for example GB for Great Britain
);

-- table of contact information
CREATE TABLE Contact (
  ID INT IDENTITY CONSTRAINT PK__Contact PRIMARY KEY CLUSTERED,
  PhoneNumber VARCHAR(30) NOT NULL,
  StreetAndNumber NVARCHAR(255) NOT NULL,
  City NVARCHAR(255) NOT NULL,
  PostCode INT NOT NULL,
  StateOrRegion NVARCHAR(255) NULL,
  Country INT NOT NULL,
  CONSTRAINT FK__Contactn__Countries FOREIGN KEY (Country) 
    REFERENCES Countries(ID)
);

-- table of airports
CREATE TABLE Airports (
  ID INT IDENTITY CONSTRAINT PK__Airports PRIMARY KEY CLUSTERED,
  Name NVARCHAR(255) NOT NULL,
  AirportAbbreviation VARCHAR(10) NOT NULL,        -- like FRU for Manas Airport
);

-- table of terminals of airports
CREATE TABLE Terminals (
  Name NVARCHAR(255) NOT NULL,
  AirportId INT NOT NULL,
  CONSTRAINT PK__Terminals__Name__AirportId PRIMARY KEY (Name, AirportId),
  CONSTRAINT FK__Terminals__Airports FOREIGN KEY (AirportId) 
    REFERENCES Airports(ID),
);

/* SECTION OBJECTS */
-- table for types of airlines
CREATE TABLE AirlineTypes (
  ID INT IDENTITY CONSTRAINT PK__AirlineType PRIMARY KEY CLUSTERED,
  Name NVARCHAR(255) NOT NULL
);

-- table for airlines
CREATE TABLE Airlines (
  ID INT IDENTITY CONSTRAINT PK__Airlines PRIMARY KEY CLUSTERED,
  Name NVARCHAR(255) NOT NULL,
  AirlineType INT NOT NULL          -- e.g. cargo, civillian, military...
  CONSTRAINT FK__Airlines__AirlineTypes FOREIGN KEY (AirlineType) 
    REFERENCES AirlineTypes(ID)
);

-- table for types/models of planes
CREATE TABLE PlaneTypes (
  Name NVARCHAR(255) CONSTRAINT PK__PlaneTypes PRIMARY KEY CLUSTERED,
  NumberOfRowsOfSeats INT NOT NULL,
  NumberOfSeatsPerRow INT NOT NULL,
  MaximumRange INT NOT NULL,
  MaximumBaggageCapacity INT NOT NULL,
);

-- table for planes
CREATE TABLE Planes (
  ID INT IDENTITY CONSTRAINT PK__Planes PRIMARY KEY CLUSTERED,
  Callsign VARCHAR(255) NOT NULL CONSTRAINT UK__Planes__Callsign UNIQUE,
  AirlineId INT NOT NULL,
  PlaneTypeName NVARCHAR(255) NOT NULL,         -- e.g. Airbus A-380, Boeing 747...
  CONSTRAINT FK__Planes__PlaneTypes FOREIGN KEY (PlaneTypeName) 
    REFERENCES PlaneTypes(Name),
  CONSTRAINT FK__Planes__Airlines FOREIGN KEY (AirlineId) 
    REFERENCES Airlines(ID)
);

-- table for flights
CREATE TABLE Flights (
  ID INT IDENTITY CONSTRAINT PK__Flights PRIMARY KEY CLUSTERED,
  PlaneId INT NOT NULL,
  DepartureTerminalName NVARCHAR(255) NULL,
  DepartureAirportId INT NOT NULL,
  DepartureTimeAndDate DATETIME2(7) NOT NULL,
  ArrivalTerminalName NVARCHAR(255) NULL,
  ArrivalAirportId INT NOT NULL,
  ArrivalTimeAndDate DATETIME2(7) NOT NULL,
  CONSTRAINT FK__Flights__Terminals__ForDepartures 
    FOREIGN KEY (DepartureTerminalName, DepartureAirportId)
    REFERENCES Terminals(Name, AirportId),
  CONSTRAINT FK__Flights__Terminals__ForArrivals 
    FOREIGN KEY (ArrivalTerminalName, ArrivalAirportId)
    REFERENCES Terminals(Name, AirportId),
  CONSTRAINT FK__Flights__Planes FOREIGN KEY (PlaneId) 
    REFERENCES Planes(ID)
);

-- table for checked luggage on a flight
CREATE TABLE Luggage (
  ID INT IDENTITY CONSTRAINT PK__Luggage PRIMARY KEY CLUSTERED,
  PassengerId INT NOT NULL,
  FlightId INT NOT NULL,
  Weight INT NOT NULL,
  -- passengers on flights
  CONSTRAINT FK__Luggage__Passengers FOREIGN KEY (PassengerId) 
    REFERENCES Passengers(ID),
  CONSTRAINT FK__Luggage__Flights FOREIGN KEY (FlightId) 
    REFERENCES Flights(ID)
);

-- table for airline status/memberships, e.g. Gold Card...
CREATE TABLE RewardPrograms (
  ID INT IDENTITY CONSTRAINT PK__RewardPrograms PRIMARY KEY CLUSTERED,
  Name NVARCHAR(255) NOT NULL,
  AirlineID INT NOT NULL
);

-- table for types of payment for bookings, e.g. Credit, Cash...
CREATE TABLE BookingPaymentTypes (
  ID INT IDENTITY CONSTRAINT PK__BookingPaymentTypes PRIMARY KEY CLUSTERED,
  Name NVARCHAR(255) NOT NULL
);

-- table for types of airplane licenses that pilots need to fly them
CREATE TABLE PlaneLicenses (
  ID INT IDENTITY CONSTRAINT PK__PlaneLicenses PRIMARY KEY CLUSTERED,
  PlaneTypeName NVARCHAR(255) NOT NULL,
  CONSTRAINT FK__PlaneLicenses__PlaneTypes FOREIGN KEY (PlaneTypeName)
    REFERENCES PlaneTypes(Name)
);

/* SECTION RELATIONSHIP TABLES */
-- table for bookings by persons
CREATE TABLE Bookings (
  ID INT IDENTITY CONSTRAINT PK__Bookings PRIMARY KEY CLUSTERED,
  PersonId INT NOT NULL,
  DateOfBooking DATETIME2(7) NOT NULL,
  Price INT NOT NULL,
  PaymentTypeId INT NOT NULL,
  IsPaid BIT NOT NULL,
  CONSTRAINT FK__Bookings__Persons FOREIGN KEY (PersonId) 
    REFERENCES Persons(ID),
  CONSTRAINT FK__Bookings__BookingPaymentTypes FOREIGN KEY (PaymentTypeId) 
    REFERENCES BookingPaymentTypes(ID)
);

-- table for passenger status types, e.g. business class, first class...
CREATE TABLE PassengerStatuses (
  ID INT IDENTITY CONSTRAINT PK__PassengerStatuses PRIMARY KEY CLUSTERED,
  Name NVARCHAR(255) NOT NULL,
);

-- table for passengers on flights
CREATE TABLE PassengersOnFlights (
  PassengerId INT NOT NULL,
  FlightId INT NOT NULL,
  BookingId INT NOT NULL,
  PassengerStatusId INT NOT NULL,
  CONSTRAINT PK__PassengersOnFlights__PassengerId__FlightId 
    PRIMARY KEY (PassengerId, FlightId),
  CONSTRAINT FK__PassengersOnFlights__Flights FOREIGN KEY (FlightId) 
    REFERENCES Flights(ID),
  CONSTRAINT FK__PassengersOnFlights__Passengers FOREIGN KEY (PassengerId) 
    REFERENCES Passengers(ID),
  CONSTRAINT FK__PassengersOnFlights__Bookings FOREIGN KEY (BookingId) 
    REFERENCES Bookings(ID),
  CONSTRAINT FK__PassengersOnFlights__PassengerStatuses
    FOREIGN KEY (PassengerStatusId)
    REFERENCES PassengerStatuses(ID)
);

-- table for cabin crew on flights
CREATE TABLE CabinCrewOnFlights (
  CabinCrewId INT NOT NULL,
  FlightId INT NOT NULL,
  IsCabinChief BIT NOT NULL,
  CONSTRAINT PK__CabinCrewOnFlights__CabinCrewId__FlightId 
    PRIMARY KEY (CabinCrewId, FlightId),
  CONSTRAINT FK__CabinCrewOnFlights__CabinCrew FOREIGN KEY (CabinCrewId)
    REFERENCES CabinCrew(ID),
  CONSTRAINT FK__CabinCrewOnFlights__Flights FOREIGN KEY (FlightId)
    REFERENCES Flights(ID)
);

-- table for pilots on flights
CREATE TABLE PilotsOnFlights (
  PilotId INT NOT NULL,
  FlightId INT NOT NULL,
  IsCopilot BIT NOT NULL,
  CONSTRAINT PK__PilotsOnFlights__PilotId__FlightId 
    PRIMARY KEY (PilotId, FlightId),
  CONSTRAINT FK__PilotsOnFlights__Pilots FOREIGN KEY (PilotId)
    REFERENCES Pilots(ID),
  CONSTRAINT FK__PilotsOnFlights__Flights FOREIGN KEY (FlightId)
    REFERENCES Flights(ID)
);

-- table for pilots to airlines
CREATE TABLE PilotsOfAirlines (
  PilotId INT NOT NULL,
  AirlineId INT NOT NULL,
  DateOfHiring DATETIME2(7) NOT NULL,
  DateOfContractExpiration DATETIME2(7) NOT NULL,
  MonthlyPay INT NOT NULL,
  CONSTRAINT PK__PilotsOfAirlines__PilotId__AirlineId 
    PRIMARY KEY (PilotId, AirlineId),
  CONSTRAINT FK__PilotsOfAirlines__Pilots FOREIGN KEY (PilotId) 
    REFERENCES Pilots(ID),
  CONSTRAINT FK__PilotsOfAirlines__Airlines FOREIGN KEY (AirlineId) 
    REFERENCES Airlines(ID)
);

-- table for cabin crew to airlines
CREATE TABLE CabinCrewOfAirlines (
  CabinCrewId INT NOT NULL,
  AirlineId INT NOT NULL,
  DateOfHiring DATETIME2(7) NOT NULL,
  DateOfContractExpiration DATETIME2(7) NOT NULL,
  MonthlyPay INT NOT NULL,
  CONSTRAINT PK__CabinCrewOfAirlines__CabinCrewId__AirlineId 
    PRIMARY KEY (CabinCrewId, AirlineId),
  CONSTRAINT FK__CabinCrewOfAirlines__CabinCrew FOREIGN KEY (CabinCrewId) 
    REFERENCES CabinCrew(ID),
  CONSTRAINT FK__CabinCrewOfAirlines__Airlines FOREIGN KEY (AirlineId) 
    REFERENCES Airlines(ID)
);

-- table for plane licenses to pilots
CREATE TABLE PlaneLicensesToPilots (
  PlaneLicenseId INT NOT NULL,
  PilotId INT NOT NULL,
  CONSTRAINT PK__PlaneLicensesToPilots__PlaneLicenseId__PilotId 
    PRIMARY KEY (PlaneLicenseId, PilotId),
  CONSTRAINT FK__PlaneLicensesToPilots__PlaneLicenses FOREIGN KEY (PlaneLicenseId) 
    REFERENCES PlaneLicenses(ID),
  CONSTRAINT FK__PlaneLicensesToPilots__Pilots FOREIGN KEY (PilotId) 
    REFERENCES Pilots(ID)
);

-- table for airline loyalty programs to passengers
CREATE TABLE AirlineLoyaltyProgramsToPassengers (
  PassengerId INT NOT NULL,
  AirlineLoyaltyProgramsId INT NOT NULL,
  CONSTRAINT PK__AirlineLoyaltyProgramsToPassengers 
    PRIMARY KEY (PassengerId, AirlineLoyaltyProgramsId),
  CONSTRAINT FK__AirlineLoyaltyProgramsToPassengers__PassengerId FOREIGN KEY (PassengerId) 
    REFERENCES Passengers(ID),
  CONSTRAINT FK__AirlineLoyaltyProgramsToPassengers__AirlineLoyaltyPrograms 
    FOREIGN KEY (AirlineLoyaltyProgramsId) REFERENCES AirlineLoyaltyPrograms(ID)
);

-- table mapping contact information to persons
CREATE TABLE ContactsToPersons (
  ContactId INT NOT NULL, 
  PersonId INT NOT NULL,
  CONSTRAINT PK__ContactsToPersons PRIMARY KEY (ContactId, PersonId),
  CONSTRAINT FK__ContactsToPersons__Contact FOREIGN KEY (ContactId)
    REFERENCES Contact(ID),
  CONSTRAINT FK__ContactsToPersons__Persons FOREIGN KEY (PersonId)
    REFERENCES Persons(ID)
);

-- table mapping contact information to airports 
CREATE TABLE ContactToAirports (
  ContactId INT NOT NULL, 
  AirportId INT NOT NULL,
  CONSTRAINT PK__ContactToAirports PRIMARY KEY (ContactId, AirportId),
  CONSTRAINT FK__ContactToAirports__Contact FOREIGN KEY (ContactId)
    REFERENCES Contact(ID),
  CONSTRAINT FK__ContactToAirports__Airports FOREIGN KEY (AirportId)
    REFERENCES Airports(ID)
);

-- table mapping contact information to airlines 
CREATE TABLE ContactToAirlines (
  ContactId INT NOT NULL, 
  AirlineId INT NOT NULL,
  CONSTRAINT PK__ContactToAirlines PRIMARY KEY (ContactId, AirlineId),
  CONSTRAINT FK__ContactToAirlines__Contact FOREIGN KEY (ContactId)
    REFERENCES Contact(ID),
  CONSTRAINT FK__ContactToAirlines__Airlines FOREIGN KEY (AirlineId)
    REFERENCES Airlines(ID)
);

-- table mapping airlines to flights
CREATE TABLE AirlinesToFlights (
  ID INT IDENTITY CONSTRAINT PK__AirlinesToFlights PRIMARY KEY CLUSTERED,
  AirlineId INT NOT NULL,
  FlightId INT NOT NULL,
  CONSTRAINT FK__AirlinesToFlights__Airlines FOREIGN KEY (AirlineId)
    REFERENCES Airlines(ID),
  CONSTRAINT FK__AirlinesToFlights__Flights FOREIGN KEY (FlightId)
    REFERENCES Flights(ID)
);









