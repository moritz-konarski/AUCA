use BigCompany;

SELECT [EmployeeName], 
	DATENAME([MONTH], '2018-' + CONVERT(VARCHAR, [MonthNumber]) + '-01') AS [MonthName],
	[Year],
	ISNULL(Salary, 0) + ISNULL(Bonus, 0) - ISNULL(Penalty, 0) AS TotalSalary
FROM (
	SELECT e.[Name] AS [EmployeeName],
		DATEPART([MONTH], s.PaymentDate) AS [MonthNumber], 
		DATEPART([YEAR], s.PaymentDate) AS [Year], 
		SUM(s.Amount) AS Salary,
		SUM(b.Amount) AS Bonus,
		SUM(p.Amount) AS Penalty
	FROM Employees e
		LEFT JOIN Salaries	s
			ON e.ID = s.EmployeeID
		LEFT JOIN Bonuses b
			ON e.ID = b.EmployeeID 
				AND b.Category NOT IN ('annual', 'quarterly')
				AND DATEPART([MONTH], b.PaymentDate) IN (3, 4, 5)
		LEFT JOIN Penalties p
			ON e.ID = p.EmployeeID
				AND DATEPART([MONTH], p.PaymentDate) IN (3, 4, 5)
	GROUP BY [Name],
		DATEPART([YEAR], s.PaymentDate),
		DATEPART([MONTH], s.PaymentDate)
	HAVING DATEPART([MONTH], s.PaymentDate) IN (3, 4, 5)
) AS ToBeSorted
ORDER BY [MonthNumber], [EmployeeName]