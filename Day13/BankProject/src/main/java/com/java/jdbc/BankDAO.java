package com.java.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDAO {

	Connection connection;
	PreparedStatement pst;
	
	public String withdrawAccount(int accountNo, double tranAmount) throws ClassNotFoundException, SQLException {
		Bank bank = searchAccount(accountNo);
		if (bank!=null) {
			connection = ConnectionHelper.getConnection();
			int amount = bank.getAmount();
			if (amount-tranAmount >= 1000) {
				connection = ConnectionHelper.getConnection();
				String cmd = "update bank set amount=Amount-? where AccountNo=?";
				pst = connection.prepareStatement(cmd);
				pst.setDouble(1, tranAmount);
				pst.setInt(2, accountNo);
				pst.executeUpdate();
				cmd = "Insert into Trans(AccountNo,TransAmount,TransType) values(?,?,?)";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, accountNo);
				pst.setDouble(2, tranAmount);
				pst.setString(3, "D");
				pst.executeUpdate();
				return "Amount Debited...";
				
			} else {
				return "Insufficent Funds...";
			}
		}
		return "AccountNo Not Found...";
	}
	public String depositAccount(int accountNo, double tranAmount) throws ClassNotFoundException, SQLException {
		Bank bank = searchAccount(accountNo);
		if (bank!=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "update bank set amount=Amount+? where AccountNo=?";
			pst = connection.prepareStatement(cmd);
			pst.setDouble(1, tranAmount);
			pst.setInt(2, accountNo);
			pst.executeUpdate();
			cmd = "Insert into Trans(AccountNo,TransAmount,TransType) values(?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, accountNo);
			pst.setDouble(2, tranAmount);
			pst.setString(3, "C");
			pst.executeUpdate();
			return "Amount Credited...";
		}
		return "Account No Not Found...";
	}
	
	public String updateAccount(int accountNo, String city, String state) throws ClassNotFoundException, SQLException {
		Bank bank = searchAccount(accountNo);
		if (bank!=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "Update Bank set city=?, State=? where AccountNo=?";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, city);
			pst.setString(2, state);
			pst.setInt(3, accountNo);
			pst.executeUpdate();
			return "Account Updated...";
		}
		return "Account No Not Found...";
	}
	
	public String closeAccount(int accountNo) throws ClassNotFoundException, SQLException {
		Bank bank = searchAccount(accountNo);
		if (bank!=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "update bank set status='inactive' where accountNo=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, accountNo);
			pst.executeUpdate();
			return "Account Closed...";
		}
		return "Account No Not Found...";
	}
	
	public Bank searchAccount(int accountNo) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Bank where AccountNo=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		ResultSet rs = pst.executeQuery();
		Bank bank = null;
		if (rs.next()) {
			bank = new Bank();
			bank.setAccountNo(rs.getInt("accountNo"));
			bank.setFirstName(rs.getString("firstName"));
			bank.setLastName(rs.getString("lastName"));
			bank.setCity(rs.getString("city"));
			bank.setState(rs.getString("state"));
			bank.setAmount(rs.getInt("Amount"));
			bank.setCheqFacil(rs.getString("cheqFacil"));
			bank.setAccountType(rs.getString("AccountType"));
		}
		return bank;
	}
	public String createAccount(Bank bank) 
			throws ClassNotFoundException, SQLException {
		int accountNo = generateAccountNo();
		bank.setAccountNo(accountNo);
		String cmd = "insert into Bank(AccountNo, FirstName, "
				+ "LastName, city,State,Amount, CheqFacil,"
				+ "AccountType) values(?,?,?,?,?,?,?,?)";
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		pst.setString(2, bank.getFirstName());
		pst.setString(3, bank.getLastName());
		pst.setString(4, bank.getCity());
		pst.setString(5, bank.getState());
		pst.setInt(6, bank.getAmount());
		pst.setString(7, bank.getCheqFacil());
		pst.setString(8, bank.getAccountType());
		pst.executeUpdate();
		return "Account Created...";
	}

//	public String createAccount(Bank bank) throws ClassNotFoundException, SQLException {
//		String cmd = "Insert into Bank(AccountNo,FirstName,LastName) values(?,?,?)";
//		connection = ConnectionHelper.getConnection();
//		pst = connection.prepareStatement(cmd);
//		int accno = generateAccountNo();
//		bank.setAccountNo(accno);
//		pst.setInt(1, bank.getAccountNo());
//		pst.setString(2, bank.getFirstName());
//		pst.setString(3, bank.getLastName());
//		pst.executeUpdate();
//		return "Account Created...";
//	}
	public int generateAccountNo() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(accountNo) IS NULL THEN 1 "
				+ " ELSE max(accountNo)+1 end accno from Bank";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int accno = rs.getInt("accno");
		return accno;
	}
}
