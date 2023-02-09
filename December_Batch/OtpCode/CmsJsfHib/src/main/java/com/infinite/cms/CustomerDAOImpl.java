package com.infinite.cms;

import java.util.Map;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


@ManagedBean(name="cDao")
@SessionScoped
public class CustomerDAOImpl implements CustomerDAO {

	public static int generateOtp() {
		Random r = new Random( System.currentTimeMillis() );
	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
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
	
	public long otpGenerate(String userName) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Otp.class);
		cr.add(Restrictions.eq("userName", userName));
		cr.setProjection(Projections.rowCount());
		long  count =(Long)cr.uniqueResult();
		System.out.println(count);
		return count;
	}

	@Override
	public String validateMe(Customer customer) {
		String encr = EntryptPassword.getCode(customer.getCustPassword());
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		System.out.println(customer);
		Customer customerFound = searchByCustomerUser(customer.getCustUserName());
		String email = customerFound.getCustEmail();
		Criteria cr = session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("custUserName", customer.getCustUserName()));
		cr.add(Restrictions.eq("custPassword", encr.trim()));
		cr.setProjection(Projections.rowCount());
		long  count =(Long)cr.uniqueResult();
		System.out.println(count);
		System.out.println("Otp Count " +otpGenerate(customer.getCustUserName()));
		long otpCount = otpGenerate(customer.getCustUserName());
		if (otpCount==0) {
			long otpNew = generateOtp();
			System.out.println(generateOtp());
			System.out.println("Email is " +email);
			MailSend.sendInfo(email, "Your OTP Generated", "Generated Otp is " +otpNew);
			Transaction tr = session.beginTransaction();
			Otp otp = new Otp();
			otp.setOtpNo(otpNew);
			otp.setUserName(customer.getCustUserName());
			otp.setAttempts(1);
			otp.setStatus("ACTIVE");
			session.save(otp);
			tr.commit();
			return "OtpCheck.xhtml?faces-redirect=true";
		}
		if (count==1) {
			Customer c = searchByCustomerUser(customer.getCustUserName());
			//sessionMap.put("cname", c.getCustName());
			sessionMap.put("customerInfo", c);
			MailSend.sendInfo("prasanna.trainer@gmail.com", "Confirmation", "You are Loggeed In");
			return "CustomerDashBoard.xhtml?faces-redirect=true";			
		} else {
			sessionMap.put("error", "Invalid Credentials...");
			return "CustsomerLogin.xhtml?faces-redirect=true";
		}

	}

	@Override
	public Customer searchByCustomerUser(String userName) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session =sf.openSession();
		Criteria cr = session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("custUserName", userName));
		Customer customer = (Customer)cr.uniqueResult();
		return customer;
	}

}
