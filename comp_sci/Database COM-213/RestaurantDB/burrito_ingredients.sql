/*Burrito Ingredients*/

/*
Find all the ingredients for dish Burrito. 
Result set: ingredient’s name (Name). 
*/

SELECT 
	Name
FROM Ingredients 
WHERE ID IN (
	SELECT
		DishesIngredients.IngredientID AS ID
	FROM DishesIngredients
		INNER JOIN Dishes
			ON DishesIngredients.DishID = Dishes.ID
	WHERE Dishes.Name = 'Burrito'
	)