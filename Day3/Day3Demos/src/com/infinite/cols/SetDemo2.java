package com.infinite.cols;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo2 {

	public static void main(String[] args) {
		Set names = new LinkedHashSet();
		names.add("Bharvavi");
		names.add("Javed");
		names.add("Akhila");
		names.add("Virdhil");
		names.add("Naveen");
		names.add("Likhitha");
		names.add("Bharvavi");
		names.add("Javed");
		names.add("Akhila");
		names.add("Virdhil");
		names.add("Naveen");
		names.add("Likhitha");
		names.add("Bharvavi");
		names.add("Javed");
		names.add("Akhila");
		names.add("Virdhil");
		names.add("Naveen");
		names.add("Likhitha");
		names.add("Bharvavi");
		names.add("Javed");
		names.add("Akhila");
		names.add("Virdhil");
		names.add("Naveen");
		for (Object obj : names) {
			System.out.println(obj);
		}
	}
}
