use infinite;
create table LoginHistory
(
    historyId INT Primary Key auto_increment,
    userName varchar(30),
    passCode varchar(150),
    createdOn timestamp default current_timestamp
);

Insert into LoginHistory(userName,passcode) 
select userName, passcode from Login where userName='avesh';