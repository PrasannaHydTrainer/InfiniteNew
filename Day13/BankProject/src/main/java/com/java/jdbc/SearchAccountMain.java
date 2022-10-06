package com.java.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class SearchAccountMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int accountNo;
		System.out.println("Enter AccountNo  ");
		accountNo = sc.nextInt();
		try {
			Bank bank = new BankDAO().searchAccount(accountNo);
			System.out.println(bank);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
