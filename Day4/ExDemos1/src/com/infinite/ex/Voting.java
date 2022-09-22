package com.infinite.ex;

import java.util.Scanner;

public class Voting {

	public void check(int age) throws VotingException {
		if (age < 18) {
			throw new VotingException("You are not Elligible for voting...");
		} else {
			System.out.println("You can vote...");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Age   ");
		int age = sc.nextInt();
		Voting obj = new Voting();
		try {
			obj.check(age);
		} catch (VotingException e) {
			e.printStackTrace();
		}
	}
}
