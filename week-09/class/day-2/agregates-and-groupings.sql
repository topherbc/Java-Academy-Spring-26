USE northwind;

-- 1. How many suppliers are there? Use a query!

SELECT COUNT(*) AS "Total Supplier Amount" FROM Suppliers;


-- 2. What is the sum of all the employee's salaries?

SELECT
	CONCAT("$", ROUND(SUM(Salary), 2)) AS 'Employee Salary Total'
FROM Employees;


-- 3. What is the price of the cheapest item that Northwind sells?

SELECT
	ProductName,
    ROUND(UnitPrice, 2)
FROM
	Products
ORDER BY UnitPrice
LIMIT 1;

SELECT
	ProductName,
    ROUND(MIN(UnitPrice), 2)
FROM
	Products
GROUP BY ProductName
ORDER BY MIN(UnitPrice)
LIMIT 1;

-- 4. What is the average price of items that Northwind sells?

SELECT ROUND(AVG(UnitPrice), 2) FROM Products;


-- 5. What is the price of the most expensive item that Northwind sells?

SELECT
	ROUND(MAX(UnitPrice), 2)
FROM Products;


-- 6. What is the supplier ID of each supplier and the number of items they supply?
-- You can answer this query by only looking at the Products table.

SELECT
	SupplierID,
    COUNT(*) Total_Products
FROM Products
GROUP BY SupplierID;


-- 7. What is the category ID of each category and the average price of each item in the
-- category? You can answer this query by only looking at the Products table.

SELECT
	CategoryID,
    ROUND(AVG(UnitPrice), 2) Average_Price
FROM Products
GROUP BY CategoryID;


-- 8. For suppliers that provide at least 5 items to Northwind, what is the supplier ID of
-- each supplier and the number of items they supply? You can answer this query
-- by only looking at the Products table.

SELECT
	SupplierID,
    COUNT(*)
FROM Products
GROUP BY SupplierID
HAVING COUNT(*) >= 5;



-- 9. List the product id, product name, and inventory value (unit price * units on
-- hand). Sort the results in descending order by value. If two or more have the
-- same value, order by product name

SELECT
	ProductID,
    ProductName,
    ROUND(UnitPrice * UnitsInStock, 2) Inventory_Value
FROM Products
ORDER BY Inventory_Value DESC, ProductName ASC;



