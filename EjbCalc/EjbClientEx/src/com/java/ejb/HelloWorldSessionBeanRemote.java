package com.java.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloWorldSessionBeanRemote {
	String sayHello();
}
