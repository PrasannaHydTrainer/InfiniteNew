package com.java.ejb;

import javax.ejb.Remote;

import java.sql.SQLException;
import java.util.List;

@Remote
public interface EmployBeanRemote {
	List<Employ> showEmployBean() throws ClassNotFoundException, SQLException;
	Employ searchEmployBean(int empno) throws ClassNotFoundException, SQLException;
	String addEmployBean(Employ employ) throws ClassNotFoundException, SQLException;;
	String deleteEmployBean(int empno) throws ClassNotFoundException, SQLException;;
	String updateEmployBean(Employ employ) throws ClassNotFoundException, SQLException;;
}
