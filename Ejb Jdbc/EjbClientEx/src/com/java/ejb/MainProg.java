package com.java.ejb;

import javax.naming.InitialContext;

public class MainProg {
	 public static void main(String[] a) throws Exception {
		   HelloWorldSessionBeanRemote service = null;

		    // Context compEnv = (Context) new InitialContext().lookup("java:comp/env");

		    // service = (HelloService)new
		    // InitialContext().lookup("java:comp/env/ejb/HelloService");
		    service = (HelloWorldSessionBeanRemote)
		    		new InitialContext().lookup("HelloWorldSessionBean/remote");

		    System.out.println(service.sayHello());
		  }

}
