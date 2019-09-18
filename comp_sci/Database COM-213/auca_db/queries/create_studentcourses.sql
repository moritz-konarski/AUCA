CREATE TABLE StudentCourses (
  Id INT PRIMARY KEY,
  StudentId INT NOT NULL,
  CourseId INT NOT NULL,
  DateRegistered DATETIME2(7) NOT NULL,
  GradeId INT NULL
);
