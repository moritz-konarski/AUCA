CREATE TABLE Contacts (
  Id INT PRIMARY KEY,
  StudentId INT NOT NULL,
  AucaEmail VARCHAR(254) NULL,
  Email VARCHAR(254) NOT NULL,
  MobilePhone INT NOT NULL,
  HomePhone INT NULL,
  ParentPhone INT NULL,
  Address NVARCHAR(500) NOT NULL,
);
