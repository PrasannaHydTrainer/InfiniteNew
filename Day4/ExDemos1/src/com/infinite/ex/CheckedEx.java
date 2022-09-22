package com.infinite.ex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckedEx {

	public void show(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = sdf.parse(str);
		System.out.println(dt);
	}
	public static void main(String[] args) {
		String str="2022-09-22";
		CheckedEx obj= new CheckedEx();
		try {
			obj.show(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
