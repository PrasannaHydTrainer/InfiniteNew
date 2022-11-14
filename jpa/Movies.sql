drop database if exists moviesdb;

create database moviesdb;

use moviesdb;

create table Movie
(
  movie_Id int primary key auto_increment,
  movie_Name varchar(30),
  movie_Rating int,
  movie_Genre varchar(30)
);

Insert into Movie(Movie_Name,Movie_rating,Movie_Genre)
values('titanic',5,'Fiction'),
('TrueLies',5,'Drama'),
('Terminator',5,'Satire');