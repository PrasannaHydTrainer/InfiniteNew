package com.infinite.hib;


import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name="eDao")
@SessionScoped
public class EmployDaoImpl implements EmployDAO {
	
	@Override
	public List<Employ> showEmployDao() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		cr.addOrder(Order.asc("basic"));
		List<Employ> employList = cr.list();
		return employList;
	}

	public List<Employ> getEmployListByDept(String dept) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		cr.add(Restrictions.eq("dept", dept));
		List<Employ> employList = cr.list();
		return employList;
	}
	public List<String> getDepartments() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		Projection projection = Projections.distinct(Projections.property("dept")); 
		cr.setProjection(projection); 
		List<String> list = cr.list();
		return list;
	}
	private String localCode;
	
	public String getLocalCode() {
		return localCode;
	}
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	public void employLocaleCodeChanged(ValueChangeEvent e){
		//assign new value to localeCode
		this.localCode = e.getNewValue().toString();
	}
	public List<String> getNames() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		Projection projection = Projections.property("name"); 
		cr.setProjection(projection); 
		List<String> list = cr.list();
		return list;
	}
	@Override
	public String searchEmployDao(int empno) {
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employ.class);
		cr.add(Restrictions.eq("empno", empno));
		List<Employ> employList = cr.list();
		Employ employ = employList.get(0);
        sessionMap.put("editEmploy", employ);
		return "UpdateEmploy.xhtml?faces-redirect=true";
	}

	@Override
	public String authenticate(Login login) {
		String encr = EntryptPassword.getCode(login.getPassCode());
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", login.getUserName()));
		cr.add(Restrictions.eq("passCode", encr.trim()));
		List<Login> loginList = cr.list();
		System.out.println("Records are " +loginList.size());
		if (loginList.size()==1) {
			return "EmployShow.xhtml?faces-redirect=true";			
		} else {
			sessionMap.put("error", "Invalid Credentials...");
			return "Login.xhtml?faces-redirect=true";
		}
	}

	@Override
	public String validateMe(Login login) {
		String encr = EntryptPassword.getCode(login.getPassCode());
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", login.getUserName()));
		cr.add(Restrictions.eq("passCode", encr.trim()));
		cr.setProjection(Projections.rowCount());
		long  count =(Long)cr.uniqueResult();
		if (count==1) {
			return "EmployShow.xhtml?faces-redirect=true";			
		} else {
			sessionMap.put("error", "Invalid Credentials...");
			return "Login.xhtml?faces-redirect=true";
		}
	}

	@Override
	public String resetPassword(Login login) {
		String encr = EntryptPassword.getCode(login.getPassCode());
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Login.class);
		cr.add(Restrictions.eq("userName", login.getUserName()));
//		cr.add(Restrictions.eq("passCode", encr.trim()));
		cr.setProjection(Projections.rowCount());
		long  count =(Long)cr.uniqueResult();
		if (count==1) {
			Criteria cr1 = session.createCriteria(LoginHistory.class);
			cr1.add(Restrictions.eq("userName", login.getUserName()));
			cr1.add(Restrictions.eq("passCode", encr.trim()));
			System.out.println(login.getUserName());
			System.out.println(encr.trim());
			System.out.println(login);
			cr1.setProjection(Projections.rowCount());
			System.out.println(cr1.list().size());
			long count1 = (long)cr1.uniqueResult();
		//	long count1=1;
			if (count1==1) {
				sessionMap.put("error", "Your password cannot be same as old password...");
				return "ResetPassword.xhtml?faces-redirect=true";				
			} else {
				Transaction tran = session.beginTransaction();
				LoginHistory history = new LoginHistory();
				history.setUserName(login.getUserName());
				history.setPassCode(encr);
				session.save(history);
				login.setPassCode(encr);
				session.update(login);
				tran.commit();
				sessionMap.put("success", "Your Password Successfully Changed...");
				return "Thanks.xhtml?faces-redirect=true";
			}
		}
		return "Login.xhtml?faces-redirect=true";
	}
}
