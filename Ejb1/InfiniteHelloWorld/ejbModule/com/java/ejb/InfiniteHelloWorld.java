package com.java.ejb;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class InfiniteHelloWorld
 */
@Stateless
@Remote(InfiniteHelloWorldRemote.class)
public class InfiniteHelloWorld implements InfiniteHelloWorldRemote {

    /**
     * Default constructor. 
     */
    public InfiniteHelloWorld() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Welcome to EJB 3.0 Infinite...";
	}

	@Override
	public String greeting(String name) {
		Date obj = new Date();
		int hr = obj.getHours();
		if (hr < 12) {
			return "Good Morning..." +name;
		} 
		return "Good Evening..." +name;
	}

}
