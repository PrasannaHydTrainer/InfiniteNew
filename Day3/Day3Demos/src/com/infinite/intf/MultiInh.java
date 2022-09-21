package com.infinite.intf;

interface IOne {
	void name();
}

interface ITwo {
	void email();
}

class Madhu implements IOne, ITwo {

	@Override
	public void email() {
		System.out.println("Email is madhu@gmail.com");
	}

	@Override
	public void name() {
		System.out.println("Name is Madhu...");
	}
	
}
public class MultiInh {
	public static void main(String[] args) {
		Madhu obj = new Madhu();
		obj.name();
		obj.email();
	}
}
