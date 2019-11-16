/* this database is about ordering and aggregating data */

USE TEST1;

--CREATE TABLE PopularityInfo (
--	[Name] NVARCHAR(255),
--	[Year] SMALLINT,
--	[NumberOfUsers] INT
--);

--DELETE FROM PopularityInfo;

--INSERT INTO PopularityInfo ([Name], [Year], [NumberOfUsers]) 
--VALUES	('C++', 2019, 123000),
--		('C#', 2019, 300000),
--		('JavaScript', 2019, 1000000),
--		('Java', 2019, 5000000),
--		('SQL', 2019, 100000)

--INSERT INTO PopularityInfo ([Name], [Year], [NumberOfUsers]) 
--SELECT [Name], 2018, CAST([NumberOfUsers] * 0.8 AS INT)
--FROM PopularityInfo

--SELECT * FROM PopularityInfo ORDER BY [Name], [Year] ASC

--SELECT [Year], COUNT(DISTINCT [Name]) AS [NumberOfLangs]
--FROM PopularityInfo
--GROUP BY [Year]

--SELECT PopularityInfo.*, Aggregate.NumberOfLangs
--FROM (
--	SELECT [Year], COUNT(DISTINCT [Name]) AS [NumberOfLangs]
--	FROM PopularityInfo
--	GROUP BY [Year]) AS Aggregate
--		INNER JOIN PopularityInfo
--			ON PopularityInfo.[Year] = Aggregate.[Year]

WITH AggregateInfo ([Year], NumberOfLangs) 
	AS (
		SELECT [Year], COUNT(DISTINCT [Name])
		FROM PopularityInfo
		GROUP BY [Year]
	),
	HighestUserNumbers ([Year], NumberOfUsers) 
	AS (
		SELECT [Year], MAX(NumberOfUsers)
		FROM PopularityInfo
		GROUP BY [Year]
	),
	MostPopularLanguage ([Year], [Name], NumberOfUsers, NumberOfLangs) 
	AS (
		SELECT 
			HighestUserNumbers.[Year], 
			PopularityInfo.[Name], 
			HighestUserNumbers.NumberOfUsers,
			NumberOfLangs
		FROM PopularityInfo
			INNER JOIN HighestUserNumbers
				ON PopularityInfo.NumberOfUsers = HighestUserNumbers.NumberOfUsers
			INNER JOIN AggregateInfo
				ON AggregateInfo.[Year] = PopularityInfo.[Year]
	),
	OverallMostPopular (MostPopularLanguage) 
	AS (
		SELECT TOP 1 PopularityInfo.[Name]
		FROM PopularityInfo
			INNER JOIN AggregateInfo
				ON AggregateInfo.[Year] = PopularityInfo.[Year]
		GROUP BY [Name]
		ORDER BY SUM(NumberOfUsers) DESC
	)

SELECT 
	ROW_NUMBER() OVER (ORDER BY PopularityInfo.[Name]) AS [Index],
	PopularityInfo.*,
	AggregateInfo.NumberOfLangs,
	OverallMostPopular.MostPopularLanguage
FROM PopularityInfo
	CROSS JOIN OverallMostPopular
	INNER JOIN AggregateInfo
		ON AggregateInfo.[Year] = PopularityInfo.[Year]