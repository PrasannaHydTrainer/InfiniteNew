package com.infinite.junit;

public class Data {

	public boolean evenOdd(int n) {
		if (n%2==0) {
			return true;
		}
		return false;
	}
	
	public int sum(int a, int b) {
		return a+b;
	}
	
	public int max3(int a, int b, int c) {
		int m=a;
		if (m < b) {
			m=b;
		}
		if (m < c) {
			m=c;
		}
		return m;
	}
	
	public String sayHello() {
		return "Welcome to Junit...";
	}
}
