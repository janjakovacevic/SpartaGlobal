USE Northwind


-- PRACTICE --

-- how many employess have a home city of London?
SELECT COUNT(*) AS EmployeesFromLondon FROM Employees AS e WHERE e.City = 'London';
            -- Employees e allows a drop down menu in WHERE clause e.<drop down>

-- which employee is a doctor?
SELECT FirstName, LastName, TitleOfCourtesy FROM Employees WHERE TitleOfCourtesy = 'Dr.';

-- how many products are discontinued?
SELECT COUNT(*) AS DiscountinuedProducts FROM Products WHERE Discontinued = 1;
-- 0: false, 1: true

-- END OF PRACTICE --


-- CODING GAMES columns aliasing - double quotes, use AS keyword --
-- NVARCHAR: used to represent UNICODE

/*	
    % - a substitute for zero or more characters

	_ - a substitute for exactly one character

	[charlist] - sets and ranges of characters to match

	[^charlist] - sets and ranges of characters that don't match
*/

-- This will bring back anything starting with letter C
SELECT p.ProductName FROM Products p WHERE p.ProductName LIKE 'C%'

-- This will bring back anything starting with letter C and is 4 letters long
SELECT p.ProductName FROM Products p WHERE p.ProductName LIKE 'C___'

-- This will bring back anything starting with any of those letters
SELECT p.ProductName FROM Products p WHERE p.ProductName LIKE '[CDE]%'
                    -- NOTE: SQL is not case sensitive

-- this will bring back anything that does not start with these letters
SELECT p.ProductName FROM Products p WHERE p.ProductName LIKE '[^CDE]%'

-- IN operator
SELECT e.LastName FROM Employees e WHERE e.City IN ('London', 'New York', 'Seattle')

-- BETWEEN operator
SELECT * FROM EmployeeTerritories et WHERE et.TerritoryID BETWEEN 06000 AND 98999


-- PRACTICE --

-- what are the names and product IDs of the products with a unit price below 5.00?
SELECT p.ProductName, p.ProductID FROM Products p WHERE p.UnitPrice < 5.00;

-- which categories have a category name with initials beginning with B or S?
SELECT c.CategoryName FROM Categories c WHERE c.CategoryName LIKE '[BS]%';

-- how many orders are there for employeesIDs 5 and 7?
    -- (total for both)
SELECT COUNT(o.OrderID) AS "Number Of Orders" FROM Orders o WHERE o.EmployeeID IN (5,7);
    -- (for each employee ID)
SELECT o.EmployeeID, COUNT(o.OrderID) AS "Number Of Orders" FROM Orders o WHERE o.EmployeeID IN (5,7) GROUP BY o.EmployeeID;

-- END OF PRACTICE --


-- concatenate using + and single quotes or CONCAT() function (BOTH WORK)
SELECT CompanyName AS "Company Name", City + ', ' + Country AS "City" FROM Customers;
SELECT CompanyName AS "Company Name", CONCAT(City, ', ', Country) AS "City" FROM Customers;


-- PRACTICE --

-- write a select statement usig the Employees table and concatenate First Name and Last Name together
-- use a column alias to rename the column to Employee Name
SELECT CONCAT(e.FirstName, ' ', e.LastName) AS "Employee Name" FROM Employees e;


-- END PRACTICE --


-- In order to filter based on NULLs simply use IS NULL or IS NOT NULL
SELECT CompanyName FROM Customers WHERE Region IS NULL


-- PRACTICE --

-- 
SELECT DISTINCT c.Country FROM Customers c WHERE c.Region IS NOT NULL

-- END PRACTICE --

-- arithmetics
SELECT Unitprice, Quantity, Discount, UnitPrice*Quantity AS "Gross Total" FROM [Order Details]

-- PRACTICE --

-- add a new column to the query above to show the Net Total which has the discount column applied to it
SELECT Unitprice, Quantity, Discount, UnitPrice*Quantity AS "Gross Total", UnitPrice*(1-Discount)*Quantity AS "Net Total" FROM [Order Details]

-- END PRACTICE --


-- ORDER BY
SELECT Unitprice, Quantity, Discount, UnitPrice*Quantity AS "Gross Total", UnitPrice*(1-Discount)*Quantity AS "Net Total" 
FROM [Order Details] ORDER BY "Gross Total" DESC, "Net Total" DESC

