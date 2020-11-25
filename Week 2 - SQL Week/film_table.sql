CREATE DATABASE janja_db;

USE janja_db;

-- DDL command
CREATE TABLE film_table(
    film_name VARCHAR(10),
    film_type VARCHAR(6)
)

-- DDL command
ALTER TABLE film_table
ADD release_date DATETIME;

ALTER TABLE film_table 
ALTER COLUMN film_name VARCHAR(10) NOT NULL;

-- DML command
INSERT INTO film_table VALUES ('Burlesque', 'Music', '2010-11-24')

INSERT INTO film_table VALUES 
('Star Wars', 'Sci-Fi', '1997-05-12'),
('Aladdin', 'Animated', '1992-10-13')

INSERT INTO film_table
(
    release_date, film_name, film_type
)
VALUES(
    '2008-12-09','Woolverin', 'Sci-Fi'
);

-- Applying formated date and aliasing using AS
SELECT film_name, film_type,
FORMAT(release_date, 'dd/MM/yyyy') AS "Formatted Date" FROM film_table

-- DML command
SELECT CONVERT(datetime, release_date, 102) FROM film_table

DELETE FROM film_table where film_type = 'Sci-Fi';

-- DDL command
DROP TABLE film_table

SP_HELP film_table

--comments--
