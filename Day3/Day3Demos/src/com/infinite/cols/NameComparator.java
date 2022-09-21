package com.infinite.cols;

import java.util.Comparator;

public class NameComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Employ e1 = (Employ)o1;
		Employ e2 = (Employ)o2;
		return e1.name.compareTo(e2.name);
	}

}
