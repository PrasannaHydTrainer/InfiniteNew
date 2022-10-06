package com.java.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateAccountMain {

	public static void main(String[] args) {
		int accountNo;
		String city,state;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AccountNo  ");
		accountNo = sc.nextInt();
		System.out.println("Enter City    ");
		city = sc.next();
		System.out.println("Enter State ");
		state = sc.next();
		BankDAO dao = new BankDAO();
		try {
			System.out.println(dao.updateAccount(accountNo, city, state));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
