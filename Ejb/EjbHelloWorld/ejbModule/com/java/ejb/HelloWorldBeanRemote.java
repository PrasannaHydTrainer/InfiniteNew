package com.java.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloWorldBeanRemote {

	String sayHello();
}
