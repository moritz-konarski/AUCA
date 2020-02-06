use Polygons;


SELECT PolygonID,
	SumOfAngles,
	NumberOfAngles,
	RatingNumber,
	DENSE_RANK() OVER (ORDER BY PreGroupingNumber DESC) AS GroupNumber
FROM (
	SELECT  PolygonID, 
		(NumberOfAngles - 2) * 180 AS SumOfAngles, 
		NumberOfAngles,
		DENSE_RANK() OVER (ORDER BY (NumberOfAngles - 2) * 180 DESC) AS RatingNumber,
		COUNT(*) OVER (PARTITION BY (NumberOfAngles - 2) * 180) AS PreGroupingNumber
	FROM (
		SELECT PolygonID, 
			COUNT(*) AS NumberOfAngles
		FROM RightAngles
		GROUP BY PolygonID
	) AS GroupedPolygons
) AS RankPolygons	
ORDER BY GroupNumber ASC, RatingNumber ASC
