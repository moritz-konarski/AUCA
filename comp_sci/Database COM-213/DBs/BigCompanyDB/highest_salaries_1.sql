use BigCompany;

SELECT e.[Name] AS [EmployeeName],
	DATENAME([MONTH], s.PaymentDate) AS [MonthName], 
	DATEPART([YEAR], s.PaymentDate) AS [Year], 
	SUM(Amount) AS [TotalSalary]
FROM Employees e
	INNER JOIN Salaries	s
		ON e.ID = s.EmployeeID
GROUP BY [Name], 
	DATEPART([YEAR], s.PaymentDate), 
	DATENAME([MONTH], s.PaymentDate)
HAVING DATENAME([MONTH], s.PaymentDate) IN ('March', 'April', 'May')