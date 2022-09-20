package com.infinite.inh;

class C1 {
	C1() {
		System.out.println("C1 class Constructor...");
	}
}

class C2 extends C1 {
	C2() {
		System.out.println("C2 class Constructor...");
	}
}

public class Inhc {
	public static void main(String[] args) {
		new C2();
	}
}
