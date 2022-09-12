DROP SCHEMA IF EXISTS library;
CREATE SCHEMA library AUTHORIZATION sa;
DROP TABLE IF EXISTS library.user;
CREATE TABLE library.user ( 
   id INT NOT NULL, 
   user_name VARCHAR(50) NOT NULL, 
   password VARCHAR(20) NOT NULL
);

DROP TABLE IF EXISTS library.book;
CREATE TABLE library.book ( 
   book_isbn VARCHAR(50) NOT NULL, 
   book_name VARCHAR(50) NOT NULL,
   book_author VARCHAR(20),
   book_type VARCHAR(20)
);