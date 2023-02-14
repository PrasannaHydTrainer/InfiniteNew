package com.java.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface EmployeeBeanRemote {
	  boolean addEmployee(Employee employee);
	  Employee searchEmployee(int id);
	  List<Employee> showEmployee();
	  String updateEmployee(Employee employeeNew);
}
