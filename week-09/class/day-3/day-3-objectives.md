What did you learn yesterday?

1. SQL Commands
   1. USE db - sets db to be used for remainder of sql queries
   2. AS - sets an alias, this can be for columns and tables
   3. WHERE
   4. LIMIT - limits the results displayed
   5. GROUP BY - finding a common value, and grouping on that value. Finds all that matches, and collapses to one
      1. EX. Grouping on product, finds all entries that have that product, and collapses to view only that product and matching values
   6. HAVING - condition for grouping/aggregates
2. Aggregate Functions
   1. CONCAT() - combine multiple in a row
      1. CONCAT("$", price) - results in $1.00
   2. CONCAT_WS("-", id, name, product)
      1. id = 2
      2. name = "vampire"
      3. product = "fang"
      4. 2-vampire-fang
   3. ROUND()
   4. AVG()
   5. MIN()
   6. MAX()
   7. SUM()

Today's Objectives

1. Subqueries or nested queries
2. JOIN's

Agenda Today

1. Intro, Recap
2. Class trip to the zoo
3. Subqueries
4. break
5. exercise
6. JOINs lesson
7. Lunch
8. JOIN's
9. Recap and Q&A


What did you learn today?

1. JOIN - establish connection between two tables for query
   1. connect tables by Primary Key and Foreign key relationships
   2. ON
   3. LEFT JOIN
   4. INNER JOIN or JOIN
   5. RIGHT JOIN
2. PrimaryKey or PK - id on primary table
   1. Orders, an OrderID is the PrimaryKey
3. Foreign Key or FK - Primary Key, on a different table
   1. ON Orders, ProductID is a forign key of Products table, on Order table
4. Nested Queries or subqueries
   1. query in query
   2. write subqueries first
   3. Required to return 1 value, or 1 list of values
5. Miranda hires murderers
