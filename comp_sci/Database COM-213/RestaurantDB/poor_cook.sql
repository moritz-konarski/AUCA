/* A poor cook*/

/*
A chef cook in a new restaurant has two kinds of suffering. 
They are the lack of inspiration and a demanding boss who wants to renew the menu. 
So he decided to resort to desperate measures. 
He kindly asks you to find all possible combinations of any two ingredients. 
The cook will analyze the results and, hopefully, new ideas will pop up in his mind.

Result set: IngredientA (the name of IngredientA), IngredientB.
Results must be ordered firstly by the name of ingredient a, then by ingredient b.
*/

use Restaurant;

SELECT 
	IngrA.Name AS IngredientA,
	IngrB.Name AS IngredientB
FROM Ingredients AS IngrA
	CROSS JOIN Ingredients AS IngrB
WHERE IngrA.Name <> IngrB.Name
ORDER BY 
  IngrA.Name, 
  IngrB.Name