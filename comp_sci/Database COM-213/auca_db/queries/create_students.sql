CREATE TABLE Students (
  Id INT PRIMARY KEY,
  Name NVARCHAR(500) NOT NULL,
  GenderId INT NULL,
  MaritalStatusId INT NULL,
  BirthDate DATETIME2(7) NOT NULL,
  HasGoldMedal BIT NOT NULL,
  HasGoldCertificate BIT NOT NULL,
  Gpa NUMERIC(2, 2) NULL,
  AttemptedCredits INT NOT NULL,
  EarningCredits INT NOT NULL,
  GpaCredits INT NOT NULL,
  ProfilePicture VARBINARY(MAX) NULL
);
