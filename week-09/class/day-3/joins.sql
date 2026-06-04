USE northwind;

-- 1. List the product id, product name, unit price and category name of all products.
-- Order by category name and within that, by product name.

SELECT
	p.ProductID,
    p.ProductName,
    p.UnitPrice,
    c.CategoryName
FROM
	Products AS p
    JOIN Categories AS c ON (p.CategoryID = c.CategoryID)
ORDER BY c.CategoryName, p.ProductName;



-- 5. List the order id, ship name, ship address, and shipping company name of every
-- order that shipped to Germany.

SELECT
	o.OrderID,
    o.ShipName,
    o.ShipAddress,
    s.CompanyName
FROM
	Orders AS o
    JOIN Shippers AS s ON (o.ShipVia = s.ShipperID)
WHERE o.ShipCountry = "Germany";


-- 6. List the order id, order date, ship name, ship address of all orders that ordered
-- "Sasquatch Ale"?


SELECT
	o.OrderID,
    o.OrderDate,
    o.ShipName,
    o.ShipAddress
FROM
	Orders AS o
    INNER JOIN `Order Details` AS od ON (o.OrderID = od.OrderID)
    INNER JOIN Products AS p ON (od.ProductID = p.ProductID)
WHERE p.ProductName = "Sasquatch Ale";















