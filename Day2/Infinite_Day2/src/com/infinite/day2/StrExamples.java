package com.infinite.day2;

public class StrExamples {

	public void show() {
		String str="Welcome to Java Programming...Trainer Prasanna...";
		System.out.println("Lenght of String is  " +str.length());
		System.out.println("First Occurrence of Char 'o' is  " +str.indexOf('o'));
		System.out.println("Char at 5th position  " +str.charAt(5));
		System.out.println("Lower Case  " +str.toLowerCase());
		System.out.println("Upper Case  "+str.toUpperCase());
		String s1="Yeshwanth",s2="Mahendra",s3="Yeshwanth";
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
	}
	public static void main(String[] args) {
		StrExamples obj = new StrExamples();
		obj.show();
	}
}
