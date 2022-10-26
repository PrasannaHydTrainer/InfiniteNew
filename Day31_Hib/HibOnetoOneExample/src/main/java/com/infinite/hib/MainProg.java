package com.infinite.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class MainProg {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session =sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employ employ1= new Employ();
		employ1.setName("Murari Bhat");
		employ1.setEmail("Murari@infinite.com");
		
		Address address1 = new Address();
		address1.setAddress1("Jaya Nagar");
		address1.setAddress2("Sulthan Palya");
		address1.setCity("Bangalore");
		address1.setState("KA");
		address1.setZipcode("8472344");
		address1.setCountry("INDIA");
		
		employ1.setAddress(address1);
		address1.setEmploy(employ1);
		
		session.save(employ1);
		transaction.commit();
		session.close();
		System.out.println("Tables Created Successfully...");
	}
}
