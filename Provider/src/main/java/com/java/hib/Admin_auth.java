package com.java.hib;

public class Admin_auth {
	
	private int id;
	private String name;
	private String username;
	private String email;
	private String password;
	private String confirmPassword;
	private String otp;
	

	
	
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Admin_auth(int id, String name, String username, String email, String password, String confirmPassword,
			String otp) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.otp = otp;
	}
	public Admin_auth() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Admin_auth [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", password="
				+ password + ", confirmPassword=" + confirmPassword + ", otp=" + otp + "]";
	}
	
	
	
    

	
	
}
