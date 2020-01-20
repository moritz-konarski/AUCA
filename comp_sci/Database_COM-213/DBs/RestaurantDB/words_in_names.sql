--Number of Words in Names of Dishes

--Find the names of dishes and the number of words in them.
--Output: name of the dish (Name), the number of words in the name (Qty).
--Output the first 25 rows, ordered by the number of words descending, 
--and then alphabetically.

USE Restaurant;

--SELECT TOP 25 
--	[Name], 
--	LEN(LTRIM(RTRIM([Name]))) - LEN(REPLACE(LTRIM(RTRIM([Name])), '[^ ]%', 'x')) + 1 AS Qty
--FROM Dishes
--ORDER BY Qty DESC, [Name] ASC

--REPLACE(Name,`[a-z]`+` `,`a`)

SELECT TOP 25
	[Name], 
	LEN(REPLACE(REPLACE(REPLACE(TRIM([Name]), ' ', '/\'), '\/', ''), '/\', ' ')) - 
		LEN(REPLACE(REPLACE(REPLACE(TRIM([Name]), ' ', '/\'), '\/', ''), '/\', '')) + 1 AS Qty
FROM Dishes
ORDER BY Qty DESC, Name


SELECT TOP 25
	[Name], 
	--LEN(REPLACE(REPLACE(REPLACE([Name], ' ', '/\'), '\/', ''), '/\', ' ')) - LEN(REPLACE(REPLACE(REPLACE([Name], ' ', '/\'), '\/', ''), '/\', '')) + 1 AS Qty
	REPLACE(LTRIM(RTRIM([Name])), ' ', '  ', '   ', ' ')

	WHILE (SELECT [Name] FROM Dishes WHERE )
FROM Dishes
--ORDER BY Qty DESC, Name


SELECT Name
FROM Dishes
WHERE LTRIM(RTRIM(Name)) LIKE '%[ ]%[^ ]%[ ]%'


SELECT TOP 25
	[Name], 
	LEN(REPLACE(REPLACE(REPLACE(TRIM([Name]), ' ', '/\'), '\/', ''), '/\', ' ')) - 
		LEN(REPLACE(REPLACE(REPLACE(TRIM([Name]), ' ', '/\'), '\/', ''), '/\', '')) + 1 AS Qty
FROM Dishes
ORDER BY Qty DESC, Name

