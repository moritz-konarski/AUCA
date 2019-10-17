/*The best couple*/
/*
In search of the best recipe, the cook decided to find out which ingredients most often go together. 
You need to find such pairs of ingredients that are included in recipes together more often than others.

Output: name of the first ingredient, name of the second ingredient (Ingredient1, Ingredient2)
The first to go is the one that goes earlier alphabetically
*/

USE Restaurant;

WITH GroupedIngredients AS (
	SELECT 
		di1.IngredientID AS ID1, 
		di2.IngredientID AS ID2, 
		COUNT(*) AS Count
	FROM DishesIngredients AS DI1
		INNER JOIN DishesIngredients AS DI2
			ON DI1.DishID = DI2.DishID 
				AND DI1.ID <> DI2.ID
	GROUP BY DI1.IngredientID, DI2.IngredientID
	)

SELECT
	I1.Name AS Ingredient1, 
	I2.Name AS Ingredient2
FROM GroupedIngredients
	INNER JOIN Ingredients AS I1
		ON GroupedIngredients.ID1 = I1.ID
	INNER JOIN Ingredients AS I2
		ON GroupedIngredients.ID2 = I2.ID
-- only the most popular one
WHERE 
	Count IN (
		SELECT MAX(Count) 
		FROM GroupedIngredients
	) AND I1.Name < I2.Name
-- ignoring the most popular one
/*WHERE 
	Count IN (
		SELECT MAX(Count)-1 
		FROM GroupedIngredients
	) AND I1.Name < I2.Name*/
ORDER BY I1.Name