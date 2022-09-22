package com.infinite.ex;

public class EmployDemo {

	public static void main(String[] args) {
		Employ employ = new Employ();
		employ.setEmpno(1);
		employ.setName("Madhu");
		employ.setBasic(88234.22);
		
		System.out.println("Employ No  " +employ.getEmpno());
		System.out.println("Employ Name  " +employ.getName());
		System.out.println("Basic   " +employ.getBasic());
	}
}
