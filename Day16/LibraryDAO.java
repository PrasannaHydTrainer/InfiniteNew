package com.infinite.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAO {

	public int issueOrNot(String userName, int bookId) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionHelper.getConnection();
		String sql = "select count(*) cnt from TranBook where UserName=? and BookId=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, userName);
		pst.setInt(2, bookId);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int count =rs.getInt("cnt");
		return count;
	}
	
	public List<TranBook> issueBooks(String user) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionHelper.getConnection();
		String sql = "select * from TranBook where UserName=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, user);
		ResultSet rs = pst.executeQuery();
		TranBook tranBook = null;
		List<TranBook> tranBookList = new ArrayList<TranBook>();
		while(rs.next()) {
			tranBook = new TranBook();
			tranBook.setBookId(rs.getInt("BookId"));
			tranBook.setUserName(user);
			tranBook.setFromDate(rs.getDate("FromDate"));
			tranBookList.add(tranBook);
		}
		return tranBookList;
	}
	
	public String issueBook(String userName, int bookId) throws ClassNotFoundException, SQLException {
		int count = issueOrNot(userName, bookId);
		if (count==0) {
			Connection connection = ConnectionHelper.getConnection();
			String sql = "Insert into TranBook(UserName,BookId) values(?,?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setInt(2, bookId);
			pst.executeUpdate();
			sql="Update Books set TotalBooks=TotalBooks-1 where id=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, bookId);
			pst.executeUpdate();
			return "Book with Id " +bookId + " Issued Successfully...";
		} else {
			return "Book Id " +bookId+ " for User " +userName + " Already Issued...";
		}
	}
	public List<Books> searchBooks(String searchType, String searchValue) throws ClassNotFoundException, SQLException {
		String sql;
		boolean isValid=true;
		if(searchType.equals("id")) {
			sql = " SELECT * FROM Books WHERE Id = ? " ;
		} else if(searchType.equals("bookname")) {
			sql = " SELECT * FROM Books WHERE Name = ? " ;
		} else if(searchType.equals("authorname")) {
			sql = " SELECT * FROM Books WHERE Author = ? " ;
		} else if(searchType.equals("dept")) {
			sql = " SELECT * FROM Books WHERE Dept = ? " ;
		}
		else {
			isValid=false;
			sql = " SELECT * FROM Books" ;
		}
		Connection connection = ConnectionHelper.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);
		if (isValid==true) {
			pst.setString(1, searchValue);
		} 
		ResultSet rs = pst.executeQuery();
		Books books = null;
		List<Books> booksList = new ArrayList<Books>();
		while(rs.next()) {
			books = new Books();
			books.setId(rs.getInt("id"));
			books.setName(rs.getString("name"));
			books.setAuthor(rs.getString("author"));
			books.setEdition(rs.getString("edition"));
			books.setDept(rs.getString("dept"));
			books.setNoOfBooks(rs.getInt("TotalBooks"));
			booksList.add(books);
		}
		return booksList;
	}
	public int authenticate(String user, String password) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionHelper.getConnection();
		String cmd="select count(*) cnt from libusers where UserName=?  and Password = ?";
		PreparedStatement pst=connection.prepareStatement(cmd);
		pst.setString(1,user);
		pst.setString(2,password);
		ResultSet rs=pst.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		return count;
	}
}
