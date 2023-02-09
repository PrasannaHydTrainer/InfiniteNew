use cmsinfinitenew;

Create Table Otp
(
   OtpId int primary key auto_increment,
   userName varchar(30),
   OtpNo INT,
   Attempts INT,
   status varchar(30) default 'ACTIVE'
)
