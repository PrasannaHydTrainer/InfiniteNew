package com.java.thrs;

class Data {
	synchronized void showMsg(String name) {
		System.out.print("Hello " +name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" How are u...");
	}
}

class Sandhya implements Runnable{

	Data data;
	
	Sandhya(Data data) {
		this.data = data;
	}
	@Override
	public void run() {
		data.showMsg("Sandhya");
	}
	
}

class Harshit implements Runnable  {

	Data data;
	
	Harshit(Data data) {
		this.data = data;
	}
	@Override
	public void run() {
		data.showMsg("Harshit");
	}
	
}
class Gaurav implements Runnable {

	Data data;
	Gaurav(Data data) {
		this.data = data;
	}
	@Override
	public void run() {
		data.showMsg("Gaurav");
	}
	
}
public class SyncEx {
	public static void main(String[] args) {
		Data data = new Data();
		Gaurav gaurav = new Gaurav(data);
		Sandhya sandhya = new Sandhya(data);
		Harshit harshit = new Harshit(data);
		
		Thread t1 = new Thread(gaurav);
		Thread t2 = new Thread(harshit);
		Thread t3 = new Thread(sandhya);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
