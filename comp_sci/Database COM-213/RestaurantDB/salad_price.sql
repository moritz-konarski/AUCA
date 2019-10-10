/*Weighted Average Summer Salad Price*/

/*
In the season 2018-2019, the restaurant sets different prices for 
summer salad (Summer salad): 
from May to October - the summer season, 
from November to April - winter.
Calculate the weighted average price for this period. The formula:
P = (price_day_1 + price_day_2 + ... price_day_n) / n_of_days.

Output: a single number, rounded to two decimal places.
*/

WITH 
	SaladData AS (
		SELECT 
			DateFrom, 
			DateTo, 
			Price
		FROM Prices
			INNER JOIN Dishes
				ON prices.DishID = Dishes.ID
		WHERE Dishes.Name = 'Summer salad'
	)

SELECT ROUND(SUM(SumPrice) / SUM(NumberOfDays), 2)
FROM (
	SELECT -- Summer
		DATEDIFF(day, DateFrom, DateTo) AS NumberOfDays,
		Price * DATEDIFF(day, DateFrom, DateTo) AS SumPrice
	FROM SaladData
	WHERE DATEPART(mm, DateFrom) = 05 --May
	UNION
	SELECT -- Winter
		DATEDIFF(day, DateFrom, DateTo) AS NumberOfDays,
		Price * DATEDIFF(day, DateFrom, DateTo) AS SumPrice
	FROM SaladData
	WHERE DATEPART(mm, DateFrom) = 11 --November
	) as PriceData