package com.java.ejb;

import javax.naming.InitialContext;

public class MainProg {

	 public static void main(String[] a) throws Exception {
		    HelloWorldRemote service = null;

		    // Context compEnv = (Context) new InitialContext().lookup("java:comp/env");

		    // service = (HelloService)new
		    // InitialContext().lookup("java:comp/env/ejb/HelloService");
		    service = (HelloWorldRemote) new InitialContext().lookup("HelloWorld/remote");

		    System.out.println(service.sayHello());
		  }
}
