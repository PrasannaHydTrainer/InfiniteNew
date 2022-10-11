package com.infinite.task;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {

	public List<Employee> getEmployeeStartwith(String startCh);
	// select * from Employee where name like "%"+ch+"%"
	public int getSumOfAllEmployees();
	// select count(*) cnt from Employee
	public int getSumOfAllEmployeesGreaterThanAge(int age);
	// select count(*) cnt from Employee where age > age
	public Map<Integer, List> getMapOfDepartmentIdAndEmployeesList(String departmentName);
	public List<Employee> showEmployee();
	// select * from Employee;
	
}
