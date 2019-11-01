DECLARE @InitialPrice INT = (
	SELECT TOP 1 Price
	FROM Prices 
		INNER JOIN Dishes
			ON Dishes.ID = DishID AND 
			[Name] = 'Summer salad'
	WHERE DateFrom IS NULL
	ORDER BY DateFrom ASC)

DECLARE @FinalPrice INT = (
	SELECT TOP 1 Price
	FROM Prices 
		INNER JOIN Dishes
			ON Dishes.ID = DishID AND 
			[Name] = 'Summer salad'
	WHERE DateTo IS NULL
	ORDER BY DateFrom DESC)

DECLARE @InitalDate DATETIME = '2017-01-01'

DECLARE @FinalDate DATETIME = (
	SELECT TOP 1 DATEADD(DAY, 1, DateTo)
	FROM Prices 
		INNER JOIN Dishes
			ON Dishes.ID = DishID AND 
			[Name] = 'Summer salad'
	WHERE DateTo IS NOT NULL
	ORDER BY DateTo DESC)

;WITH PriceChanges AS (
	SELECT @InitalDate AS [Date]

	UNION

	SELECT DateFrom AS [Date]
	FROM Prices
	WHERE DateFrom IS NOT NULL 
	GROUP BY DateFrom

	UNION

	SELECT DATEADD(DAY, 1, DateTo) AS [Date]
	FROM Prices
	WHERE DateTo IS NOT NULL 
	GROUP BY DateTo

	UNION 

	SELECT @FinalDate AS [Date]
),
	IncompleteList ([DateFrom], Price) AS (
		SELECT * 
		FROM (
			SELECT @InitalDate, @InitialPrice
			UNION
			SELECT [Date], Price
			FROM (
				SELECT DateFrom, DateTo, Price, [Date]
				FROM Prices as p
					INNER JOIN Dishes as d
						ON d.ID = p.DishID AND 
						d.[Name] = 'Summer salad'
					RIGHT JOIN PriceChanges as pc
						ON pc.[Date] = p.DateFrom
				UNION
				SELECT DateFrom, DateTo, Price, [Date]
				FROM Prices as p
					INNER JOIN Dishes as d
						ON d.ID = p.DishID AND 
						d.[Name] = 'Summer salad'
					RIGHT JOIN PriceChanges as pc
						ON pc.[Date] = DATEADD(DAY, 1, p.DateTo)
			) AS Dates
			GROUP BY [Date], Price
			UNION
			SELECT @FinalDate, @FinalPrice
		) AS DateList (DateFrom, Price)
		GROUP BY [DateFrom], Price
		HAVING DateFrom IS NOT NULL
)

Select * 
from IncompleteList
--where price IS NOT NULL

Select @FinalPrice

/*

SELECT *
FROM Prices 
	INNER JOIN Dishes
		ON Dishes.ID = DishID 
--WHERE DateFrom IS NOT NULL
ORDER BY DateFrom ASC



SELECT * 
FROM Prices AS p
	INNER JOIN Dishes AS d
		ON d.ID = p.DishID AND 
		d.[Name] = 'Summer salad'
	INNER JOIN DatesWherePricesChanged AS dp1
		ON dp1.DateFrom = p.DateFrom
	INNER JOIN DatesWherePricesChanged AS dp2
		ON dp2.DateTo = p.DateTo



SELECT *, p1.DateTo, p2.DateFrom --DateFrom, Price
FROM Prices as p1
	INNER JOIN Prices as p2
		ON p2.DateFrom = DATEADD(day, 1 ,p1.DateTO)
	INNER JOIN Dishes
		ON Dishes.ID = p1.DishID AND 
		[Name] = 'Summer salad'
WHERE p1.DateFrom IS NOT NULL
ORDER BY p1.DateFrom ASC

SELECT *
FROM Prices 
	INNER JOIN Dishes
		ON Dishes.ID = DishID 
--WHERE DateFrom IS NOT NULL
ORDER BY DateFrom ASC

SELECT CONVERT(VARCHAR, '2017-01-01', 23), Price
FROM Prices 
	INNER JOIN Dishes
		ON Dishes.ID = DishID AND 
		[Name] = 'Summer salad'
WHERE DateFrom IS NULL
UNION 
SELECT DateFrom, Price
FROM Prices 
	INNER JOIN Dishes
		ON Dishes.ID = DishID AND 
		[Name] = 'Summer salad'
WHERE DateFrom IS NOT NULL
--ORDER BY DateFrom


SELECT DateFrom--, DateTo, Price
FROM Prices 
	INNER JOIN Dishes
		ON Dishes.ID = DishID AND 
		DateFrom IS NOT NULL
WHERE DateFrom IS NOT NULL
GROUP BY DateFrom
ORDER BY DateFrom

SELECT DateFrom, DateAdd(day, 1, DateTo)
FROM Prices
WHERE DateFrom IS NOT NULL 
	OR DateTo IS NOT NULL 
GROUP BY DateFrom, DateTo

*/