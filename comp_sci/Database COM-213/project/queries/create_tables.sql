USE VendingMachineCompany;

/* table for users of the service */
CREATE TABLE dbo.[User] (
    [ID] INT IDENTITY CONSTRAINT PK__User PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(500) NOT NULL,
    [DateOfBirth] DATETIME NOT NULL,
    [PhoneNumber] INT NOT NULL,     --TODO: make unique
    [IsPhoneNumberVerified] BIT NOT NULL,
    [SignupDate] DATETIME NOT NULL
)
GO

/*table for the actual owners of the vending machines*/
CREATE TABLE dbo.[MachineOwner] (
    [ID] INT IDENTITY CONSTRAINT PK__MachineOwner PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(200) NOT NULL
)
GO

/*table for the makers or producers of the machines*/
CREATE TABLE dbo.[MachineMaker] (
    [ID] INT IDENTITY CONSTRAINT PK__MachineMaker PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(200) NOT NULL
)
GO

/*vending machine operation status codes, e. g. ok, error, offline, shutdown...*/
CREATE TABLE dbo.[OperationStatus] (
    [ID] INT IDENTITY CONSTRAINT PK__OperationStatus PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(200) NOT NULL
)
GO

/*possible currencies that prices can be in*/
CREATE TABLE dbo.[Currency] (
    [ID] INT IDENTITY CONSTRAINT PK__Currency PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(100) NOT NULL,
    [Symbol] NVARCHAR(5) NOT NULL   -- like USD or $, KGS ...
)
GO

/*table of countries*/
CREATE TABLE dbo.[Country] (
    [ID] INT IDENTITY CONSTRAINT PK__Country PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(200) NOT NULL
)
GO

/*table of cities*/
CREATE TABLE dbo.[City] (
    [ID] INT IDENTITY CONSTRAINT PK__City PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(200) NOT NULL,
    [CountryID] INT NOT NULL,
    [Postcode] INT NOT NULL,
    CONSTRAINT UK__City__Country_Postcode UNIQUE (CountryID, Postcode), 
    CONSTRAINT FK__City__Country FOREIGN KEY (CountryID)
        REFERENCES dbo.[Country](ID)
)
GO

/*table for addresses of machines*/
CREATE TABLE dbo.[MachineAddress] (
    [ID] INT IDENTITY CONSTRAINT PK__MachineAddress PRIMARY KEY CLUSTERED,
    [CityID] INT NOT NULL,
    [Street] NVARCHAR(200) NOT NULL,
    [Number] INT NOT NULL,
    [GPSCoordinates] VARCHAR(200) NULL,
    [AdditionalInformation] NVARCHAR(300) NULL,
    CONSTRAINT FK__MachineAddress__City FOREIGN KEY (CityID)
        REFERENCES dbo.[City](ID)
)
GO

/*table for all machines*/
CREATE TABLE dbo.[Machine] (
    [ID] INT IDENTITY CONSTRAINT PK__Machine PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(50) NOT NULL,  --TODO: make the name unique
    [MakerID] INT NOT NULL,
    [OwnerID] INT NULL,
    [CurrencyID] INT NULL,
    [AddressID] INT NULL,
    [IdentificationCode] VARCHAR(255) NULL,      --the unique QR code
    [ProductCapacity] INT NOT NULL,     --TODO: MAX IS 300  maybe better stored as machine type in another table
    [OperationStatusID] INT NULL,
    CONSTRAINT FK__Machine__MachineOwner FOREIGN KEY (OwnerID)
        REFERENCES dbo.[MachineOwner](ID),
    CONSTRAINT FK__Machine__MachineMaker FOREIGN KEY (MakerID)
        REFERENCES dbo.[MachineMaker](ID),
    CONSTRAINT FK__Machine__OperationStatus FOREIGN KEY (OperationStatusID)
        REFERENCES dbo.[OperationStatus](ID),
    CONSTRAINT FK__Machine__Currency FOREIGN KEY (CurrencyID)
        REFERENCES dbo.[Currency](ID),
    CONSTRAINT FK__Machine__MachineAddress FOREIGN KEY (AddressID)
        REFERENCES dbo.[MachineAddress](ID)
)
GO

