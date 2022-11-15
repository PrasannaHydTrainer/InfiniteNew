package com.java.thrs;

class Fact extends Thread {
	@Override
	public void run() {
		int f=1;
		for(int i=1;i<=9;i++) {
			f=f*i;
			System.out.println("Factorial   " +f);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Odd extends Thread {
	@Override
	public void run() {
		for(int i=1;i<20;i+=2) {
			System.out.println("Odd   " +i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Even extends Thread {
	@Override
	public void run() {
		for(int i=0;i<20;i+=2) {
			System.out.println("Even  " +i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThrEx {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Even());
		Thread t2 = new Thread(new Odd());
		Thread t3 = new Thread(new Fact());
		
		t1.start();
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t3.start();
	}
}
