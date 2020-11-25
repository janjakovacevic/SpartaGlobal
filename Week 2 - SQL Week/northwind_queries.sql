USE Northwind

-- EXERCISE 1

/* 
    1.1: Write a query that lists all Customers 
    in either Paris or London. Include Customer ID, 
    Company Name and all address fields
*/

SELECT c.CustomerID, c.CompanyName AS "Company Name", 
        CONCAT(c.Address, ', ', c.City, ', ', c.Region, ', ', c.PostalCode, ', ', c.Country)
FROM Customers c 
WHERE c.City IN ('Paris', 'London')

/*
    1.2 List all products stored in bottles. 
*/

SELECT p.ProductName
FROM Products p 
WHERE p.QuantityPerUnit LIKE '%bottle%'

/*
    1.3 Repeat question above, but add in the Supplier Name and Country.
*/

SELECT p.ProductName, s.CompanyName, s.Country
FROM Products p 
RIGHT OUTER JOIN Suppliers s 
ON p.SupplierID = s.SupplierID
WHERE p.QuantityPerUnit LIKE '%bottle%'

/*
    1.4 Write an SQL Statement that shows 
    how many products there are in each category. 
    Include Category Name in result set 
    and list the highest number first.
*/

SELECT c.CategoryName, COUNT(DISTINCT p.ProductID) AS "Products per Category"
FROM Products p
INNER JOIN Categories c 
    ON p.CategoryID = c.CategoryID
GROUP BY c.CategoryName
ORDER BY 2 DESC

/* 
    1.5	List all UK employees using concatenation to join their 
    title of courtesy, first name and last name together. 
    Also include their city of residence.
*/

SELECT CONCAT(e.TitleOfCourtesy, ' ', e.FirstName, ' ', e.LastName) AS "Full Name", e.City
FROM Employees e 
WHERE e.Country = 'UK'

/*
    1.6	List Sales Totals for all Sales Regions 
    (via the Territories table using 4 joins) 
    with a Sales Total greater than 1,000,000. 
    Use rounding or FORMAT to present the numbers. 
*/

SELECT FORMAT(SUM(od.UnitPrice * od.Quantity * (1 - od.Discount)), '#,#') AS "Sales Total", 
        r.RegionDescription AS "Region"
FROM [Order Details] od
INNER JOIN Orders o 
    ON o.orderID = od.orderID
INNER JOIN Employees e
    ON e.EmployeeID = o.EmployeeID
INNER JOIN EmployeeTerritories et 
    ON et.EmployeeID = e.EmployeeID
INNER JOIN Territories t 
    ON t.TerritoryID = et.TerritoryID
INNER JOIN Region r
    ON t.RegionID = r.RegionID
GROUP BY r.RegionDescription
HAVING SUM(od.UnitPrice * od.Quantity * (1 - od.Discount)) > 1000000


/*
    1.7	Count how many Orders have a Freight amount 
    greater than 100.00 and either USA or UK as Ship Country.
*/

SELECT COUNT(*) AS "Orders from USA and UK with a Freight amount greater than 100.00"
FROM Orders o 
WHERE o.Freight > 100.00 AND (O.ShipCountry IN ('USA', 'UK'))

/*
    1.8	Write an SQL Statement to identify the Order Number of the Order 
    with the highest amount(value) of discount applied to that order.
*/

-- there are 2 OrderIDs (10353, 10372) with the same highest value of total discount (2108) and both are displayed

SELECT TOP 2 od.OrderID, od.Discount * od.Quantity * od.UnitPrice AS "Total Discount"
FROM [Order Details] od 
ORDER BY "Total Discount" DESC

-- EXERCISE 2

/* 
    spartans_table.sql
*/

-- EXERCISE 3

/*
    3.1 List all Employees from the Employees table and who they report to. 
    No Excel required. (5 Marks)
*/

SELECT CONCAT(e1.FirstName, ' ', e1.LastName) AS "Employee Name", 
        CONCAT(e2.FirstName, ' ', e2.LastName) AS "Manager the Employee Reports To"
FROM Employees e1
LEFT JOIN Employees e2
ON e1.ReportsTo = e2.EmployeeID


/*
    3.2 List all Suppliers with total sales over $10,000 in the Order Details table. 
    Include the Company Name from the Suppliers Table 
    and present as a bar chart as below: (5 Marks)
*/

SELECT s.CompanyName,
        FORMAT(SUM(od.UnitPrice * od.Quantity * (1 - od.Discount)), '#,#') AS "Total Sales per Supplier"
FROM Suppliers s
    JOIN Products p
        ON p.SupplierID = s.SupplierID
    JOIN [Order Details] od
        ON od.ProductID = p.ProductID
GROUP BY s.SupplierID, s.CompanyName
HAVING SUM(od.UnitPrice * od.Quantity * (1 - od.Discount)) > 10000
ORDER BY SUM(od.UnitPrice * od.Quantity * (1 - od.Discount)) DESC

/*
    3.3 List the Top 10 Customers YTD for the latest year in the Orders file. 
    Based on total value of orders shipped. 
    No Excel required. (10 Marks)
*/

SELECT TOP 10 c.CustomerID, c.CompanyName, 
    FORMAT(SUM(od.UnitPrice * od.Quantity * (1-od.Discount)), '#,#') AS "Total Value Of Orders Shipped in YTD"
FROM [Order Details] od
INNER JOIN Orders o 
    ON od.OrderID = o.OrderID
INNER JOIN Customers c
    ON o.CustomerID = c.CustomerID
WHERE YEAR(o.ShippedDate) IN (SELECT YEAR(MAX(ShippedDate)) FROM Orders)
GROUP BY c.CustomerID, c.CompanyName, o.ShippedDate
ORDER BY SUM(od.UnitPrice * od.Quantity * (1-od.Discount)) DESC


/*
    3.4 Plot the Average Ship Time by month for all data in the 
    Orders Table using a line chart as below. (10 Marks)
*/

SELECT CONCAT(MONTH(o.OrderDate), '-',YEAR(o.OrderDate)) AS "Month-Year Ordered",
    AVG(DATEDIFF(d, o.OrderDate, o.ShippedDate)) AS "Average Ship Time in Days by Month"
FROM Orders o 
GROUP BY YEAR(o.OrderDate), MONTH(o.OrderDate)
ORDER BY YEAR(o.OrderDate), MONTH(o.OrderDate)

