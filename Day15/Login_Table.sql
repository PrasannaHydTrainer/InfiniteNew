use infinite;

drop table if exists login;

create table login 
(
    userName varchar(30) primary key,
    passCode varchar(30) NOT NULL
);

insert into login(userName, passcode)
values('Sumanth','Chandra'),('Abhishek','Raj'),
('Gaurav','Sharma'),('Harshit','Tiwari');