package com.infinite.hib;

import java.util.List;

public class Dummy {

	public static void main(String[] args) {
		List<Employ> employList= new EmployDAO().showDepartments("Java", 50000);
	}
}
