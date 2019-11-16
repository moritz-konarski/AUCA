use FootballChampions;

SELECT t.Name, 
	100.0 * SUM(m2.VisitorScore) / (SUM(m1.HomeScore) + SUM(m2.VisitorScore)) AS TotalScore
FROM Teams t
	INNER JOIN Matches m1
		ON t.ID = m1.HomeTeamID
	INNER JOIN Matches m2
		ON	 T.ID = m2.VisitorTeamID
GROUP BY t.Name
ORDER BY TotalScore DESC, t.Name