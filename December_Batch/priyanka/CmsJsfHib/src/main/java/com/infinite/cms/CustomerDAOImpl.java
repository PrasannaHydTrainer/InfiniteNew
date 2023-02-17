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

	public String addUser(UserTest userTest) {
		String p1=userTest.getFirstName().substring(4);
		String p2 = userTest.getLastName().substring(2);
		String userName = p1+p2;
		userTest.setUserName(userName);
		int otp = generateOtp();
		String otp1 = "";
		otp1=otp1+otp;
		userTest.setOtp(otp1);
		String data="User Name is " +userName + "Your Otp is " +otp1;
		MailSend.sendInfo(userTest.getEmail(), "Your Account Details", data);
		SessionFactory sf = SessionHelper.getConnection();
		Session session =sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(userTest);
		trans.commit();
		return "Thanks.xhtml?faces-redirect=true";		
		
	}
	public static String getAlphaNumericString()
	 {
	 
	  // choose a Character random from this String
	  String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	         + "0123456789"
	         + "abcdefghijklmnopqrstuvxyz";
	 
	  // create StringBuffer size of AlphaNumericString
	  StringBuilder sb = new StringBuilder(10);
	 
	  for (int i = 0; i < 10; i++) {
	 
	   // generate a random number between
	   // 0 to AlphaNumericString variable length
	   int index
	    = (int)(AlphaNumericString.length()
	      * Math.random());
	 
	   // add Character one by one in end of sb
	   sb.append(AlphaNumericString
	      .charAt(index));
	  }
	 
	  return sb.toString();
	 }
	 
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
			String npassword = getAlphaNumericString();
			System.out.println(generateOtp());
			System.out.println("Email is " +email);
			MailSend.sendInfo(email, "Your OTP Generated", "Generated Otp is " +otpNew);
			Transaction tr = session.beginTransaction();
			Otp otp = new Otp();
			otp.setOtpNo(otpNew);
			otp.setNpassword(npassword);
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
