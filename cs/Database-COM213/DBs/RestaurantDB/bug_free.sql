/*A bug-free restaurant management system*/
/*
A software company presented a new restaurant management system to a product owner. 
A product owner received a guaranteed maintenance service for a year in case of problems. 
After the presentation, the restaurant's employees filled the database via a convenient web interface. 
Everything seemed working fine. Alas, a thoughtful person came to the establishment 
and found out the weight of a dish sometimes not equal to the total weight of its ingredients. 
Please, help the software company find all incorrect cases to analyze and fix the bug.
Result set: DishName, DishWeight, TotalIngredientsWeight.
Results must be sorted by dish name.
*/

USE Restaurant;

SELECT 
	Dishes.Name AS DishName,
	Dishes.Weight AS DishWeight,
	SumWeight AS TotalIngredientsWeight
FROM (
	SELECT 
		Dishes.ID AS DishID, 
		SUM(DishesIngredients.Weight) AS SumWeight
	FROM DishesIngredients
		INNER JOIN Dishes
			ON DishesIngredients.DishID = Dishes.ID
	GROUP BY Dishes.ID
	) AS TotalIngredientWeight
	INNER JOIN Dishes
		ON Dishes.ID = TotalIngredientWeight.DishID
WHERE Dishes.Weight <> TotalIngredientWeight.SumWeight
ORDER BY Dishes.Name