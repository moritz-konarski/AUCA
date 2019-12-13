USE VendingMachineCompany;

/* table for Customers of the service */
CREATE TABLE dbo.[Customer] (
    [ID] INT IDENTITY CONSTRAINT PK_Customer PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(500) NOT NULL,
    [DateOfBirth] DATETIME NOT NULL,
    [PhoneNumber] INT NOT NULL CONSTRAINT UK__PhoneNumber UNIQUE,
    [IsPhoneNumberVerified] BIT NOT NULL,
    [SignupDate] DATETIME NOT NULL,
    [IsBlocked] BIT NOT NULL DEFAULT 0  --if the user does not pay, they get blocked
)
GO

/*table for the actual owners of the vending VendingMachines*/
CREATE TABLE dbo.[VendingMachineOwner] (
    [ID] INT IDENTITY CONSTRAINT PK__VendingMachineOwner PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(200) NOT NULL
)
GO

/*table for the makers or producers of the VendingMachines*/
CREATE TABLE dbo.[VendingMachineMaker] (
    [ID] INT IDENTITY CONSTRAINT PK__VendingMachineMaker PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(200) NOT NULL
)
GO

/*vending VendingMachine operation status codes, e. g. ok, error, offline, shutdown...*/
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

/*table for addresses of VendingMachines*/
CREATE TABLE dbo.[VendingMachineAddress] (
    [ID] INT IDENTITY CONSTRAINT PK__VendingMachineAddress PRIMARY KEY CLUSTERED,
    [CityID] INT NOT NULL,
    [StreetName] NVARCHAR(200) NOT NULL,
    [StreetNumber] INT NOT NULL,
    [GPSCoordinates] GEOGRAPHY NULL,
    [AdditionalInformation] NVARCHAR(300) NULL,
    CONSTRAINT FK__VendingMachineAddress__City FOREIGN KEY (CityID)
        REFERENCES dbo.[City](ID)
)
GO

/*table for all VendingMachines*/
CREATE TABLE dbo.[VendingMachine] ( 
    [ID] INT IDENTITY CONSTRAINT PK__VendingMachine PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(50) NOT NULL CONSTRAINT UK__Name UNIQUE,  
    [MakerID] INT NOT NULL,
    [OwnerID] INT NULL,
    [AddressID] INT NULL,
    [IdentificationCode] VARCHAR(255) NULL,      --the unique QR code
    [ProductCapacity] INT NOT NULL, CHECK (ProductCapacity <= 300 AND ProductCapacity > 0),
    [OperationStatusID] INT NULL,
    CONSTRAINT FK__VendingMachine__VendingMachineOwner FOREIGN KEY (OwnerID)
        REFERENCES dbo.[VendingMachineOwner](ID),
    CONSTRAINT FK__VendingMachine__VendingMachineMaker FOREIGN KEY (MakerID)
        REFERENCES dbo.[VendingMachineMaker](ID),
    CONSTRAINT FK__VendingMachine__OperationStatus FOREIGN KEY (OperationStatusID)
        REFERENCES dbo.[OperationStatus](ID),
    CONSTRAINT FK__VendingMachine__VendingMachineAddress FOREIGN KEY (AddressID)
        REFERENCES dbo.[VendingMachineAddress](ID)
)
GO

/*table for banks and the way the company can interact with them*/
CREATE TABLE dbo.[Bank] (
    [ID] INT IDENTITY CONSTRAINT PK__Bank PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(200) NOT NULL,
    [ConnectionString] VARCHAR(200) NULL
)
GO

/*table for payment cards of Customers*/
CREATE TABLE dbo.[CustomerPaymentCard] (
    [ID] INT IDENTITY CONSTRAINT PK_CustomerPaymentCard PRIMARY KEY CLUSTERED, 
    [BankID] INT NOT NULL,
    [CardNumber] INT NOT NULL,
    [CVC] INT NOT NULL,
    [ExpirationDate] DATETIME NOT NULL,
    CONSTRAINT FK_CustomerPaymentCard__Bank FOREIGN KEY (BankID)
        REFERENCES dbo.[Bank](ID)
)
GO

