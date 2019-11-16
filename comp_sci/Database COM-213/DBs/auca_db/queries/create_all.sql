USE AUCA_DB;

-- create courses table
CREATE TABLE Courses (
  Id INT IDENTITY CONSTRAINT PK__Courses PRIMARY KEY,
  Name NVARCHAR(255) NOT NULL,
  Description NVARCHAR(500) NOT NULL,
  Credits INT NOT NULL,
);

-- create genders table
CREATE TABLE Genders (
  Id INT IDENTITY CONSTRAINT PK__Genders PRIMARY KEY,
  Name NVARCHAR(50) NOT NULL
);

-- create marital statuses table
CREATE TABLE MaritalStatuses (
  Id INT IDENTITY CONSTRAINT PK__MaritalStatuses PRIMARY KEY,
  Name NVARCHAR(50) NOT NULL
);

-- create grades table
CREATE TABLE Grades (
  Id INT IDENTITY CONSTRAINT PK__Grades PRIMARY KEY,
  Name VARCHAR(2) NOT NULL,
  Description NVARCHAR(255) NULL
);

-- create faculties table
CREATE TABLE Faculties (
  Id INT IDENTITY CONSTRAINT PK__Faculties PRIMARY KEY,
  Name NVARCHAR(500) NOT NULL
);

-- create students table
-- link FK to marital statuses and genders tables
CREATE TABLE Students (
  Id INT IDENTITY CONSTRAINT PK__Students PRIMARY KEY,
  Name NVARCHAR(500) NOT NULL,
  GenderId INT NULL,
  MaritalStatusId INT NULL,
  BirthDate DATETIME2(7) NOT NULL,
  HasGoldMedal BIT NOT NULL,
  HasGoldCertificate BIT NOT NULL,
  Gpa NUMERIC(3, 2) NULL,
  AttemptedCredits INT NOT NULL,
  EarningCredits INT NOT NULL,
  GpaCredits INT NOT NULL,
  ProfilePicture VARBINARY(MAX) NULL,
  CONSTRAINT FK__Students__MaritalStatuses FOREIGN KEY (MaritalStatusId)
    REFERENCES MaritalStatuses(Id),
  CONSTRAINT FK__Students__Genders FOREIGN KEY (GenderId)
    REFERENCES Genders(Id)
);

-- create student contact info table
-- link FK to student table
CREATE TABLE StudentContactInfo (
  Id INT IDENTITY CONSTRAINT PK__StudentContactInfo PRIMARY KEY,
  StudentId INT NOT NULL,
  AucaEmail VARCHAR(254) NULL,
  PrimaryPhone VARCHAR(20) NOT NULL,
  CONSTRAINT FK__StudentContactInfo__Students FOREIGN KEY (StudentId)
    REFERENCES Students(Id)
);

-- create address type
CREATE TABLE AddressType (
  Id INT IDENTITY CONSTRAINT PK__AddressType PRIMARY KEY,
  Name NVARCHAR(150) NOT NULL
);

-- create address table
-- link FK to student table and address type table
CREATE TABLE Address (
  Id INT IDENTITY CONSTRAINT PK__Address PRIMARY KEY,
  StudentId INT NOT NULL,
  Street NVARCHAR(255) NOT NULL,
  HouseNumber NVARCHAR(25) NOT NULL,
  Apartment NVARCHAR(25) NULL,
  City NVARCHAR(255) NOT NULL,
  ZipCode INT NOT NULL,
  StateRegion NVARCHAR(255) NOT NULL,
  Country NVARCHAR(255) NOT NULL,
  AddressId INT NOT NULL,
  CONSTRAINT FK__Address__StudentContactInfo FOREIGN KEY (StudentId)
    REFERENCES StudentContactInfo(Id),
  CONSTRAINT FK__Address__AdressType FOREIGN KEY (AddressId)
    REFERENCES AddressType(Id)
);

-- create email type
CREATE TABLE EmailType (
  Id INT IDENTITY CONSTRAINT PK__EmailType PRIMARY KEY,
  Name NVARCHAR(150) NOT NULL
);

-- create email table, belongs to student contact info
-- link FK to student table and email type table
CREATE TABLE Email (
  Id INT IDENTITY CONSTRAINT PK__Email PRIMARY KEY,
  StudentId INT NOT NULL,
  EmailAddress NVARCHAR(254) NOT NULL,
  EmailId INT NOT NULL,
  CONSTRAINT FK__Email__StudentContactInfo FOREIGN KEY (StudentId)
    REFERENCES StudentContactInfo(Id),
  CONSTRAINT FK__Email__EmailType FOREIGN KEY (EmailId) 
    REFERENCES EmailType(Id)
);

-- create phone type table
CREATE TABLE PhoneType (
  Id INT IDENTITY CONSTRAINT PK__PhoneType PRIMARY KEY,
  Name NVARCHAR(150) NOT NULL
);

-- create phone table
-- link FK to student contact info and phone type tables
CREATE TABLE Phone (
  Id INT IDENTITY CONSTRAINT PK__Phone PRIMARY KEY,
  StudentId INT NOT NULL,
  PhoneNumber VARCHAR(20) NOT NULL,
  PhoneId INT NOT NULL,
  CONSTRAINT FK__Phone__StudentContactInfo FOREIGN KEY (StudentId)
    REFERENCES StudentContactInfo(Id),
  CONSTRAINT FK__Phone__PhoneType FOREIGN KEY (PhoneId) 
    REFERENCES PhoneType(Id)
);

-- create students in faculties table
-- link FK to students and to faculties tables
CREATE TABLE StudentsInFaculties (
  Id INT IDENTITY CONSTRAINT PK__StudentsInFaculties PRIMARY KEY,
  StudentId INT NOT NULL,
  FacultyId INT NOT NULL,
  IsMajor BIT NOT NULL,
  CONSTRAINT FK__StudentsInFaculties__Students FOREIGN KEY (StudentId)
    REFERENCES Students(Id),
  CONSTRAINT FK__StudentsInFaculties__Faculties FOREIGN KEY (FacultyId)
    REFERENCES Faculties(Id)
);

-- create student courses table
-- link FK to students, grades and courses
CREATE TABLE StudentCourses (
  Id INT IDENTITY CONSTRAINT PK__StudentCourses PRIMARY KEY,
  StudentId INT NOT NULL,
  CourseId INT NOT NULL,
  DateRegistered DATETIME2(7) NOT NULL,
  GradeId INT NULL, 
  CONSTRAINT FK__StudentsCourses__Students FOREIGN KEY (StudentId)
    REFERENCES Students(Id),
  CONSTRAINT FK__StudentsCourses__Grades FOREIGN KEY (GradeId)
    REFERENCES Grades(Id),
  CONSTRAINT FK__StudentsCourses__Courses FOREIGN KEY (CourseId)
    REFERENCES Courses(Id)
);
