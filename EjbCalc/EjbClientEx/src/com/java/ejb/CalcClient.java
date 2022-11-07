package com.java.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ejb.calc.CalcBeanRemote;

public class CalcClient {

	public static void main(String[] args) throws NamingException {
		  CalcBeanRemote service = null;

		    // Context compEnv = (Context) new InitialContext().lookup("java:comp/env");

		    // service = (HelloService)new
		    // InitialContext().lookup("java:comp/env/ejb/HelloService");
		    service = (CalcBeanRemote)
		    		new InitialContext().lookup("CalcBean/remote");
		    System.out.println("Sum is  " +service.sum(12, 5));
		    System.out.println("Sub is  " +service.sub(12, 5));
		    System.out.println("Mult is  " +service.mult(12, 5));
	}
}
