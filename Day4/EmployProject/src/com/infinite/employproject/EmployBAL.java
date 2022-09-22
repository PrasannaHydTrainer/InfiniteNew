package com.infinite.employproject;

import java.util.List;

public class EmployBAL {

	static StringBuilder sb = new StringBuilder();
	
	static EmployDAO dao = new EmployDAO();
	
	public List<Employ> showEmployBal() {
		return dao.showEmployDao();
	}
	public String addEmployBal(Employ employ) throws EmployException {
		if (isValid(employ)==false) {
			throw new EmployException(sb.toString());
		}
		return dao.addEmployDao(employ);
	}
	
	public boolean isValid(Employ employ) {
		boolean valid=true;
		if (employ.getEmpno() <= 0) {
			valid=false;
			sb.append("Employ no cannot be negative or zero...\r\n");
		}
		if (employ.getName().length() < 6) {
			valid=false;
			sb.append("Employ Name contains min. 5 chars...\r\n");
		}
		if (employ.getDept().length() < 4) {
			valid = false;
			sb.append("Employ Dept contains min 3 characters...\r\n");
		}
		if (employ.getDesig().length() < 5) {
			valid=false;
			sb.append("Employ Desig contains min 4 characters...\r\n");
		}
		if (employ.getBasic() < 5000 || employ.getBasic() > 80000) {
			valid=false;
			sb.append("Employ Basic must be between 5000 to 80000...\r\n");
		}
		return valid;
	}
}
