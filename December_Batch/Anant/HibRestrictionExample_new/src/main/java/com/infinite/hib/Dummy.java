package com.infinite.hib;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

public class Dummy {

	public static void main(String[] args) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session =sf.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		cr.setProjection(Projections.rowCount());
		Object list = cr.uniqueResult();
		System.out.println("Count is  " +list);
	}
}