SELECT Unitprice, Quantity, Discount, UnitPrice*Quantity AS "Gross Total", UnitPrice*(1-Discount)*Quantity AS "Net Total" 
FROM [Order Details] ORDER BY 4 DESC, 5 DESC


-- PRACTICE --

-- user OREDER BY to identify the highest Net Total in the Order Details table
-- what are the two order numbers with the highest total?
SELECT TOP 2 OrderID, Unitprice, Quantity, Discount, UnitPrice*Quantity AS "Gross Total", UnitPrice*(1-Discount)*Quantity AS "Net Total" FROM [Order Details] ORDER BY 6 DESC

-- END PRACTICE --

SELECT c.PostalCode AS "Post Code", LEFT(c.PostalCode, CHARINDEX(' ', c.PostalCode)-1) AS "Post Code Region", CHARINDEX(' ', c.PostalCode) AS "Space Found", Country
FROM Customers c
WHERE c.Country = 'UK'

-- apostrophies
SELECT p.ProductName FROM Products p WHERE p.ProductName LIKE 'C%''%'

-- use CHARINDEX to list only Product Names that contain a single quote
SELECT p.ProductName
FROM Products p 
WHERE CHARINDEX('''', p.ProductName) != 0


-- output a list of Employees from the Employees from the Employees table 
-- include their Name (concatenated) and their Age (calculate from BirthDate)

SELECT CONCAT(e.FirstName, ' ', e.LastName) AS "Name",
     DATEDIFF(yyyy, e.BirthDate, GETDATE()) AS "Age"
FROM Employees e 

SELECT CONCAT(e.FirstName, ' ', e.LastName) AS "Name",
     DATEDIFF(d, e.BirthDate, GETDATE())/365.25 AS "Age"
FROM Employees e 

-- CASE statements can be useful when you need varying results output based on different data
-- Have as many WHEN-THEN as needed
SELECT CASE WHEN DATEDIFF(d, OrderDate, ShippedDate)<10 THEN 'On Time'
ELSE 'Overdue'
END AS "Status"
FROM Orders

-- use CASE to add a column to the previous activity solution called Retirement status
-- 65 > 'Retired', 60 > 'Retirement Due', 60 < 'More than 5 years to go'
SELECT CONCAT(FirstName, ' ', LastName) AS "Employee Name",
CASE WHEN DATEDIFF(d, BirthDate, GETDATE())/365.25 > 65 THEN 'Retired'
WHEN DATEDIFF(d, BirthDate, GETDATE())/365.25 > 60 THEN 'Retirement Due'
ELSE 'More Than 5 Years To Go'
END AS "Retirement Status"
FROM Employees


-- Aggregates can be used without a GROUP BY
-- If you use an aggregate function in SELECT statement, 
-- all other columns must either be an aggregate or in the GROUP BY clause
SELECT SUM(UnitsOnOrder) AS "Total On Order",
	    AVG(UnitsOnOrder) AS "AvgOn Order",
		MIN(UnitsOnOrder) AS "Min On Order",
		MAX(UnitsOnOrder) AS "Max On Order"
FROM Products

-- Multiple columns can be added as a comma separated list to provide further levels of subtotals
SELECT SupplierID, SUM(UnitsOnOrder) AS "Total On Order",
	    AVG(UnitsOnOrder) AS "AvgOn Order",
		MIN(UnitsOnOrder) AS "Min On Order",
		MAX(UnitsOnOrder) AS "Max On Order"
FROM Products
GROUP BY SupplierID

-- use GROUP BY to calculate the Avergae Reorder Level for all products by CategoryID
-- what is the highest Average Reorder Level?
SELECT TOP 1 CategoryID, AVG(ReorderLevel) AS "Average Recorded Level"
FROM Products
GROUP BY CategoryID
ORDER BY 2 DESC

-- HAVING is used instead of WHERE when filtering on subtotals/grouped data
SELECT SupplierID, SUM(UnitsOnOrder) AS "Total On Order",
	AVG(UnitsOnOrder) AS "AvgOn Order"
FROM Products
GROUP BY SupplierID
HAVING AVG(UnitsOnOrder) > 5