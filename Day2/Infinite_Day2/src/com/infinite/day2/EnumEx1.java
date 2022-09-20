package com.infinite.day2;

enum WeekDays {
	SUNDAY, MONDAY, TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY
}
public class EnumEx1 {
	public static void main(String[] args) {
		WeekDays wd = WeekDays.TUESDAY;
		System.out.println(wd);
		String str = "FRIDAY";
		wd = WeekDays.valueOf(str);
		System.out.println(wd);
	}
}
