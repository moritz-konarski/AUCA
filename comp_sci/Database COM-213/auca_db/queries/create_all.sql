USE AUCA_DB;

CREATE TABLE Contacts (
  Id INT IDENTITY PRIMARY KEY,
  StudentId INT NOT NULL,
  AucaEmail VARCHAR(254) NULL,
  Email VARCHAR(254) NOT NULL,
  MobilePhone INT NOT NULL,
  HomePhone INT NULL,
  ParentPhone INT NULL,
  Address NVARCHAR(500) NOT NULL,
);

CREATE TABLE Courses (
  Id INT IDENTITY PRIMARY KEY,
  Name NVARCHAR(255) NOT NULL,
  Description NVARCHAR(500) NOT NULL,
  Credits INT NOT NULL
);

CREATE TABLE Genders (
  Id INT IDENTITY PRIMARY KEY,
  Name NVARCHAR(50) NOT NULL
);

CREATE TABLE MaritalStatuses (
  Id INT IDENTITY PRIMARY KEY,
  Name NVARCHAR(50) NOT NULL
);

CREATE TABLE Grades (
  Id INT IDENTITY PRIMARY KEY,
  Name VARCHAR(2) NOT NULL,
  Description NVARCHAR(255) NULL
);

CREATE TABLE Faculties (
  Id INT IDENTITY PRIMARY KEY,
  Name NVARCHAR(500) NOT NULL
);

CREATE TABLE Students (
  Id INT IDENTITY PRIMARY KEY,
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
  ProfilePicture VARBINARY(MAX) NULL,
  CONSTRAINT FK_MaritalStatuses_Students FOREIGN KEY (MaritalStatusId)
    REFERENCES MaritalStatuses(Id),
  CONSTRAINT FK_Genders_Students FOREIGN KEY (GenderId)
    REFERENCES Genders(Id)
);

CREATE TABLE StudentsInFaculties (
  Id INT IDENTITY PRIMARY KEY,
  StudentId INT NOT NULL,
  FacultyId INT NOT NULL,
  IsMajor BIT NOT NULL
  CONSTRAINT FK_Students_StudentsInFaculties FOREIGN KEY (StudentId)
    REFERENCES Students(Id),
  CONSTRAINT FK_Faculties_StudentsInFaculties FOREIGN KEY (FacultyId)
    REFERENCES Faculties(Id)
);

CREATE TABLE StudentCourses (
  Id INT IDENTITY PRIMARY KEY,
  StudentId INT NOT NULL,
  CourseId INT NOT NULL,
  DateRegistered DATETIME2(7) NOT NULL,
  GradeId INT NULL
  CONSTRAINT FK_Students_StudentsCourses FOREIGN KEY (StudentId)
    REFERENCES Students(Id),
  CONSTRAINT FK_Grades_StudentsCourses FOREIGN KEY (GradeId)
    REFERENCES Grades(Id),
  CONSTRAINT FK_Courses_StudentsFaculties FOREIGN KEY (CourseId)
    REFERENCES Courses(Id)
);