/*table for banks and the way the company can interact with them*/
CREATE TABLE dbo.[Bank] (
    [ID] INT IDENTITY CONSTRAINT PK__Bank PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(200) NOT NULL,
    [ConnectionString] VARCHAR(200) NULL
)
GO

/*table for payment cards of users*/
CREATE TABLE dbo.[PaymentCard] (
    [ID] INT IDENTITY CONSTRAINT PK__PaymentCard PRIMARY KEY CLUSTERED, 
    [BankID] INT NOT NULL,
    [CardNumber] INT NOT NULL,
    [CVC] INT NOT NULL,
    [ExpirationDate] DATETIME NOT NULL,
    CONSTRAINT FK__PaymentCard__Bank FOREIGN KEY (BankID)
        REFERENCES dbo.[Bank](ID)
)
GO

/*table for brands that are available*/
CREATE TABLE dbo.[Brand] (
    [ID] INT IDENTITY CONSTRAINT PK__Brand PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(100) NOT NULL,
    [Description] NVARCHAR(200) NULL
)
GO

/*table for suppliers of products*/
CREATE TABLE dbo.[Supplier] (
    [ID] INT IDENTITY CONSTRAINT PK__Supplier PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(100) NOT NULL,
    [Description] NVARCHAR(200) NULL
)
GO

/*table for product categories like sandwich, soft drink*/
CREATE TABLE dbo.[ProductCategory] (
    [ID] INT IDENTITY CONSTRAINT PK__ProductCategory PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(50) NOT NULL
)
GO

/*table for product types like Coca Cola, Snickers; child of ProductCategory*/
CREATE TABLE dbo.[ProductType] (
    [ID] INT IDENTITY CONSTRAINT PK__ProductType PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(50) NOT NULL,
    [Description] NVARCHAR(200) NULL,
    [BrandID] INT NOT NULL,
    [Picture] VARBINARY(MAX) NULL,
    CONSTRAINT FK__ProductType__Brand FOREIGN KEY (BrandID)
        REFERENCES dbo.[Brand](ID)
)
GO

/*table for user's email*/
CREATE TABLE dbo.[Email] (
    [ID] INT IDENTITY CONSTRAINT PK__Email PRIMARY KEY CLUSTERED,
    [Address] VARCHAR(255) NOT NULL
)
GO

/*prices for types of products -- ALL PRICES ARE STORED IN A SINGLE CURRENCY AND THEN CONVERTED 
 TO THE CORRECT CURRENCY DEPENDING ON LOCATION AND EXCHANGE RATE*/
CREATE TABLE dbo.[Prices] (
    [ID] INT IDENTITY CONSTRAINT PK__Prices PRIMARY KEY CLUSTERED,
    [ProductTypeID] INT NOT NULL,
    [MachineID] INT NOT NULL,
    [Amount] INT NOT NULL,
    [DateFrom] DATETIME NOT NULL,
    [DateTo] DATETIME NULL,
    CONSTRAINT FK__Prices__ProductType FOREIGN KEY (ProductTypeID)
        REFERENCES dbo.[ProductType](ID),
    CONSTRAINT FK__Prices__Machine FOREIGN KEY (MachineID)
        REFERENCES dbo.[Machine](ID)
)
GO

/*table for all the pruchases made*/
CREATE TABLE dbo.[Purchase] (
    [ID] INT IDENTITY CONSTRAINT PK__Purchase PRIMARY KEY CLUSTERED,
    [UserID] INT NOT NULL,
    [MachineID] INT NOT NULL,
    [Date] DATETIME NOT NULL,
    CONSTRAINT FK__Purchase__User FOREIGN KEY (UserID)
        REFERENCES dbo.[User](ID),
    CONSTRAINT FK__Purchase__Machine FOREIGN KEY (MachineID)
        REFERENCES dbo.[Machine](ID)
)
GO

