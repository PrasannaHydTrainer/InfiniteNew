package com.infinite.cms;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@ManagedBean(name="cDao")
@SessionScoped
public class CustomerDAOImpl implements CustomerDAO {

	private String[] issues;
	
	public String[] getIssues() {
		return issues;
	}

	public void setIssues(String[] issues) {
		this.issues = issues;
	}

	@Override
	public String addCustomerDao(Customer customer) {
		String pwd = EntryptPassword.getCode(customer.getCustPassword());
		customer.setCustPassword(pwd);
		SessionFactory sf = SessionHelper.getConnection();
		Session session =sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(customer);
		trans.commit();
		return "Thanks.xhtml?faces-redirect=true";		
	}

	@Override
	public Health showHistory() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session =sf.openSession();
		Query query = session.createQuery("from Health");
		Health list = (Health)query.uniqueResult();
		String str=list.getDiseasesCovered();
		//System.out.println(str);
		String[] test = str.split(",");
		issues = test;
		for (String s : test) {
			System.out.println(s);
		}
		return list;
	}

}
