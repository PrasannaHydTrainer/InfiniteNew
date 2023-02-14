create table Student
(
   Sid int primary key auto_increment,
   Name varchar(30),
   sub1 int, sub2 int, sub3 int,
   total int, aveg numeric(9,2)
);

drop trigger trgStudent;

insert into student(name,sub1,sub2,sub3) values('Shivaji',66,67,66);

select * from Student;