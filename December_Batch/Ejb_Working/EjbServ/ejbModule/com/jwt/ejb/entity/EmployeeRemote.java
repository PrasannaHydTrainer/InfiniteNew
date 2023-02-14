package com.jwt.ejb.entity;

import javax.ejb.Remote;

 
@Remote
public interface EmployeeRemote {
    public boolean addEmployee(Employee employee);
    Employee searchEmployee(int id);
}

