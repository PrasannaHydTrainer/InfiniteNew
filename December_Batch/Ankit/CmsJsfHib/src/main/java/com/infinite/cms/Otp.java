package com.infinite.cms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Otp")
@ManagedBean(name="otp")
@SessionScoped
public class Otp {

	@Id 
	@Column(name="OtpId")
	private int otpId;
	
	@Column(name="UserName")
	private String userName;

	@Column(name="OtpNo")
	private long otpNo;
	
	@Column(name="attempts")
	private int attempts;
	
	@Column(name="status")
	private String status;
	
	@Column(name="npassword")
	private String npassword;

	public String getNpassword() {
		return npassword;
	}

	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}

	public int getOtpId() {
		return otpId;
	}

	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getOtpNo() {
		return otpNo;
	}

	public void setOtpNo(long otpNo) {
		this.otpNo = otpNo;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Otp [otpId=" + otpId + ", userName=" + userName + ", otpNo=" + otpNo + ", attempts=" + attempts
				+ ", status=" + status + "]";
	}
	
}
