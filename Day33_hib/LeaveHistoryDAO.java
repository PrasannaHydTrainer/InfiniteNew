package com.infinite.hib;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LeaveHistoryDAO {

	SessionFactory sessionFactory;
	
	public List<LeaveHistory> showLeaveHistory(int empId) {
		sessionFactory = SessionHelper.getSession();
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("leaveHistory");
		query.setParameter("empId",empId);   
		List<LeaveHistory> leaveHistory = query.list();
		return leaveHistory;
	}
}
