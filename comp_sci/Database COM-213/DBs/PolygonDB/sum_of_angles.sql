use Polygons;

SELECT  PolygonID, (NumberOfAngles - 2) * 180 AS SumOfAngles, NumberOfAngles
FROM (
	SELECT PolygonID, COUNT(*) AS NumberOfAngles
	FROM RightAngles
	GROUP BY PolygonID
) AS GroupedPolygons