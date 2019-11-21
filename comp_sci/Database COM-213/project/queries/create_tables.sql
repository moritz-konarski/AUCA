USE VendingMachineCompany;

CREATE TABLE dbo.[User] (
    [ID] INT IDENTITY CONSTRAINT PK__User PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(500) NOT NULL,
    [DateOfBirth] DATETIME NOT NULL,
    [PhoneNumber] INT NOT NULL,
    [IsPhoneNumberVerified] BIT NOT NULL
)
GO

CREATE TABLE dbo.[Machine] (
    [ID] INT IDENTITY CONSTRAINT PK__Machine PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(50) NOT NULL,
    [ProducerID] INT NOT NULL,
    [OwnerID] INT NOT NULL,
    [IdentificationCode] INT NULL, -- the unique QR code
    [ProductCapacity] INT NOT NULL,
    [OperationStatus] NVARCHAR(200) NULL
)
GO

CREATE TABLE dbo.[Bank] (
    [ID] INT IDENTITY CONSTRAINT PK__Bank PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR()
)