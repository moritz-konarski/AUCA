use Polygons;

WITH 
InitialTable AS (
SELECT PolygonID, 
		PointNum, 
		X, 
		Y, 
		ISNULL(PrevX, LAST_VALUE(X) OVER (PARTITION BY PolygonID ORDER BY PointNum ASC)) AS PrevX,
		ISNULL(PrevY, LAST_VALUE(Y) OVER (PARTITION BY PolygonID ORDER BY PointNum ASC)) AS PrevY,
		--NextX,
		--NextY,
		ISNULL(PrevX, LAST_VALUE(X) OVER (PARTITION BY PolygonID ORDER BY PointNum ASC)) AS PrevX,
		ISNULL(PrevY, LAST_VALUE(Y) OVER (PARTITION BY PolygonID ORDER BY PointNum ASC)) AS PrevY,
		--PrevY--,
		FIRST_VALUE(X) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS FirstX,
		FIRST_VALUE(Y) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS FirstY,
		LAST_VALUE(X) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS LastX,
		LAST_VALUE(Y) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS LastY
FROM (
	SELECT PolygonID, 
		PointNum, 
		X, 
		Y, 
		LEAD(X, 1) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS NextX,
		LEAD(Y, 1) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS NextY,
		LAG(X, 1) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS PrevX,
		LAG(Y, 1) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS PrevY,
		FIRST_VALUE(X) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS FirstX,
		FIRST_VALUE(Y) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS FirstY,
		LAST_VALUE(X) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS LastX,
		LAST_VALUE(Y) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS LastY
	FROM RightAngles
	) AS T
),
InitialTable2 AS (
	SELECT PolygonID, 
		PointNum, 
		LEAD(X, 1) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS NextX,
		LEAD(Y, 1) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS NextY
	FROM RightAngles
),
InitialTable3 AS (
	SELECT PolygonID, 
		PointNum, 
		LAG(X, 1) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS PrevX,
		LAG(Y, 1) OVER (PARTITION BY PolygonID ORDER BY PointNum) AS PrevY
	FROM RightAngles
)

SELECT *
FROM InitialTable it
	INNER JOIN InitialTable2 it2
		ON it.PolygonID = it2.PolygonID AND it.PointNum = it2.PointNum
	INNER JOIN InitialTable3 it3
		ON it.PolygonID = it3.PolygonID AND it.PointNum = it3.PointNum








VertexCount AS (
	SELECT PolygonID, 
		COUNT(*) AS [Count]
	FROM RightAngles
	GROUP BY PolygonID
),
FirstVertex AS (
	SELECT PolygonID, 
		X, Y
	FROM RightAngles
	WHERE PointNum = 1
),
LastVertex AS (
	SELECT ra.PolygonID, 
		vc.[Count] AS PointNum,
		X, Y
	FROM RightAngles ra
		INNER JOIN VertexCount vc
			ON ra.PolygonID = vc.PolygonID
	WHERE ra.PointNum = vc.[Count]
)--,
--VertexList AS (
--	SELECT PolygonID, 1 AS PointNum, X, Y, 
--	FROM FirstVertex
--	UNION
--	SELECT PolygonID, PointNum, X, Y
--	FROM LastVertex
--	UNION
--	SELECT PolygonID, PointNum, X, Y
--	FROM 
--)

--SELECT * 
--PolygonID,
--	PointNum,
--	X,
--	Y,
--	NextX,
--	NextY,
--	PrevX,
--	PrevY
--FROM 
--	InitialTable it1
--		INNER JOIN InitialTable it2
--			ON it1.PolygonID = it2.PolygonID
--				AND it1.PointNum = it2.PointNum
--				AND it1.PointNum = 1



SELECT PolygonID, 
	PointNum, 
	X, 
	Y, 
	NextX, 
	ISNULL(NextY, SELECT Y FROM FirstVertex fv WHERE fv.PolygonID = it.PolygonID), 
	PrevX, 
	PrevY
FROM InitialTable
--GROUP BY PolygonID, PointNum, X, Y, NextX, NextY, PrevX, PrevY
--HAVING (1.0 * Y - ISNULL(NextY, SELECT Y FROM FirstVertex fv WHERE fv.PolygonID = it.PolygonID))/(X - NextX) = (-1.0 * X - PrevX)/(Y - PrevY)