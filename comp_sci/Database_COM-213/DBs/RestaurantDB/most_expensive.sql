WITH MostExpensiveDishes ([Name], PricePerGram) AS (
	SELECT d.[Name],
		ROUND(1.0 * p.[Price]/d.[Weight], 2) AS PricePerGram
	FROM Dishes d
		LEFT JOIN Prices p
			ON p.DishID = d.ID
	WHERE p.DateFrom >= '2018-01-01' 
		OR p.DateFrom IS NULL
),


SELECT [Name], PricePerGram, Ingredient
FROM (
	SELECT [Name], PricePerGram
	FROM MostExpensiveDishes
	WHERE PricePerGram IN (
		SELECT MAX(PricePerGram)
		FROM MostExpensiveDishes)
) AS Sub1