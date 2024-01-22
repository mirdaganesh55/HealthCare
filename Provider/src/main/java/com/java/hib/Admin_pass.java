package com.java.hib;

public class Admin_pass {
	private int id;
	private String username;
	private String email;
	private String otp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "Admin_pass [id=" + id + ", username=" + username + ", email=" + email + ", otp=" + otp + "]";
	}
	public Admin_pass(int id, String username, String email, String otp) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.otp = otp;
	}
	public Admin_pass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
