/*Universal Ingredients*/

/*
Find ingredients that are used in both Spicy and Vegetarian dishes.
Output: ingredient name (Name)
*/

WITH
	SpicyDishIDs AS (
		SELECT DishID
		FROM DishesTags
			INNER JOIN Tags
				ON DishesTags.TagID = Tags.ID
		WHERE Name = 'Spicy'
	),
	VegetarianDishIDs AS (
		SELECT DishID
		FROM DishesTags
			INNER JOIN Tags
				ON DishesTags.TagID = Tags.ID
		WHERE Name = 'Vegetarian'
	)

SELECT Name
FROM Ingredients
WHERE ID IN (
	SELECT IngredientID
	FROM DishesIngredients AS DishIngr
		INNER JOIN SpicyDishIDs
			ON DishIngr.DishID = SpicyDishIDs.DishID
	INTERSECT
	SELECT IngredientID
	FROM DishesIngredients AS DishIngr
		INNER JOIN VegetarianDishIDs
			ON DishIngr.DishID = VegetarianDishIDs.DishID
	)
ORDER BY Name