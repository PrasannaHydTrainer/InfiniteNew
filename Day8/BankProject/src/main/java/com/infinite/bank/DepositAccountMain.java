package com.infinite.bank;

import java.sql.SQLException;
import java.util.Scanner;

public class DepositAccountMain {

	public static void main(String[] args) {
		int accountNo;
		double depositAmount;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AccountNo   ");
		accountNo=sc.nextInt();
		System.out.println("Enter Deposit Amount  ");
		depositAmount = sc.nextDouble();
		BankDAO dao = new BankDAO();
		try {
			System.out.println(dao.depositAccount(accountNo, depositAmount));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
