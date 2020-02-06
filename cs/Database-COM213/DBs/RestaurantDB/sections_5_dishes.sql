/*Sections with 5 Dishes*/

USE Restaurant;

SELECT COUNT(ID) AS 'Cnt'
FROM (
  SELECT Sections.ID AS ID
  FROM Sections
    INNER JOIN Dishes
      ON Dishes.SectionID = Sections.ID
  GROUP BY Sections.ID
  HAVING COUNT(DISTINCT Dishes.ID) = 5
) AS IDsOfSectionsW5Dishes