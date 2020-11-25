USE Northwind

-- inner join with avg as aggregate function
SELECT s.SupplierID, s.CompanyName, AVG(p.UnitPrice) AS "Average Unit Price"
FROM Products p 
INNER JOIN Suppliers s ON p.SupplierID = s.SupplierID
GROUP BY s.SupplierID, s.CompanyName

-- inner join x2
SELECT ProductName, UnitPrice, CompanyName AS "Supplier", CategoryName AS "Category"
FROM Products p
INNER JOIN Suppliers s ON p.SupplierID = s.SupplierID
INNER JOIN Categories c ON p.CategoryID = c.CategoryID

-- list orders from the orders table and JOIN 
-- to the customers and employees tables to include 
-- cusotmer name (company name) and employee name (first and last name)
SELECT o.OrderID, o.OrderDate, o.Freight, c.CompanyName AS "Customer Name", 
	CONCAT(e.FirstName, ' ', e.LastName) AS "Employee Name"
FROM Orders o 
INNER JOIN Customers c ON o.CustomerID = c.CustomerID
INNER JOIN Employees e ON o.EmployeeID = e.EmployeeID

-- subquery in a where clause
-- customers who have not placed any orders using subquery
SELECT CompanyName AS "Customer"
FROM Customers
WHERE CustomerID NOT IN (SELECT CustomerID FROM Orders)

-- same query using JOIN instead of subquery (customerID)
SELECT CompanyName AS "Customer"
FROM Customers c 
LEFT JOIN Orders o ON c.CustomerID = o.CustomerID
WHERE o.CustomerID IS NULL 

-- same query using JOIN instead of subquery (orderID)
SELECT CompanyName AS "Customer"
FROM Customers c 
LEFT JOIN Orders o ON c.CustomerID = o.CustomerID
WHERE o.OrderID IS NULL 

-- subquery - acts like a column
SELECT OrderID, ProductID, UnitPrice, Quantity, Discount, 
	(SELECT MAX(UnitPrice) FROM [Order Details] od) AS "Max Price"
FROM [Order Details]

-- advanced query (nested query) - subquery acts like a table
SELECT od.ProductID, sq1.totalamt AS "Total Sold for this Product", 
UnitPrice, (UnitPrice*Quantity/totalamt)*100 AS "% of Total"
	FROM [Order Details] od
	INNER JOIN
		(SELECT ProductID, SUM(UnitPrice*Quantity) AS totalamt
		FROM [Order Details]
        GROUP BY ProductID) sq1 ON sq1.ProductID = od.ProductID

-- using a subquery in the where clause list all orders from the 
-- Order Details table where the product has been discontinued
SELECT od.OrderID, od.ProductID, od.UnitPrice, od.Quantity, od.Discount
FROM [Order Details] od
WHERE od.ProductID IN 
    (SELECT p.ProductID FROM Products p WHERE p.Discontinued = 1)

-- do the same using a simple join
SELECT od.OrderID, od.ProductID, od.UnitPrice, od.Quantity, od.Discount
FROM [Order Details] od
INNER JOIN Products p ON od.ProductID = p.ProductID
WHERE p.Discontinued = 1

-- set operators: UNION, UNION ALL, INTERSECT, EXCEPT
-- UNION ALL returns duplicate values, UNION does not
SELECT EmployeeID AS "Employee/Supplier"
FROM Employees
UNION ALL
SELECT SupplierID
FROM Suppliers

-- FORMAT
SELECT OrderID, FORMAT(OrderDate, 'dd/MM/yyyy')
FROM Orders