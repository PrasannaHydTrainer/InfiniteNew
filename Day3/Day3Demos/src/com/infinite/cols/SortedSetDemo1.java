package com.infinite.cols;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo1 {

	public static void main(String[] args) {
		SortedSet names = new TreeSet();
		names.add("Bharvavi");
		names.add("Javed");
		names.add("Akhila");
		names.add("Virdhil");
		names.add("Naveen");
		names.add("Likhitha");
		for (Object ob : names) {
			System.out.println(ob);
		}
	}
}
