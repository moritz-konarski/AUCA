/*Mistakenly Vegetarian Dishes*/
/*
Find all the dishes that are marked as Vegetarian, 
but contains Turkey meat in the ingredients. 
Result set: dish names (Name). 
*/

SELECT Name
FROM Dishes
WHERE ID IN (
	SELECT 
		DishID AS ID
	FROM DishesIngredients
		INNER JOIN Ingredients
			ON DishesIngredients.IngredientID = Ingredients.ID
	WHERE Ingredients.Name = 'Turkey'
	INTERSECT
	SELECT 
		DishesTags.DishID AS ID
	FROM DishesTags
		INNER JOIN Tags
			ON DishesTags.TagID = Tags.ID
	WHERE Tags.Name = 'Vegetarian'
	)