package com.infinite.hib;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Dummy2 {

	public static void main(String[] args) {
		String encr = EntryptPassword.getCode("attar");
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", "avesh"));
		cr.add(Restrictions.eq("passCode", encr.trim()));
		cr.setProjection(Projections.rowCount());
		Object list = cr.uniqueResult();
		System.out.println("Count is  " +list);
	}
}
