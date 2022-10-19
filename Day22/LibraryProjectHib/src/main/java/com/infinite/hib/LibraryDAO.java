package com.infinite.hib;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class LibraryDAO {

	SessionFactory sessionFactory;
	
	public String isseuBook(TranBook tranBook) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		if (issueOrNot(tranBook.getBookId())==1) {
			return "Book with id " +tranBook.getBookId() + " Already issued...";
		} 
		Transaction tran = session.beginTransaction();
		session.save(tranBook);
		tran.commit();
		session.close();
		session = sessionFactory.openSession();
		Books book = searchById(tranBook.getBookId());
		book.setTotalBooks(book.getTotalBooks()-1);
		tran=session.beginTransaction();
		session.saveOrUpdate(book);
		tran.commit();
		return "Book with Id " +tranBook.getBookId() + " Issued Successfully...";
	}
	public int issueOrNot(int bookId) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(TranBook.class);
		cr.add(Restrictions.eq("bookId", bookId));
		return cr.list().size();
	}
	public List<Books> searchBooks(String searchtype, String searchvalue) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(Books.class);
		if (searchtype.equals("id")) {
			int id =Integer.parseInt(searchvalue);
			cr.add(Restrictions.eq("id", id));
		} 
		if (searchtype.equalsIgnoreCase("dept")) {
			cr.add(Restrictions.eq("dept", searchvalue));
		}
		if (searchtype.equalsIgnoreCase("bookname")) {
			cr.add(Restrictions.eq("name", searchvalue));
		}
		if (searchtype.equalsIgnoreCase("authorname")) {
			cr.add(Restrictions.eq("author", searchvalue));
		}
		List<Books> lst = cr.list();
		return lst;
	}

	public Books searchById(int id) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(Books.class);
			cr.add(Restrictions.eq("id", id));
		List<Books> booksList = cr.list();
		return booksList.get(0);
	}

	public int loginCheck(String userName, String passWord) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(LibUsers.class);
		cr.add(Restrictions.eq("userName", userName));
		cr.add(Restrictions.eq("passWord", passWord));
		List<LibUsers> listUsers = cr.list();
		return listUsers.size();
	}
}
