use Polygons;

SELECT  PolygonID, 
	(NumberOfAngles - 2) * 180 AS SumOfAngles, 
	NumberOfAngles,
	DENSE_RANK() OVER (ORDER BY (NumberOfAngles - 2) * 180 DESC) AS RatingNumber
FROM (
	SELECT PolygonID, 
		COUNT(*) AS NumberOfAngles
	FROM RightAngles
	GROUP BY PolygonID
) AS GroupedPolygons
ORDER BY PolygonID ASC
