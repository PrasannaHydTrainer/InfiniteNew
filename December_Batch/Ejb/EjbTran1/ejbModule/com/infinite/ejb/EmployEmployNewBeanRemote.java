package com.infinite.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface EmployEmployNewBeanRemote {
	String addEmployDao(Employ employ);
}