/*table for Productbrands that are available*/
CREATE TABLE dbo.[ProductBrand] (
    [ID] INT IDENTITY CONSTRAINT PK__ProductBrand PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(100) NOT NULL,
    [Description] NVARCHAR(200) NULL
)
GO

/*table for Productsuppliers of products*/
CREATE TABLE dbo.[ProductSupplier] (
    [ID] INT IDENTITY CONSTRAINT PK__ProductSupplier PRIMARY KEY CLUSTERED,
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
    [ProductBrandID] INT NOT NULL,
    [Picture] VARBINARY(MAX) NULL,
    CONSTRAINT FK__ProductType__ProductBrand FOREIGN KEY (ProductBrandID)
        REFERENCES dbo.[ProductBrand](ID)
)
GO

/*table for Customer's email*/
CREATE TABLE dbo.[CustomerEmail] (
    [ID] INT IDENTITY CONSTRAINT PK__CustomerEmail PRIMARY KEY CLUSTERED,
    [Address] VARCHAR(255) NOT NULL
)
GO

/* prices for types of products */
CREATE TABLE dbo.[ProductPriceToVendingMachine] (  
    [ID] INT IDENTITY CONSTRAINT PK__ProductPriceToVendingMachine PRIMARY KEY CLUSTERED,
    [ProductTypeID] INT NOT NULL,
    [VendingMachineID] INT NOT NULL,
    [CurrencyID] INT NOT NULL,
    [Amount] DECIMAL(5, 2) NOT NULL,
    [DateFrom] DATETIME NOT NULL,
    [DateTo] DATETIME NULL,
    CONSTRAINT FK__ProductPriceToVendingMachine__ProductType FOREIGN KEY (ProductTypeID)
        REFERENCES dbo.[ProductType](ID),
    CONSTRAINT FK__ProductPriceToVendingMachine__VendingMachine FOREIGN KEY (VendingMachineID)
        REFERENCES dbo.[VendingMachine](ID),
    CONSTRAINT FK__ProductPriceToVendingMachine__Currency FOREIGN KEY (CurrencyID)
        REFERENCES dbo.[Currency](ID),
)
GO

/* table for all the purchases made 
 * bought products are managed through purchase ID in the instances table
 * later a bonus id is added in case the customer wants to use it */
CREATE TABLE dbo.[Purchase] (
    [ID] INT IDENTITY CONSTRAINT PK__Purchase PRIMARY KEY CLUSTERED,
    [Date] DATETIME NOT NULL,
    [CustomerID] INT NOT NULL,
    [VendingMachineID] INT NOT NULL,
    [CustomerPaymentCardID] INT NOT NULL,
    CONSTRAINT FK__Purchase__Customer FOREIGN KEY (CustomerID)
        REFERENCES dbo.Customer(ID),
    CONSTRAINT FK__Purchase__VendingMachine FOREIGN KEY (VendingMachineID)
        REFERENCES dbo.[VendingMachine](ID),
    CONSTRAINT FK__Invoice__CustomerPaymentCard FOREIGN KEY (CustomerPaymentCardID)
        REFERENCES dbo.[CustomerPaymentCard](ID)
)
GO

/*table for specific instances of a product type*/
CREATE TABLE dbo.[ProductInstance] (
    [ID] INT IDENTITY CONSTRAINT PK__ProductInstance PRIMARY KEY CLUSTERED, --unique ID of the product instance
    [ProductTypeID] INT NOT NULL,
    [ProductWeight] INT NOT NULL,
    [ExpirationDate] DATETIME NOT NULL,
    [ProductSupplierID] INT NOT NULL,
    [VendingMachineID] INT NULL,
    [PurchaseID] INT NULL,
    CONSTRAINT FK__ProductInstance__ProductType FOREIGN KEY (ProductTypeID)
        REFERENCES dbo.[ProductType](ID),
    CONSTRAINT FK__ProductInstance__VendingMachine FOREIGN KEY (VendingMachineID)
        REFERENCES dbo.[VendingMachine](ID),
    CONSTRAINT FK__ProductInstance__ProductSupplier FOREIGN KEY (ProductSupplierID)
        REFERENCES dbo.[ProductSupplier](ID),
    CONSTRAINT FK__ProductInstance__Purchase FOREIGN KEY (PurchaseID)
        REFERENCES dbo.[Purchase](ID)
)
GO

