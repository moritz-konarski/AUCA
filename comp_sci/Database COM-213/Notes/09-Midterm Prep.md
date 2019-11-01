# Midterm preparation

## Keywords

- ADD \<entity type\>: adds a column to an existing table
    - ADD CONSTRAINT: add a constraint to an existing table
- ALTER \<entity type\>: allows modification of a table, add, delete, modifies columns, changes
  data types of columns
    - ALTER COLUMN: change the data type of a column
    - ALTER TABLE: add, delete modify cols in a table
- ALL (\<subquery\>): returns true and then all the values if all subquery values meet a condition
- AND: logical operator
- ANY (\<subquery\>): returns true if any value of a subquery meets the requirements and
  returns that value(s)
- \<column, aggregate, query\> AS \<new name\>: creates col/table name alias
- \<value to be ordered by\> ASC: for sorting in ascending order
- BACKUP DATABASE: creates a backup of an existing database
- BETWEEN \<value 1\> AND \<value 2\>: values in a given range, including the
  limits
- CASE WHEN \<boolean expression\> THEN \<return value\> (may be repeated) ELSE \<return value\> END: return different values based on logical conditions
- CHECK \<boolean expression\>: DDL, checks entered values for certain
  conditions, also ADD CHECK, named CHK\_\_\<col name\>
- DROP \<entity\>: deletes a table, database, column, constraint, default,
  index, the structure as well
  as all data in it
- CREATE \<entity\>: creates a database, table, index, view, procedure
- DEFAULT \<value\>: sets the default value of a column
- DELETE FROM \<entity\> {WHERE \<boolean expression\>}: deletes the values in
  the specified entity, but not the structure itself
- \<value to be ordered by\> DESC: for sorting in descending order
- SELECT DISTINCT \<col name\> or COUNT(DISTINCT \<something\>): only counts
  distinct values, ignores duplicates
- EXISTS (\<subquery\>): returns true if subquery returns one or more results
- FROM \<col or subquery (requires alias)\>: specifies where the data is selected from
- GROUP BY \<col name\>: groups the result of the query by the specified
  column, used with COUNT, MAX, MIN, AVG, SUM
- HAVING \<boolean expression\>: specifies conditions for selections when GROUP
  BY is used, see WHERE 
- IN (\<set of values or subquery\>): can be used with WHERE or HAVING to
  specify multiple values in a comparison
- CREATE INDEX \<name\> ON \<table\> (\<col name\>): creates an index on a col
  in a table, allows duplicates
- INSERT INTO \<table\> (\<cols\>) VALUES (\<values\>): insets new data into
  a table
- INSERT INTO \<table\> (\<cols\>) SELECT \<query\>: insets new data into
  a table coming from the other query
- IS {NOT} NULL: test for {not} null values, returns boolean
- JOIN: joins two tables together based on some common values
    - INNER JOIN
    - LEFT JOIN
    - RIGHT JOIN
    - FULL OUTER JOIN
