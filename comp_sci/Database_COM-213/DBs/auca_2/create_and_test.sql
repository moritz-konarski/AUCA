--CREATE DATABASE	AUCA_2

USE AUCA_2

DROP TABLE [User]

/*
CREATE TABLE [User] (
	ID INT CONSTRAINT PK__User PRIMARY KEY CLUSTERED,
	[Name] NVARCHAR(255)
);
GO

DECLARE @counter INT = 0;

WHILE @counter < 1000
BEGIN 
	INSERT INTO [User] (ID, [Name])	VALUES (@counter, CAST(NEWID() AS NVARCHAR(255)));
	SET @counter += 1;
END
*/

--SELECT * FROM [User]

SET STATISTICS IO ON

SELECT * FROM [User] WHERE [Name] LIKE 'A%'

SET STATISTICS IO OFF

CREATE NONCLUSTERED INDEX IX_User_Name ON [User] ([Name])

-- class 13.12.2019

alter table [User] add Balance money not null default 0 check (Balance >= 0)

select * from [User]

select * from [User] where ID in (4, 5)

select * from [User] where [Name] like 'A%'

update [User] set Balance = -10 where id = 4



begin try
begin transaction
update [User] set Balance += 10 where id = 5
update [User] set Balance -= 10 where id = 4
commit transaction
end try
begin catch
	rollback transaction
end catch



--alter table [User] drop constraint DF__User__Balance__6FE99F9F
--alter table [User] drop column Balance