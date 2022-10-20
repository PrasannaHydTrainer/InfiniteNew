drop database if exists oyo;
create database oyo;
use oyo;
Create Table Room
(
   RoomID varchar(10) primary key,
   Type varchar(10),
   Status ENUM('AVAILABLE','BOOKED') default 'AVAILABLE',
   CostPerDay INT
);

-- Type must be Single or Double 

Create Table Booking
(
  BookId varchar(10) primary key,
  RoomID varchar(10),
  CustName varchar(30),
  City varchar(30),
  BookDate Date,
  ChkInDate Date,
  ChkOutDate Date
);

Create Table Billing 
(
   BookID varchar(10),
   RoomID varchar(10),
   NoOfDays INT,
   BillAmt INT
);
