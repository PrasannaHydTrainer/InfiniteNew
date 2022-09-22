package com.infinite.employproject;

import java.util.ArrayList;
import java.util.List;

public class EmployDAO {

	static List<Employ> employList;
	
	static {
		employList = new ArrayList<Employ>();
	}
	
	public List<Employ> showEmployDao() {
		return employList;
	}
	
	public String addEmployDao(Employ employ) {
		employList.add(employ);
		return "Employ Record Inserted...";
	}
}
