CREATE DATABASE FlightsDb;
GO

USE FlightsDb;
GO

/* table as a basis for persons: pilots, cabin crew, passengers
 * referenced by: Passengers, Bookings, ContactToPersons, Pilots
 *  CabinCrew
 */
CREATE TABLE Persons (
  ID INT IDENTITY CONSTRAINT PK__Persons PRIMARY KEY CLUSTERED,
  Name NVARCHAR(255) NOT NULL,
  DateOfBirth DATETIME NOT NULL,
  PassportNumber VARCHAR(40) NOT NULL,
  Nationality INT NOT NULL,
  CONSTRAINT UK__Persons__PassportNumber__Nationality 
    UNIQUE (PassportNumber, Nationality)
);

/* table containing all pilots
 * references: Persons
 * referenced by: PilotsOnFlights, PlaneLicensesToPilots,
 *  PilotsOfAirlines
 */ 
CREATE TABLE Pilots (
  ID INT IDENTITY CONSTRAINT PK__Pilots PRIMARY KEY CLUSTERED,
  PersonId INT NOT NULL,
  CONSTRAINT FK__Pilots__Persons FOREIGN KEY (PersonId) 
    REFERENCES Persons(ID)
);

/* table containing all cabin crew members
 * references: Persons
 * referenced by: CabinCrewOnFlights, CabinCrewOfAirlines
 */
CREATE TABLE CabinCrew (
  ID INT IDENTITY CONSTRAINT PK__CabinCrew PRIMARY KEY CLUSTERED,
  PersonId INT NOT NULL
  CONSTRAINT FK__CabinCrew__Persons FOREIGN KEY (PersonId) 
    REFERENCES Persons(ID)
);

/* table containing all passengers
 * references: Persons
 * referenced by: PassengersOnFlights, Luggage
 */
CREATE TABLE Passengers (
  ID INT IDENTITY CONSTRAINT PK__Passengers PRIMARY KEY CLUSTERED,
  PersonId INT NOT NULL,
  -- for example elderly people, wheelchair-bound
  NeedsAssistance BIT NOT NULL  
  CONSTRAINT FK__Passengers__Persons FOREIGN KEY (PersonId) 
    REFERENCES Persons(ID)
);

/* table for countries 
 * referenced by: Contacts
 */
CREATE TABLE Countries (
  ID INT IDENTITY CONSTRAINT PK__Countries PRIMARY KEY CLUSTERED,
  Name VARCHAR(255) NOT NULL,
  -- for example GB for Great Britain
  CountryAbbreviation VARCHAR(20) NOT NULL
);

/* table for contact information for persons, airlines, airports
 * references: Countries
 * referenced by: ContactToAirports, ContactsToPersons, ContactsToAirlines
 */
CREATE TABLE Contacts (
  ID INT IDENTITY CONSTRAINT PK__Contacts PRIMARY KEY CLUSTERED,
  PhoneNumber VARCHAR(30) NOT NULL,
  StreetAndNumber NVARCHAR(255) NOT NULL,
  City NVARCHAR(255) NOT NULL,
  PostCode INT NOT NULL,
  StateOrRegion NVARCHAR(255) NULL,
  Country INT NOT NULL,
  CONSTRAINT FK__Contacts__Countries FOREIGN KEY (Country) 
    REFERENCES Countries(ID)
);

/* table for timezones
 * referenced by: Airports
 */
CREATE TABLE Timezones (
  ID INT IDENTITY CONSTRAINT PK__Timeszones PRIMARY KEY CLUSTERED,
  Name VARCHAR(50) NOT NULL,
  DifferenceToUTC INT NOT NULL
);

/* table of airports
 * referenced by: Terminals, ContactsToAirports, TimezonesToAirports
 */
CREATE TABLE Airports (
  ID INT IDENTITY CONSTRAINT PK__Airports PRIMARY KEY CLUSTERED,
  Name NVARCHAR(255) NOT NULL,
  -- for example FRU for Manas Airport
  AirportAbbreviation VARCHAR(10) NOT NULL,
  TimezoneId INT NOT NULL,
  CONSTRAINT FK__Airports__Timezones FOREIGN KEY (TimezoneId)
    REFERENCES Timezones(ID)
);

/* table of terminals of airports
 * references: Airports
 * referenced by: Flights (2 times)
 */
