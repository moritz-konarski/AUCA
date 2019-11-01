USE Restaurant;
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
			ON Dishes.ID = DishID
	WHERE DateTo IS NOT NULL
	ORDER BY DateTo DESC)

;WITH PriceChanges AS (
	SELECT @InitalDate AS [DateFrom],
		@InitalDate AS [ActualDate]
	UNION
	SELECT DateFrom AS [DateFrom],
		 DateFrom AS [ActualDate]
	FROM Prices
	WHERE DateFrom IS NOT NULL 
	GROUP BY DateFrom
	UNION
	SELECT DATEADD(DAY, 1, DateTo) AS [DateFrom],
		DateTo AS [ActualDate]
	FROM Prices
	WHERE DateTo IS NOT NULL 
	GROUP BY DateTo
	UNION 
	SELECT @FinalDate AS [DateFrom],
		@FinalDate AS [ActualDate]
),
AddPricesToDates (DateFrom, ActualDate, Price) AS (
	SELECT @InitalDate, @InitalDate, @InitialPrice
	UNION
	SELECT DateFrom, ActualDate, Price
	FROM (
		SELECT pc.DateFrom, pc.ActualDate, Price
		FROM Prices as p
			INNER JOIN Dishes as d
				ON d.ID = p.DishID AND 
				d.[Name] = 'Summer salad'
			RIGHT JOIN PriceChanges as pc
				ON pc.[DateFrom] = p.DateFrom OR pc.ActualDate = p.DateTo
	) AS Dates
	UNION
	SELECT @FinalDate, @FinalDate, @FinalPrice
), 
RemoveDuplicateDates (DateFrom, ActualDate, Price) AS (
	SELECT DateFrom, ActualDate, Price
	FROM (
		SELECT *, 
			DENSE_RANK() OVER (PARTITION BY DateFrom ORDER BY ActualDate DESC, Price DESC) AS [Count]
		FROM AddPricesToDates 
	) AS RankedDates
	WHERE [Count] = 1
),

PricesWithLag1 ([DateFrom], ActualDate, Price) AS (
	SELECT DateFrom, ActualDate, LAG(Price, 1) OVER (ORDER BY ActualDate)
	FROM RemoveDuplicateDates
)

Select DateFrom, Price
from (
	Select DateFrom, ActualDate, Price
	from RemoveDuplicateDates
	where price IS NOT NULL
	UNION
	Select rd.datefrom, rd.ActualDate, pl.Price as Price
	from RemoveDuplicateDates rd
		left join PricesWithLag1 pl
			ON rd.ActualDate = pl.ActualDate AND rd.Price IS NULL
	where pl.Price IS NOT NULL
) as NoNulls
