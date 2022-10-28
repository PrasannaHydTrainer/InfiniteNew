package com.infinite.hib;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class EmployDAO {

	SessionFactory sessionFactory;
	
	public List<LeaveHistory> pendingLeaves(int mgrId) {
		List<Integer> subOrds = showSubordinates(mgrId);
		sessionFactory = SessionHelper.getSession();
  	    Session session=sessionFactory.openSession();
  	    Query query2 = session.createQuery("from LeaveHistory where leaveStatus='PENDING' AND empId in (:ids)").setParameterList("ids", subOrds);
  	    List<LeaveHistory> pendingLeaves = query2.list();
  	    return pendingLeaves;
	}
	
	public List<Integer> showSubordinates(int mgrId) {
		sessionFactory = SessionHelper.getSession();
  	    Session session=sessionFactory.openSession();
  	    Criteria cr = session.createCriteria(Employee.class);
  	    cr.add(Restrictions.eq("empMgrId", mgrId));
  	    cr.setProjection(Projections.property("empId"));
  	    List<Integer> subList = cr.list();
  	    return subList;
	}
	
	public Employee searchEmploy(int empno) {
		sessionFactory = SessionHelper.getSession();
  	    Session session=sessionFactory.openSession();  
		Query query = session.getNamedQuery("searchEmploy");
		query.setParameter("empno",empno);   
		List<Employee> employList = query.list();
		if (employList.size()==0) {
			return null;
		} 
		return employList.get(0);
	}
	
	public List<Employee> showEmploy() {
		sessionFactory = SessionHelper.getSession();
  	    Session session=sessionFactory.openSession();  
		Query query = session.getNamedQuery("showEmploy");
		List<Employee> employList = query.list();
		return employList;
	}

}
