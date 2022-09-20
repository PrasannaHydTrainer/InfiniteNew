package com.infinite.day2;

public class EmpArray {

	public static void main(String[] args) {
		Emp[] arr = new Emp[] {
			new Emp(1, "Sai Kamala",84382),
			new Emp(2,"Kishore",88223),
			new Emp(3,"Madhenu",88321),
			new Emp(4,"Lashareef",88224)
		};
		
		for (Emp emp : arr) {
			System.out.println(emp);
		}
	}
}

