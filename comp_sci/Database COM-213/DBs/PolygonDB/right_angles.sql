use Polygons;

WITH 
PolygonValues AS (
	SELECT 
		PolygonID,
		PointNum,
		X,
		Y
	FROM RightAngles
),
NextPolygonValues (PolygonID, PointNum, NextX, NextY) AS (
	SELECT *
	FROM PolygonValues
),
PrevPolygonValues (PolygonID, PointNum, PrevX, PrevY) AS (
	SELECT *
	FROM PolygonValues
),
FirstPoint (PolygonID, PointNum, FirstX, FirstY) AS (
	SELECT *
	FROM PolygonValues
	WHERE PointNum = 1
),
LastPoint (PolygonID, PointNum, LastX, LastY) AS (
	SELECT PolygonValues.PolygonID, 
		PolygonValues.PointNum, 
		X, 
		Y
	FROM PolygonValues
		INNER JOIN (
			SELECT PolygonID, COUNT(*) AS NumberOfPoints
			FROM RightAngles
			GROUP BY PolygonID
			) AS PointCount
		ON PolygonValues.PolygonID = PointCount.PolygonID
	WHERE PolygonValues.PointNum = PointCount.NumberOfPoints
),
PointsWithSurroundingPoints (PolygonID, PointNum, X, Y, PrevX, PrevY, NextX, NextY) AS (
	SELECT 
		pv.PolygonID,
		pv.PointNum,
		pv.X, 
		pv.Y,
		ISNULL(npv.NextX, lp.LastX),
		ISNULL(npv.NextY, lp.LastY),
		ISNULL(ppv.PrevX, fp.FirstX),
		ISNULL(ppv.PrevY, fp.FirstY)
	FROM PolygonValues pv
		LEFT JOIN NextPolygonValues npv
			ON pv.PolygonID = npv.PolygonID AND pv.PointNum = npv.PointNum + 1
		LEFT JOIN PrevPolygonValues ppv
			ON pv.PolygonID = ppv.PolygonID AND pv.PointNum = ppv.PointNum - 1
		INNER JOIN FirstPoint fp
			ON pv.PolygonID = fp.PolygonID
		INNER JOIN LastPoint lp
			ON pv.PolygonID = lp.PolygonID
)

SELECT DISTINCT RightAngles.PolygonID,
	ISNULL(RightAnglesCount, 0) AS RightAnglesCount
FROM RightAngles
	LEFT JOIN (
		SELECT DISTINCT PolygonID,
			COUNT(*) OVER (PARTITION BY PolygonID ORDER BY PolygonID) AS RightAnglesCount
		FROM PointsWithSurroundingPoints
		WHERE (Y - NextY) * (Y - PrevY) = -1 * (X - NextX) * (X - PrevX)
		) AS AngleCount
	ON RightAngles.PolygonID = AngleCount.PolygonID