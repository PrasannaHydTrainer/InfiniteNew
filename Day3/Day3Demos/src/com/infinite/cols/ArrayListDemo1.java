package com.infinite.cols;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo1 {

	public static void main(String[] args) {
		List names = new ArrayList();
		names.add("Kishore");
		names.add("Sireesha");
		names.add("Hari Priya");
		names.add("Sachin");
		names.add("Vaishnavi");
		System.out.println("Names are  ");
		for (Object ob : names) {
			System.out.println(ob);
		}
	}
}
