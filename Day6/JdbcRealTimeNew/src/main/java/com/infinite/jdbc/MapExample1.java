package com.infinite.jdbc;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class MapExample1 {

	public static void main(String[] args) {
		Map<Integer, String> data = new Hashtable<Integer, String>();
		data.put(1, "Kusuma");
		data.put(2, "Harshit");
		data.put(3, "Rahul");
		data.put(4, "Sachin");
		data.put(5, "Usha");
		int key;
		String result;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Key (empno)  ");
		key = sc.nextInt();
		result = data.getOrDefault(key, "Not Found");
		System.out.println(result);
	}
}