/*table for specific instances of a product type*/
CREATE TABLE dbo.[ProductInstance] (
    [ID] INT IDENTITY CONSTRAINT PK__ProductInstance PRIMARY KEY CLUSTERED,
    [ProductTypeID] INT NOT NULL,
    [ExpirationDate] DATETIME NOT NULL,
    [SupplierID] INT NOT NULL,
    [MachineID] INT NULL,
    [PurchaseID] INT NULL,
    CONSTRAINT FK__ProductInstance__ProductType FOREIGN KEY (ProductTypeID)
        REFERENCES dbo.[ProductType](ID),
    CONSTRAINT FK__ProductInstance__Machine FOREIGN KEY (MachineID)
        REFERENCES dbo.[Machine](ID),
    CONSTRAINT FK__ProductInstance__Supplier FOREIGN KEY (SupplierID)
        REFERENCES dbo.[Supplier](ID),
    CONSTRAINT FK__ProductInstance__Purchase FOREIGN KEY (PurchaseID)
        REFERENCES dbo.[Purchase](ID)
)
GO

/*table for the invoices, created after purchase is made*/
CREATE TABLE dbo.[Invoice] (
    [ID] INT IDENTITY CONSTRAINT PK__Invoice PRIMARY KEY CLUSTERED,
    [PurchaseID] INT NOT NULL,
    [Amount] INT NOT NULL,
    [IsPaid] BIT NOT NULL,
    [PaymentDate] DATETIME NULL,
    [PaymentCardID] INT NOT NULL,
    CONSTRAINT FK__Invoice__Purchase FOREIGN KEY (PurchaseID)
        REFERENCES dbo.[Purchase](ID),
    CONSTRAINT FK__Invoice__PaymentCard FOREIGN KEY (PaymentCardID)
        REFERENCES dbo.[PaymentCard](ID)
)
GO

/*table connecting customers to their payment info*/
CREATE TABLE dbo.[UserPaymentInformation] (
    [ID] INT IDENTITY CONSTRAINT PK__UserPaymentInformation PRIMARY KEY CLUSTERED,
    [UserID] INT NOT NULL,
    [PaymentCardID] INT NOT NULL,
    CONSTRAINT FK__UserPaymentInformation__User FOREIGN KEY (UserID)
        REFERENCES dbo.[User](ID),
    CONSTRAINT FK__UserPaymentInformation__PaymentCard FOREIGN KEY (PaymentCardID)
        REFERENCES dbo.[PaymentCard](ID)
)
GO

/*table connecting customers to their emails*/
CREATE TABLE dbo.[UserEmail] (
    [ID] INT IDENTITY CONSTRAINT PK__UserEmail PRIMARY KEY CLUSTERED,
    [UserID] INT NOT NULL,
    [EmailID] INT NOT NULL,
    CONSTRAINT FK__UserEmail__User FOREIGN KEY (UserID)
        REFERENCES dbo.[User](ID),
    CONSTRAINT FK__UserEmail__Email FOREIGN KEY (EmailID)
        REFERENCES dbo.[Email](ID)
)
GO

/*table connecting product categories with product types*/
CREATE TABLE dbo.[ProductCategoryToType] (
    [ID] INT IDENTITY CONSTRAINT PK__ProductCategoryToType PRIMARY KEY CLUSTERED,
    [ProductCategoryID] INT NOT NULL,
    [ProductTypeID] INT NOT NULL,
    CONSTRAINT FK__ProductCategoryToType__ProductCategory FOREIGN KEY (ProductCategoryID)
        REFERENCES dbo.[ProductCategory](ID),
    CONSTRAINT FK__ProductCategoryToType__ProductType FOREIGN KEY (ProductTypeID)
        REFERENCES dbo.[ProductType](ID)
)
GO

/*TODO: table for bonuses a user might earn and table distributing them to users*/