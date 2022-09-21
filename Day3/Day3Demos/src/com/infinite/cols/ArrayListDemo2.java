package com.infinite.cols;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		List employList = new ArrayList();
		employList.add(new Employ(1, "Vaishnavi", 84234));
		employList.add(new Employ(2, "Sireesha", 90432));
		employList.add(new Employ(3, "Akhila", 91133));
		employList.add(new Employ(4, "Harshit", 90884));
		employList.add(new Employ(5, "Raghavendra", 92233));
		
		for (Object ob : employList) {
			Employ employ = (Employ)ob;
			System.out.println(employ);
		}
		
	}
}
