package com.infinite.day2;

enum OrderStatus {
	ACCEPTED, REJECTED, PENDING
}

public class EnumEx2 {

	public static void main(String[] args) {
		OrderStatus status = OrderStatus.PENDING;
		System.out.println(status);
		status = OrderStatus.valueOf("REJECTED");
		System.out.println(status);
	}
}