CREATE TABLE Terminals (
  Name NVARCHAR(255) NOT NULL,
  AirportId INT NOT NULL,
  CONSTRAINT PK__Terminals PRIMARY KEY (Name, AirportId),
  CONSTRAINT FK__Terminals__Airports FOREIGN KEY (AirportId) 
    REFERENCES Airports(ID)
);

/* table for the types of airlines, e.g. freight, military...
 * referenced by: Airlines
 */
CREATE TABLE AirlineTypes (
  ID INT IDENTITY CONSTRAINT PK__AirlineTypes PRIMARY KEY CLUSTERED,
  Name NVARCHAR(255) NOT NULL
);

/* table for airlines
 * refereces: AirlineTypes
 * referenced by: AirlinesToFlights, ContactsToAirlines, CabinCrewOfAirlines
 *  PilotsOfAirlines, Planes
 */
CREATE TABLE Airlines (
  ID INT IDENTITY CONSTRAINT PK__Airlines PRIMARY KEY CLUSTERED,
  Name NVARCHAR(255) NOT NULL,
  AirlineType INT NOT NULL,
  CONSTRAINT FK__Airlines__AirlineTypes FOREIGN KEY (AirlineType) 
    REFERENCES AirlineTypes(ID)
);

/* table containing types of planes, e.g. Boeing 747
 * referenced by: Planes, PlaneLicenses
 */
CREATE TABLE PlaneTypes (
  Name NVARCHAR(255) CONSTRAINT PK__PlaneTypes PRIMARY KEY CLUSTERED,
  NumberOfRowsOfSeats INT NOT NULL,
  NumberOfSeatsPerRow INT NOT NULL,
  MaximumRange INT NOT NULL,
  MaximumBaggageCapacity INT NOT NULL,
);

/* table containing the licenses required to fly the planes
 * references: PlaneTypes
 * referenced by: PlanesLicensedToPilots
 */
CREATE TABLE PlaneLicenses (
  ID INT IDENTITY CONSTRAINT PK__PlaneLicenses PRIMARY KEY CLUSTERED,
  PlaneTypeName NVARCHAR(255) NOT NULL,
  CONSTRAINT FK__PlaneLicenses__PlaneTypes FOREIGN KEY (PlaneTypeName)
    REFERENCES PlaneTypes(Name)
);

/* table containing individual planes
 * references: PlaneTypes, Airlines
 * referenced by: Flights
 */
CREATE TABLE Planes (
  ID INT IDENTITY CONSTRAINT PK__Planes PRIMARY KEY CLUSTERED,
  Callsign VARCHAR(255) NOT NULL CONSTRAINT UK__Planes__Callsign UNIQUE,
  AirlineId INT NOT NULL,
  PlaneTypeName NVARCHAR(255) NOT NULL,
  CONSTRAINT FK__Planes__PlaneTypes FOREIGN KEY (PlaneTypeName) 
    REFERENCES PlaneTypes(Name),
  CONSTRAINT FK__Planes__Airlines FOREIGN KEY (AirlineId) 
    REFERENCES Airlines(ID)
);

/* table containing each flight
 * references: Terminals, Planes
 * referenced by: Luggage, PassengersOnFlights, CabinCrewOnFlights,
 *  AirlinesToFlights, PilotsOnFlights
 */
CREATE TABLE Flights (
  ID INT IDENTITY CONSTRAINT PK__Flights PRIMARY KEY CLUSTERED,
  PlaneId INT NOT NULL,
  DepartureTerminalName NVARCHAR(255) NULL,
  DepartureAirportId INT NOT NULL,
  -- in UTC to make calculation easy
  DepartureTimeAndDate DATETIME2(7) NOT NULL,
  ArrivalTerminalName NVARCHAR(255) NULL,
  ArrivalAirportId INT NOT NULL,
  -- in UTC to make calculations easy
  ArrivalTimeAndDate DATETIME2(7) NOT NULL,
  CONSTRAINT FK__Flights__Terminals__ForDepartures 
    FOREIGN KEY (DepartureTerminalName, DepartureAirportId)
    REFERENCES Terminals(Name, AirportId),
  CONSTRAINT FK__Flights__Terminals__ForArrivals 
    FOREIGN KEY (ArrivalTerminalName, ArrivalAirportId)
    REFERENCES Terminals(Name, AirportId),
  CONSTRAINT FK__Flights__Planes FOREIGN KEY (PlaneId) 
    REFERENCES Planes(ID),
  CONSTRAINT CK__Flights__Departure__Arrival__Times CHECK (DepartureTimeAndDate < ArrivalTimeAndDate)
);

