CREATE DATABASE janja_db
USE janja_db

DROP TABLE IF EXISTS course
CREATE TABLE course  
(
    c_id INT IDENTITY(1,1) PRIMARY KEY,
    course_name VARCHAR(30)
)

DROP TABLE IF EXISTS student
CREATE TABLE student
(
    st_id INT IDENTITY(1,1),
    student_name VARCHAR(30),
    course_id INT,
    FOREIGN KEY (course_id) REFERENCES course(c_id) ON DELETE CASCADE

)


INSERT INTO course
(
    course_name
)
VALUES
(
    'Business' 
),
(
    'Test'
),
(
    'Agile'
),
(
    'Web'
),
(
    'Dev'
)

INSERT INTO student
(
   student_name, course_id 
)
VALUES
(
    'Lee', 1
),
(
    'Barry', 1
),
(
    'David', 2
),
(
    'Tim',5
)


INSERT INTO student
(
   student_name
)
VALUES
(
    'Nicole'   
)

SELECT * FROM student
SELECT * FROM course

/*INNER JOIN-matched rows*/
--DOD-->JOIN SYNTAX-->1. Applying the join keyword based on the question
                -->2. Understanding which table to put in the left and which at the right
                -->3. Applying the ON keyword to define the primary key and foreign key relationship

SELECT * FROM student s INNER JOIN course c
ON s.course_id=c.c_id --ON defines primary key and foeign key relationship

/*OUTER JOINS-LEFT JOIN, RIGHT JOIN, FULL JOIN*/
/*LEFT JOIN-All the rows from the left table and only the matching rows from the right table*/

SELECT * FROM student s LEFT JOIN course c   
ON s.course_id=c.c_id

SELECT * FROM student s RIGHT JOIN course c   
ON s.course_id=c.c_id

SELECT * FROM student s FULL JOIN course c   
ON s.course_id=c.c_id








