package com.infinite.ex;

public class ArrEx {

	public static void main(String[] args) {
		int[] a= {12,45};
		try {
			a[10]=90;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Size is Small...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
