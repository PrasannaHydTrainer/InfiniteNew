package com.java.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorldBean
 */
@Stateless
@Remote(HelloWorldBeanRemote.class)
public class HelloWorldBean implements HelloWorldBeanRemote {

    /**
     * Default constructor. 
     */
    public HelloWorldBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Welcome to EJB Programmig...From Prasanna";
	}

}
