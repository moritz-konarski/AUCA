/*The best couple*/
/*
In search of the best recipe, the cook decided to find out which ingredients most often go together. 
You need to find such pairs of ingredients that are included in recipes together more often than others.

Output: name of the first ingredient, name of the second ingredient (Ingredient1, Ingredient2)
The first to go is the one that goes earlier alphabetically
*/

USE Restaurant;

WITH RemoveDoubleIngredients AS (
	SELECT 
		DI1.DishID as DishID, 
		DI1.IngredientID AS IId1, 
		DI2.IngredientID AS IId2
	FROM DishesIngredients AS DI1
		INNER JOIN DishesIngredients AS DI2
			ON DI1.DishID = DI2.DishID 
				AND DI1.ID <> DI2.ID
	GROUP BY di1.DishID, di1.IngredientID, di2.IngredientID
	HAVING Count(*) = 1 OR Count(*) > 1 AND DI1.IngredientID < DI2.IngredientID
	),
	GroupedIngredients AS (
	SELECT 
		rdi.IId1 AS ID1, 
		rdi.IId2 AS ID2, 
		COUNT(*) AS Count
	FROM RemoveDoubleIngredients AS rdi
	GROUP BY rdi.IId1, rdi.IId2
	)

SELECT
	I1.Name AS Ingredient1, 
	I2.Name AS Ingredient2
FROM GroupedIngredients
	INNER JOIN Ingredients AS I1
		ON GroupedIngredients.ID1 = I1.ID
	INNER JOIN Ingredients AS I2
		ON GroupedIngredients.ID2 = I2.ID
--only the most popular one
WHERE 
	Count IN (
		SELECT MAX(Count) - 1
		FROM GroupedIngredients
	) AND I1.Name < I2.Name
ORDER BY I1.Name