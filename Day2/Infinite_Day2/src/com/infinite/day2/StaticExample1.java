package com.infinite.day2;

public class StaticExample1 {

	int count;
	
	public void increment() {
		count++;
	}
	
	public void show() {
		System.out.println("Count is  " +count);
	}
	public static void main(String[] args) {
		StaticExample1 obj1 = new StaticExample1();
		StaticExample1 obj2 = new StaticExample1();
		StaticExample1 obj3 = new StaticExample1();
		obj1.increment();
		obj2.increment();
		obj3.increment();
		obj1.show();
	}
}