/* table for checked luggage on specific flights
 * references: Passengers, Flights
 */
CREATE TABLE Luggage (
  ID INT IDENTITY CONSTRAINT PK__Luggage PRIMARY KEY CLUSTERED,
  PassengerId INT NOT NULL,
  FlightId INT NOT NULL,
  Weight INT NOT NULL,
  CONSTRAINT FK__Luggage__Passengers FOREIGN KEY (PassengerId) 
    REFERENCES Passengers(ID),
  CONSTRAINT FK__Luggage__Flights FOREIGN KEY (FlightId) 
    REFERENCES Flights(ID)
);

/* table that contains possible payment options for the flight booking
 * referenced by: Bookings
 */
CREATE TABLE BookingPaymentTypes (
  ID INT IDENTITY CONSTRAINT PK__BookingPaymentTypes PRIMARY KEY CLUSTERED,
  Name NVARCHAR(255) NOT NULL
);

/* table storing all bookings of flights
 * references: BookingPaymentTypes, Persons
 * referenced by: PassengersOnFlights
 */
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

/* table for the possible status of passengers, e.g. first class, economy...
 * referenced by: PassengersOnFlights
 */
CREATE TABLE PassengerStatuses (
  ID INT IDENTITY CONSTRAINT PK__PassengerStatuses PRIMARY KEY CLUSTERED,
  Name NVARCHAR(255) NOT NULL,
);

/* table connecting many passengers with many flights
 * references: Bookings, PassengerStatuses, Passengers, Flights
 */
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

/* table connecting cabin crew to flights
 * references: CabinCrew, Flights
 */
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

/* table connection pilots to flights
 * references: Pilots, Flights
 */
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

/* connecting pilots to airlines
 * references: Pilots, Airlines
 */
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

/* connecting cabin crew to airlines
 * references: CabinCrew, Airlines
 */
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

/* connecting plane licenses to pilots
 * references: PlaneLicenses, Pilots
 */
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

/* connecting contact forms to persons
 * referencing: Contacts, Persons
 */
CREATE TABLE ContactsToPersons (
  ContactId INT NOT NULL, 
  PersonId INT NOT NULL,
  CONSTRAINT PK__ContactsToPersons PRIMARY KEY (ContactId, PersonId),
  CONSTRAINT FK__ContactsToPersons__Contact FOREIGN KEY (ContactId)
    REFERENCES Contacts(ID),
  CONSTRAINT FK__ContactsToPersons__Persons FOREIGN KEY (PersonId)
    REFERENCES Persons(ID)
);

/* connecting contacts to airports
 * references: Airports, Contacts
 */
CREATE TABLE ContactsToAirports (
  ContactId INT NOT NULL, 
  AirportId INT NOT NULL,
  CONSTRAINT PK__ContactsToAirports PRIMARY KEY (ContactId, AirportId),
  CONSTRAINT FK__ContactsToAirports__Contact FOREIGN KEY (ContactId)
    REFERENCES Contacts(ID),
  CONSTRAINT FK__ContactsToAirports__Airports FOREIGN KEY (AirportId)
    REFERENCES Airports(ID)
);

/* connecting contacts to Airlines
 * references: Contacts, Airlines
 */
CREATE TABLE ContactsToAirlines (
  ContactId INT NOT NULL, 
  AirlineId INT NOT NULL,
  CONSTRAINT PK__ContactsToAirlines PRIMARY KEY (ContactId, AirlineId),
  CONSTRAINT FK__ContactsToAirlines__Contact FOREIGN KEY (ContactId)
    REFERENCES Contacts(ID),
  CONSTRAINT FK__ContactsToAirlines__Airlines FOREIGN KEY (AirlineId)
    REFERENCES Airlines(ID)
);

/* connecting Airlines to Flights
 * references: Airlines, Flights
 */
CREATE TABLE AirlinesToFlights (
  ID INT IDENTITY CONSTRAINT PK__AirlinesToFlights PRIMARY KEY CLUSTERED,
  AirlineId INT NOT NULL,
  FlightId INT NOT NULL,
  CONSTRAINT FK__AirlinesToFlights__Airlines FOREIGN KEY (AirlineId)
    REFERENCES Airlines(ID),
  CONSTRAINT FK__AirlinesToFlights__Flights FOREIGN KEY (FlightId)
    REFERENCES Flights(ID)
);
