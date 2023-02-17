package com.infinite.cms;

import java.util.Random;

public class MainProg {

	public static int otp() {
		Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}
	public static void main(String[] args) {
		 System.out.println(otp());
	}
}
