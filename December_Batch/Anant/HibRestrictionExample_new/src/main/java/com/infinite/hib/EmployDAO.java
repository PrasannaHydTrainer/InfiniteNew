package com.infinite.hib;

import java.util.List;

public interface EmployDAO {

	List<Employ> showEmployDao();
	String searchEmployDao(int empno);
	String authenticate(Login login);
	String validateMe(Login login);
	String resetPassword(Login login);
}
