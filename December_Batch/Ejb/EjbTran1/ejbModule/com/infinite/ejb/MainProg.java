package com.infinite.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MainProg {

	public static void main(String[] args) {
		EmployEmployNewBeanRemote service;
		try {
			service = (EmployEmployNewBeanRemote)
					new InitialContext().lookup("EmployeeService");
			Employ employ = new Employ();
			employ.setName("xyz");
			employ.setDept("Java");
			employ.setDesig("Prog");
			employ.setBasic(94922);
			System.out.println(service.addEmployDao(employ));

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
