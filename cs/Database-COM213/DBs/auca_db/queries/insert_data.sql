use AUCA_DB;

-- create Faculties
insert into Faculties (Name) values ('Mathematics');
insert into Faculties (Name) values ('Software');
insert into Faculties (Name) values ('English');

-- create marital statuses
insert into MaritalStatuses (Name) values ('single');
insert into MaritalStatuses (Name) values ('married');
insert into MaritalStatuses (Name) values ('divorced');

-- create grades
insert into Grades (Name) values ('A');
insert into Grades (Name) values ('B');
insert into Grades (Name) values ('C');
insert into Grades (Name) values ('D');
insert into Grades (Name) values ('F');

-- create genders
insert into Genders (Name) values ('male');
insert into Genders (Name) values ('female');
insert into Genders (Name) values ('other');

-- create phone types
insert into PhoneType (Name) values ('home');
insert into PhoneType (Name) values ('mobile');
insert into PhoneType (Name) values ('other');

-- create email types
insert into EmailType (Name) values ('auca');
insert into EmailType (Name) values ('private');
insert into EmailType (Name) values ('parents');

-- create address types
insert into AddressType (Name) values ('primary');
insert into AddressType (Name) values ('current');
insert into AddressType (Name) values ('registration');

-- create courses
insert into Courses (Name, Description, Credits) 
values ('Database', 'Learn how to write SQL', 6);
insert into Courses (Name, Description, Credits) 
values ('Math', 'Integrals!', 3);
insert into Courses (Name, Description, Credits) 
values ('FYS', 'Write papers.', 6);

-- create student
insert into Students (Name, GenderId, MaritalStatusId, BirthDate, 
  HasGoldMedal, HasGoldCertificate, Gpa, AttemptedCredits, EarningCredits, GpaCredits) 
values ('Mortiz', 1, 1, '1998-11-01', 0, 0, 3.98, 45, 34, 40);

-- add contact info to student
insert into StudentContactInfo (StudentId, AucaEmail, PrimaryPhone) 
values (1, 'abc@cde.fgh', 001234567);

-- add student to faculty
insert into StudentsInFaculties (StudentId, FacultyId, IsMajor) values (1, 2, 1);

-- add phone, email and address to student
insert into Phone (StudentId, PhoneNumber, PhoneId) values (1, '049234564', 1);
insert into Email (StudentId, EmailAddress, EmailId) values (1, 'asdf@@asdfh', 2);
insert into Address (StudentId, Street, HouseNumber, Apartment, 
  City, ZipCode, StateRegion, Country, AddressId) 
values (1, 'Heine', '3a', '23', 'Berlin', '13453', 'Naryn', 'China', '2');

-- add course to student
insert into StudentCourses (StudentId, CourseId, DateRegistered) values (1, 2, '2019-08-23');

-- add grade to student's course
update StudentCourses set GradeId = 1 where StudentId = 1 and CourseId = 2;
