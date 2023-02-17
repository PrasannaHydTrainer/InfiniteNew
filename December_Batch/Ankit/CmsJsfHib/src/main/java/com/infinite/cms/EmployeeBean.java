package com.infinite.cms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class EmployeeBean {
    private List<Employee> employeeList = new ArrayList<Employee>();
    public List<Employee> getEmployeeList() {
    	employeeList.add(new Employee(1, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(2, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(3, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(4, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(5, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(6, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(7, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(8, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(9, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(10, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(11, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(12, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(13, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(14, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(15, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(16, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(17, "Chandu", "949323", "Hyd"));
    	employeeList.add(new Employee(18, "Chandu", "949323", "Hyd"));
    	
        return employeeList;
    }
}