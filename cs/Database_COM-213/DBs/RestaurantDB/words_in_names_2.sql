GO
CREATE FUNCTION dbo.NormalizeString(@String NVARCHAR(max)) 
	RETURNS NVARCHAR(max) AS
		BEGIN
			DECLARE @index INT = 0
			SET @String = TRIM(@String)
			WHILE (@String LIKE '%  %')
			BEGIN
				SET @index = CHARINDEX('  ', @String)
				SET @String = STUFF(@String, @index, 2, ' ')
			END
		RETURN @String
END;

GO
CREATE FUNCTION dbo.CountWords(@String NVARCHAR(max)) 
	RETURNS INT AS
		BEGIN
		DECLARE @index INT = 0
		SET @String = dbo.NormalizeString(@String)
		DECLARE @NewString NVARCHAR(MAX) = @String
		WHILE (@String LIKE '% %')
			BEGIN
				SET @index = CHARINDEX(' ', @NewString)
				SET @NewString = STUFF(@NewString, @index, 1, '')
			END

		RETURN LEN(@String) - LEN(@NewString) + 1
END;
GO 

CREATE FUNCTION dbo.CountChars(@String NVARCHAR(max)) 
	RETURNS INT AS
		BEGIN
		SET @String = dbo.NormalizeString(@String)
		SET @String = REPLACE(@String, ' ', '')
		RETURN LEN(@String)
END;
GO 

declare @test nvarchar(max) = '    hell lasdlflasdf    sdf       '
select dbo.NormalizeString(@test)
select dbo.CountWords(@test)

SELECT TOP 20
	[Name] AS Name, 
	dbo.NormalizeString([Name]) AS NormalName,
	dbo.CountWords([Name]) as Qty,
	dbo.CountChars([Name]) as Ln
FROM Dishes
ORDER BY Ln DESC, [Name]
GO

SELECT TOP 25
	[Name], 
	LEN(REPLACE(REPLACE(REPLACE(TRIM([Name]), ' ', '/\'), '\/', ''), '/\', ' ')) - 
		LEN(REPLACE(REPLACE(REPLACE(TRIM([Name]), ' ', '/\'), '\/', ''), '/\', '')) + 1 AS Qty
FROM Dishes
ORDER BY Qty DESC, Name
