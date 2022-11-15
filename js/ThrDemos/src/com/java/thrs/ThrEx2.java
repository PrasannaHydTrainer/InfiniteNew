package com.java.thrs;

import java.util.ArrayList;
import java.util.Vector;

class C2 implements Runnable {

	@Override
	public void run() {
		Vector vector = new Vector();
		vector.add("Bhargavi");
		vector.add("Amrutha");
		vector.add("Vijay");
		vector.add("Lashareef");
		vector.add("Hari Priya");
		for (Object object : vector) {
			System.out.println("Vector   " +object);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
class C1 implements Runnable {

	@Override
	public void run() {
		ArrayList arrList = new ArrayList();
		arrList.add("Sachin");
		arrList.add("Madhu");
		arrList.add("Raghav");
		arrList.add("Swathi");
		arrList.add("Sindhu");
		for (Object object : arrList) {
			System.out.println("ArrayList is  " +object);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
public class ThrEx2 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new C1());
		Thread t2 = new Thread(new C2());
		t1.start();
		t2.start();
	}
}
