package com.infinite.intf;

interface ITraining {
	void name();
	void email();
}

class Kishore implements ITraining {

	@Override
	public void name() {
		System.out.println("Name is Kishore...");
	}

	@Override
	public void email() {
		System.out.println("Email is kishore@gmail.com");
	}
	
}
class Vardhil implements ITraining {

	@Override
	public void name() {
		System.out.println("Name is Vardhil...");
	}

	@Override
	public void email() {
		System.out.println("Email is vardhil@gmail.com");
	}
	
}
public class IntfDemo {
	public static void main(String[] args) {
		ITraining[] arr = new ITraining[] {
			new Vardhil(), new Kishore()	
		};
		for (ITraining i : arr) {
			i.name();
			i.email();
		}
	}
}
