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

USE Restaurant;

SELECT ROUND(SUM(Price * DATEDIFF(day, DateFrom, DateTo)) / SUM(DATEDIFF(day, DateFrom, DateTo)), 2)
FROM Prices
		INNER JOIN Dishes
			ON prices.DishID = Dishes.ID
		WHERE Dishes.Name = 'Summer salad'