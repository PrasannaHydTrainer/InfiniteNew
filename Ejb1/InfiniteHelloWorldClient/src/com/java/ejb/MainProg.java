package com.java.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MainProg {

	public static void main(String[] args) throws NamingException {
		  InfiniteHelloWorldRemote service = null;
		    service = 
		    	(InfiniteHelloWorldRemote) 
		    	new InitialContext().lookup("InfiniteHelloWorld/remote");

		    System.out.println(service.sayHello());
	}
}
