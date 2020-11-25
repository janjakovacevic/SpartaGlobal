USE janja_db

DROP TABLE spartans_table

CREATE TABLE spartans_table(
    id INT NOT NULL IDENTITY PRIMARY KEY,
    title VARCHAR(5),
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    univeristy_attended VARCHAR(50),
    course VARCHAR(50),
    mark VARCHAR(10)
)

INSERT INTO spartans_table VALUES
('Mr', 'Emmanuel', 'Buraimo', 'King''s College London', 'Computer Science', '2:1'),
('Mr', 'Svilen', 'Petrov', 'London Metropolitan University', 'BSc Computing', 'First'),
('Mr', 'Reece', 'Louche', 'Univeristy of Warwick', 'Computer Science', '2:2'),
('Mr','Shahid','Enayat','Brunel University', 'Electronic and Electrical Engineering','2:2'),
('Mr', 'Abdullah', 'Muhammad', 'University of Southampton', 'Physics', 'First'),
('Mr', 'Ben', 'Swift', 'Nottingham Trent University','Computer Science', '2:1'),
('Mr', 'Saleh', 'Sandhu', 'University of Westminster', 'Computer Science', '2:1'),
('Mr', 'Toyin', 'Ajani', 'University of Bath', 'Chemical Engineering', 'First'),
('Mr', 'Chris', 'Cunningham', 'Loughborough', 'Computer Science', '2:1'),
('Mr', 'Dami', 'Oshidele', 'King''s College London', 'Electronic Engineering with Management', '2:1'),
('Miss', 'Janja', 'Kovacevic', 'University of Massachusetts Amherst', 'Computer Science and Computational Mathematics', '3.9')

SELECT * FROM spartans_table