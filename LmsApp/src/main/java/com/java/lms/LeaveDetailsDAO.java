package com.java.lms;

import java.util.ArrayList;
import java.util.List;

public class LeaveDetailsDAO {

	static List<LeaveDetails> listLeaveDetails;
	
	static {
		listLeaveDetails = new ArrayList<LeaveDetails>();
	}
	
	public LeaveDetails searchLeaveDao(int leaveId) {
		LeaveDetails leaveFound = null;
		for (LeaveDetails leaveDetails : listLeaveDetails) {
			if (leaveDetails.getLeaveId()==leaveId) {
				leaveFound = leaveDetails;
				break;
			}
		}
		return leaveFound;
	}
	
	public List<LeaveDetails> showLeavesDao() {
		return listLeaveDetails;
	}

	public int generateLeaveId() {
		int leaveId=0;
		if (listLeaveDetails.isEmpty()) {
			leaveId=1;
			return leaveId;
		} else {
			for (LeaveDetails ld : listLeaveDetails) {
				leaveId= ld.getLeaveId();
			}
		}
		leaveId++;
		return leaveId;
	}
	public String addLeaveDao(LeaveDetails leave) {
		int leaveId = generateLeaveId();
		leave.setLeaveId(leaveId);
		listLeaveDetails.add(leave);
		return "Leave Record Inserted...";
	}
}
