package com.infinite.cols;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortEmploy {

	public static void main(String[] args) {
		//Comparator c = new NameComparator();
		Comparator c = new BasicComparator();
		SortedSet employList = new TreeSet(c);
		employList.add(new Employ(1, "Vaishnavi", 84234));
		employList.add(new Employ(2, "Sireesha", 83223));
		employList.add(new Employ(3, "Akhila", 91133));
		employList.add(new Employ(4, "Harshit", 90884));
		employList.add(new Employ(5, "Raghavendra", 87233));
		for (Object object : employList) {
			Employ employ = (Employ)object;
			System.out.println(employ);
		}
	}
}
