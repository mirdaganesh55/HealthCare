package com.java.hib;
//Subadhiiiii

public class AdminLogin {
	
	private int id;
	private String name;
	private String username;
	private String email;
	private String otp;
	private String password;
	private String securityQuestion;
	private String securityAnswer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	@Override
	public String toString() {
		return "AdminLogin [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", otp="
				+ otp + ", password=" + password + ", securityQuestion=" + securityQuestion + ", securityAnswer="
				+ securityAnswer + "]";
	}
	public AdminLogin(int id, String name, String username, String email, String otp, String password,
			String securityQuestion, String securityAnswer) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.otp = otp;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
