use cmsinfinitenewusertest;

create table UserTest
(
    uid int primary key auto_increment,
    firstName varchar(30),
    lastName varchar(30),
    email varchar(30),
    userName varchar(30),
    otp varchar(30),
    password varchar(30),
    status varchar(30) default 'ACTIVE'
);

