SELECT * FROM products
/*STRING FUNCTIONS*/

CREATE DATABASE astha_db

USE astha_db

DROP DATABASE astha_db

DROP TABLE film_table

CREATE TABLE film_table(
    film_id INT IDENTITY(1,1) PRIMARY KEY,
    film_name VARCHAR(50) NOT NULL,
    film_type VARCHAR(50)
)

INSERT INTO film_table VALUES
('    Star Wars', 'Sci fi'),
('Star Trek    ', 'Sci fi')

INSERT INTO film_table VALUES
('Batman', 'Action')


INSERT INTO film_table
(film_name) VALUES
('Superman')


SELECT * FROM film_table

--STRING FUNCTIONS--
SELECT film_name, CHARINDEX('s', film_name) AS "Position of Character" FROM film_table ;

SELECT film_name, SUBSTRING(film_name, 2, 3) AS "Extracted String" FROM film_table

SELECT film_name, RIGHT(film_name, 2) AS "Extracted String" FROM film_table

SELECT film_name, LEFT(film_name, 2) AS "Extracted String" FROM film_table

SELECT film_name, RTRIM(film_name) AS "Trimmed String" FROM film_table

SELECT film_name, LTRIM(film_name) AS "Trimmed String" FROM film_table

SELECT film_name, REPLACE(film_name,' ','A') AS "Replaced String" FROM film_table


SELECT film_name, LEN(film_name) AS "LENGTH of String" FROM film_table

SELECT film_name, UPPER(film_name) AS "Uppercase String", LOWER(film_name) AS "Lowercase String" FROM film_table

-- SELECT e.FirstName,
-- FROM Employees e



SELECT * FROM Employees


SELECT PostalCode AS "Post code",
LEFT(PostalCode, CHARINDEX(' ',PostalCode)-1)
AS "Post Code Region",
CHARINDEX(' ', PostalCode) AS "Space Found", Country
FROM customers
WHERE Country = 'UK'


--Apostrophy-SQL-You need to escape it using two single quotes otherwise 
--SQL processor will think the apostrophe as a closing quote

SELECT p.ProductName AS "Product Name with an Apostrophe"
FROM Products p
WHERE p.ProductName LIKE '%''%'


SELECT p.ProductName AS "Product Name with an Apostrophe"
FROM Products p
WHERE CHARINDEX('''',P.ProductName)>0

SELECT CONCAT(e.FirstName,' ', e.LastName) AS "Employee Name",
YEAR(GETDATE()) - YEAR(e.BirthDate) AS "Employee Age"
FROM Employees e

SELECT CONCAT(e.FirstName,' ', e.LastName) AS "Employee Name",
DATEDIFF(yy, e.BirthDate, GETDATE()) AS "Employee Age"
FROM Employees e

SELECT CONCAT(e.FirstName,' ', e.LastName) AS "Employee Name",
DATEDIFF(dd, e.BirthDate, GETDATE())/365.25 AS "Employee Age"
FROM Employees e

SELECT CONCAT(e.FirstName,' ', e.LastName) AS "Employee Name",
DATEDIFF(yy,e.BirthDate,GETDATE()) AS "Age"
FROM Employees e







