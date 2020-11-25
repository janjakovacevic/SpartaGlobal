USE janja_db;

CREATE TABLE film_table_practice(
    film_name VARCHAR(20),
    film_type VARCHAR(10),
    release_date DATETIME,
    director VARCHAR(20),
    writer VARCHAR(20),
    star VARCHAR(20),
    film_language VARCHAR(10),
    website VARCHAR(30),
    plot_summary VARCHAR(1000)
)

ALTER TABLE film_table_practice
ADD film_id INTEGER

ALTER TABLE film_table_practice
ALTER COLUMN film_id INTEGER NOT NULL

ALTER TABLE film_table_practice
  ADD CONSTRAINT pk
    PRIMARY KEY (film_id)

-- ALTER TABLE film_table_practice ADD film_id int NOT NULL IDENTITY (1,1) PRIMARY KEY
-- ADD film_id INT NOT NULL IDENTITY PRIMARY KEY

INSERT INTO film_table_practice VALUES
('Burlesque', 'Musical', '2010-11-24', 'Steven Antin', 'Steven Antin', 'Cher', 'English', NULL, 'A small-town girl ventures to Los Angeles and finds her place in a neo-burlesque club run by a former dancer.', 1),
('Aladdin', 'Animation', '1992-01-01', 'Ron Clements', 'Ron Clements', 'Robin Williams', 'English', NULL, 'A kindhearted street urchin and a power-hungry Grand Vizier vie for a magic lamp that has the power to make their deepest wishes come true.', 2),
('Gladiator', 'Drama', '2000-02-02', 'Ridley Scott', 'David Franzoni', 'Russell Crowe', 'English', NULL, 'A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.', 3),
('Star Wars:Episode IV', 'Fantasy', '1977-05-25', 'George Lucas', 'George Lucas', 'Harrison Ford', 'English', NULL, 'Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee and two droids to save the galaxy from the Empires world-destroying battle station, while also attempting to rescue Princess Leia from the mysterious Darth Vader.', 4),
('The Duff', 'Comedy', '2015-02-20', 'Ari Sandel', 'Josh A. Cagan', 'Bella Thorne', 'English', NULL, 'A high school senior instigates a social pecking order revolution after finding out that she has been labeled the DUFF - Designated Ugly Fat Friend - by her prettier, more popular counterparts.', 5)

ALTER TABLE film_table_practice 
ADD DEFAULT 'English' FOR film_language; 

ALTER TABLE film_table_practice 
ADD CONSTRAINT df_website
DEFAULT 'https://www.imdb.com/' FOR website;

ALTER TABLE film_table_practice
DROP CONSTRAINT DF__film_tabl__film___3A81B327;


CREATE TABLE directors(
    director_id INT IDENTITY PRIMARY KEY,
    director_name VARCHAR(30)
)

INSERT INTO directors VALUES('George'),('David'),('William')
INSERT INTO directors VALUES('Lucas'),('Ari')

-- REFERENTIAL INTEGRITY
ALTER TABLE film_table_practice
ADD director_id INT FOREIGN KEY REFERENCES directors(director_id)

-- DML
UPDATE film_table_practice SET director_id = 5 WHERE director LIKE 'Ari%'
UPDATE film_table_practice SET film_type = 'Sci-Fi' WHERE film_name = 'Star Wars:Episode IV'
-- DML
DELETE FROM directors WHERE director_id = 1



SELECT * FROM film_table_practice
SELECT * FROM directors

SELECT * FROM film_table_practice WHERE film_type IN ('Comedy', 'Animation', 'Drama')
SELECT * FROM film_table_practice WHERE director_id IN (SELECT director_id FROM directors)

SELECT 12.5/2.5

SP_HELP film_table_practice