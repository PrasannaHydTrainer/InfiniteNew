package com.infinite.sup;

class Employ {
	
	int empno;
	String name;
	double basic;
	
	public Employ(int empno, String name, double basic) {
		this.empno = empno;
		this.name = name;
		this.basic = basic;
	}

	@Override
	public String toString() {
		return "Employ [empno=" + empno + ", name=" + name + ", basic=" + basic + "]";
	}
	
}

class Bhagya extends Employ {

	public Bhagya(int empno, String name, double basic) {
		super(empno, name, basic);
		// TODO Auto-generated constructor stub
	}
	
}


public class SupCon {
	public static void main(String[] args) {
		Bhagya obj = new Bhagya(1, "Bhagya", 99423);
		System.out.println(obj);
	}
}
