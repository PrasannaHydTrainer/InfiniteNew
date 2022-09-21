package com.infinite.abs;

abstract class Training {
	abstract void name();
	abstract void email();
}

class Sindhu extends Training {

	@Override
	void name() {
		System.out.println("Name is Sindhu...");
	}

	@Override
	void email() {
		System.out.println("Email is Sindhu@gmail.com");
	}
	
}
class Javed extends Training {

	@Override
	void name() {
		System.out.println("Name is Javed...");
	}

	@Override
	void email() {
		System.out.println("Email is javed@gmail.com");
	}
	
}
class Yeshwanth extends Training {
	@Override
	void name() {
		System.out.println("Name is Yeswanth...");
	}

	@Override
	void email() {
		System.out.println("Email is yeshwanth@gmail.com");
	}
}
public class AbsDemo {
	public static void main(String[] args) {
//		Training obj1 = new Yeshwanth();
//		Training obj2 =new Sindhu();
//		Training obj3 = new Javed();
		Training[] arr = new Training[] {
			new Yeshwanth(),
			new Sindhu(),
			new Javed()
		};
		for (Training t : arr) {
			t.name();
			t.email();
		}
	}
}
