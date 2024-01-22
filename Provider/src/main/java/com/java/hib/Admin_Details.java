package com.java.hib;

public class Admin_Details {
	private int id;
	private String name;
	private String username;
	private String email;
	private String securityQuestions;
    private String securityAnswers;
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
	public String getSecurityQuestions() {
		return securityQuestions;
	}
	public void setSecurityQuestions(String securityQuestions) {
		this.securityQuestions = securityQuestions;
	}
	public String getSecurityAnswers() {
		return securityAnswers;
	}
	public void setSecurityAnswers(String securityAnswers) {
		this.securityAnswers = securityAnswers;
	}
	@Override
	public String toString() {
		return "Admin_Details [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email
				+ ", securityQuestions=" + securityQuestions + ", securityAnswers=" + securityAnswers + "]";
	}
	public Admin_Details(int id, String name, String username, String email, String securityQuestions,
			String securityAnswers) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.securityQuestions = securityQuestions;
		this.securityAnswers = securityAnswers;
	}
	public Admin_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