/*table for the invoices, created after purchase is made*/
/*price and currency can be found from the prices to vending machines table and
 * the date of purchase*/
CREATE TABLE dbo.[Invoice] (            
    [ID] INT IDENTITY CONSTRAINT PK__Invoice PRIMARY KEY CLUSTERED,
    [PurchaseID] INT NOT NULL,
    [Amount] INT NOT NULL,
    [IsPaid] BIT NOT NULL,
    [PaymentDate] DATETIME NULL,            
    CONSTRAINT FK__Invoice__Purchase FOREIGN KEY (PurchaseID)
        REFERENCES dbo.[Purchase](ID)
)
GO

/*table connecting customers to their payment info*/
CREATE TABLE dbo.[CustomerPaymentInformation] (
    [ID] INT IDENTITY CONSTRAINT PK_CustomerPaymentInformation PRIMARY KEY CLUSTERED,
    [CustomerID] INT NOT NULL,
    [CustomerPaymentCardID] INT NOT NULL,
    CONSTRAINT FK__CustomerPaymentInformation__Customer FOREIGN KEY (CustomerID)
        REFERENCES dbo.Customer(ID),
    CONSTRAINT FK__CustomerPaymentInformation__CustomerPaymentCard FOREIGN KEY (CustomerPaymentCardID)
        REFERENCES dbo.[CustomerPaymentCard](ID)
)
GO

/*table connecting customers to their Customer emails*/
CREATE TABLE dbo.[EmailToCustomer] (
    [ID] INT IDENTITY CONSTRAINT PK__EmailToCustomer PRIMARY KEY CLUSTERED,
    [CustomerID] INT NOT NULL,
    [CustomerEmailID] INT NOT NULL,
    CONSTRAINT FK__EmailToCustomer__Customer FOREIGN KEY (CustomerID)
        REFERENCES dbo.[Customer](ID),
    CONSTRAINT FK__EmailToCustomer__CustomerEmail FOREIGN KEY (CustomerEmailID)
        REFERENCES dbo.[CustomerEmail](ID)
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

/* table for bonuses a customer might earn */
CREATE TABLE dbo.[Bonus] (
    [ID] INT IDENTITY CONSTRAINT PK__Bonus PRIMARY KEY CLUSTERED,
    [Name] NVARCHAR(50) NOT NULL,
    [Modifier] DECIMAL(3, 2) NOT NULL -- like 0.90 for a 10% discount
);
GO

/* table connecting customers to bonuses */
CREATE TABLE dbo.[BonusToCustomer] (
    [ID] INT IDENTITY CONSTRAINT PK__BonusToCustomer PRIMARY KEY CLUSTERED,
    [CustomerID] INT NOT NULL,
    [BonusID] INT NOT NULL,
    CONSTRAINT FK__BonusToCustomer__Customer FOREIGN KEY (CustomerID)
        REFERENCES dbo.[Customer](ID),
    CONSTRAINT FK__BonusToCustomer__Bonus FOREIGN KEY (BonusID)
        REFERENCES dbo.[Bonus](ID)

);
GO

-- add bonuses to purchases
ALTER TABLE dbo.[Purchase] ADD [BonusID] INT NULL;
GO

-- add foreign key to purchase to make sure there are no mistakes
ALTER TABLE dbo.[Purchase] ADD CONSTRAINT FK__Purchase__Bonus FOREIGN KEY (BonusID)
    REFERENCES dbo.[Bonus](ID);
GO
