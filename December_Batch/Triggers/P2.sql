DELIMITER $$   
CREATE TRIGGER trgStudent before INSERT  
ON Student for each row
BEGIN  
   if new.total is null then
     set new.total = new.sub1 + new.sub2 + new.sub3;
     set new.aveg = new.total/3;
 --    update student set aveg = (total)/3;
   end if;
END$$  
DELIMITER ;  