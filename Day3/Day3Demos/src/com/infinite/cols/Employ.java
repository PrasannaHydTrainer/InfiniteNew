package com.infinite.cols;

public class Employ {

	int empno;
	String name;
	double basic;
	
	@Override
	public String toString() {
		return "Employ [empno=" + empno + ", name=" + name + ", basic=" + basic + "]";
	}
	
	public Employ(int empno, String name, double basic) {
		this.empno = empno;
		this.name = name;
		this.basic = basic;
	}
	
	public Employ() {
		// TODO Auto-generated constructor stub
	}
}
