package com.java.lms;

import java.util.Date;
import java.util.List;

public class LeaveDetailsBAL {

	static StringBuilder sb;
	static LeaveDetailsDAO dao;
	
	static {
		sb = new StringBuilder();
		dao = new LeaveDetailsDAO();
	}
	
	public LeaveDetails searchLeaveBal(int leaveId) {
		return dao.searchLeaveDao(leaveId);
	}
	
	public List<LeaveDetails> showLeavesBal() {
		return dao.showLeavesDao();
	}
	
	public String addLeaveBal(LeaveDetails leave) throws LeaveDetailsException {
		if (isValid(leave)==true) {
			return dao.addLeaveDao(leave);
		}
		throw new LeaveDetailsException(sb.toString());
	}
	public boolean isValid(LeaveDetails leave) {
		boolean flag = true;
		Date today = new Date();
		long diff = (long) today.getTime() - leave.getLeaveStartDate().getTime();
		int days = (int)(diff/(1000*60*60*24));
		days++;
		if (days >= 0) {
			sb.append("LeaveStartDate cannot be Yesterday's date...\r\n");
			flag=false;
		}
		
		diff = (long)today.getTime() - leave.getLeaveEndDate().getTime();
		days = (int)(diff/(1000*60*60*24));
		days++;
		if (days >= 0) {
			sb.append("LeaveEndDate Cannot be Yesterday's Date...\r\n");
			flag=false;
		}
		diff =(long)leave.getLeaveEndDate().getTime() - leave.getLeaveStartDate().getTime();
		days = (int)(diff/(1000*24*60*60));
		days++;
		if (days <= 0) {
			sb.append("LeaveStartDate Cannot be Greater Than LeaveEndDate...\r\n");
		}
		if (flag==true) {
			leave.setNoOfDays(days);
		}
		return flag;
	}
}
