package com.java.hib;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.java.hib.EncryptPassword;

@SessionScoped
public class Admindaoimpl implements Serializable{
	
	SessionFactory sf;
	Session session;

	private String enteredOtp;
	private String enteredAnswers;
	private String enteredOtp1;
	private String enteredOtp2;
	private String enteredOtp3;
	private String enteredOtp4;
	private int numberOfTries = 0;
	
	

	public int getNumberOfTries() {
		return numberOfTries;
	}

	public void setNumberOfTries(int numberOfTries) {
		this.numberOfTries = numberOfTries;
	}

	public String getEnteredOtp() {
		return enteredOtp;
	}

	public void setEnteredOtp(String enteredOtp) {
		this.enteredOtp = enteredOtp;
	}

	public String getEnteredAnswers() {
		return enteredAnswers;
	}

	public void setEnteredAnswers(String enteredAnswers) {
		this.enteredAnswers = enteredAnswers;
	}

	public String getEnteredOtp1() {
		return enteredOtp1;
	}

	public void setEnteredOtp1(String enteredOtp1) {
		this.enteredOtp1 = enteredOtp1;
	}

	public String getEnteredOtp2() {
		return enteredOtp2;
	}

	public void setEnteredOtp2(String enteredOtp2) {
		this.enteredOtp2 = enteredOtp2;
	}

	public String getEnteredOtp3() {
		return enteredOtp3;
	}

	public void setEnteredOtp3(String enteredOtp3) {
		this.enteredOtp3 = enteredOtp3;
	}

	public String getEnteredOtp4() {
		return enteredOtp4;
	}

	public void setEnteredOtp4(String enteredOtp4) {
		this.enteredOtp4 = enteredOtp4;
	}

	public static String generateOtp(int length) {
		String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom secureRandom = new SecureRandom();
		StringBuilder otp = new StringBuilder(6);

		for (int i = 0; i < 4; i++) {
			int randomIndex = secureRandom.nextInt(characters.length());
			char randomChar = characters.charAt(randomIndex);
			otp.append(randomChar);
		}

		return otp.toString();
	}

	public Admin_auth searchadmin(String username) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Admin_auth.class);
		cr.add(Restrictions.eq("username", username));
		Admin_auth adminFound = (Admin_auth) cr.uniqueResult();
		return adminFound;
	}

	private String getLatestOtpForUser(Session session) {
		// Get the patient object from the session map
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Admin_auth admin = (Admin_auth) sessionMap.get("admin");

		if (admin != null) {
			// Retrieve PID from the patient object
			String username = admin.getUsername();
			System.out.println(username);
			Criteria criteria = session.createCriteria(Admin_pass.class);
			criteria.add(Restrictions.eq("username", username));
			criteria.addOrder(Order.desc("id"));
			criteria.setMaxResults(1);

			Admin_pass otp = (Admin_pass) criteria.uniqueResult();

			if (otp != null) {
				return otp.getOtp();
			} else {
				System.out.println("No OTP found for the provided cust_ID: " + username);
				return null;
			}
		} else {
			System.out.println("Admin object not found in the session.");
			return null;
		}
	}

	public String initiateForgotPassword(String username) {
		Admin_auth admin = searchadmin(username);
		System.out.println("========================Initiata "+admin);

		if (username.isEmpty()) {
			System.out.println("Username is null");
			FacesContext.getCurrentInstance().addMessage("form:username", new FacesMessage("Username cannot be empty"));
			return null;
		}

		if (admin != null) { // Generate OTP and save it in the database
			String otp = generateOtp(4);
			Admin_pass login = new Admin_pass();
			login.setUsername(admin.getUsername());
			login.setOtp(otp);
			login.setEmail(admin.getEmail());

			sf = SessionHelper.getConnection();
			session = sf.openSession();
			Transaction trans = session.beginTransaction();
			session.save(login);
			trans.commit();

			String body = "Welcome to Mr/Miss  " + admin.getUsername() + "\r\n"
					+ "Your Otp is Generated Successfully..." + "\r\n" + "Otp is " + otp;
			MailSendTan.mailOtpTa(admin.getEmail(), "Otp Send Succesfully...", body);
			System.out.println(otp);
			Admin_Details admindd = searchuser(username);
//			System.out.println(admindd.getSecurityQuestions());

			// Send OTP to the user's email (implement this logic separately)

			// Store patient object and OTP entity in session map
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("username", username);
			sessionMap.put("admin", admin);
			sessionMap.put("login", login);
			sessionMap.put("admindd", admindd);
			return "AdminverifyOtp.jsp?faces-redirect=true";
		} else if (username.matches("\\d+")) {
			FacesContext.getCurrentInstance().addMessage("form:username",
					new FacesMessage("Userame cannot be numeric"));
			return "Username Numeric";
		} else {

			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("err", "Incorrect Username");
			return "Invalid UHID";
		}
	}

	public String validateResetOtp() {
		String enteredOtp = enteredOtp1 + enteredOtp2 + enteredOtp3 + enteredOtp4;
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		String otpFromDb = getLatestOtpForUser(session);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Admin_pass otpEntity = (Admin_pass) sessionMap.get("login");

		System.out.println(enteredOtp);
		System.out.println(otpFromDb);
		if (enteredOtp.equals(otpFromDb)) {
			System.out.println(otpFromDb);
			System.out.println("Successfully checked");
			return "AdminSecurityInfo.jsp?faces-redirect=true";

		} else {
			System.out.println(" Incorrect Otp Try again");
			FacesContext.getCurrentInstance().addMessage("form:digit1",
					new FacesMessage("Invalid Otp, Please Try again"));
			return "invalid otp";
		}
	}

	public String ChangePassword(String newPassword, String confirmPassword) {

		System.out.println("Value of newPassword: " + newPassword);
		if (newPassword.isEmpty()) {
			System.out.println("New password is null");
			FacesContext.getCurrentInstance().addMessage("form:password",
					new FacesMessage("New password cannot be empty"));
			return null;
		}

		else if (confirmPassword.isEmpty()) {
			System.out.println("Confirm password is null");
			FacesContext.getCurrentInstance().addMessage("form:password",
					new FacesMessage("Confirm password cannot be empty"));
			return null;
		} else if (!newPassword.equals(confirmPassword)) {

			FacesContext.getCurrentInstance().addMessage("form:password",
					new FacesMessage("Password and confirm password do not match"));
			return null; 
		} else if (!(8 <= newPassword.length() && newPassword.length() <= 32)) {
			FacesContext.getCurrentInstance().addMessage("form:password",
					new FacesMessage("Password must be between 8 and 32 characters"));

			return null;
		} else if (!newPassword.matches(".*\\d.*")) {
			FacesContext.getCurrentInstance().addMessage("form:password",
					new FacesMessage("Password must contain at least one number"));

			return null;
		} else if (!newPassword.matches(".*[a-z].*")) {
			FacesContext.getCurrentInstance().addMessage("form:password",
					new FacesMessage("Password must contain at least one lowercase character"));

			return null;
		} else if (!newPassword.matches(".*[A-Z].*")) {
			FacesContext.getCurrentInstance().addMessage("form:password",
					new FacesMessage("Password must contain at least one uppercase character"));

			return null;
		} else if (!newPassword.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*")) {
			FacesContext.getCurrentInstance().addMessage("form:password",
					new FacesMessage("Password must contain at least one special character"));
			return null;
		}

		// Get the patient object and OTP entity from the session map
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Admin_auth admin = (Admin_auth) sessionMap.get("admin");
		Admin_pass otpEntity = (Admin_pass) sessionMap.get("login");
		String encCode = EncryptPassword.getCode(admin.getPassword());
		
		// Check if the entered password matches the confirm password

		// Reset the password
		String pwd = EncryptPassword.getCode(newPassword);
		admin.setPassword(pwd);
		String cpwd = EncryptPassword.getCode(confirmPassword);
		admin.setConfirmPassword(cpwd);
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.update(admin);
		trans.commit();
		session.close();
		// Invalidate OTP to prevent reuse

		return "Sucesspage.jsp?faces-redirect=true";
	}

	private String getSecurityQuestions(Session session) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Admin_Details admin = (Admin_Details) sessionMap.get("admin");

		if (admin != null) {
			String username = admin.getUsername();
			Criteria criteria = session.createCriteria(Admin_Details.class);
			criteria.add(Restrictions.eq("username", username));

			return admin.getSecurityQuestions();
		} else {
			System.out.println("Admin object not found in the session.");
			return null;
		}
	}

	public String validateSecurityInfo(String enteredAnswers) {
		// Get the patient object from the session map
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Admin_auth admin = (Admin_auth) sessionMap.get("admin");
		System.out.println("provider found" + admin.getEmail());
		// Retrieve PID from the patient object
		System.out.println("provider is not null");

		String username = admin.getUsername();
		System.out.println(username);
		// Retrieve provider details from the database using providerid
		Admin_Details adminDetails = searchuser(username);
		System.out.println(adminDetails.getSecurityAnswers());
		// Check if the entered security answers match the stored security answers
		if (adminDetails != null && adminDetails.getSecurityAnswers().equals(enteredAnswers)) {
			System.out.println("this method is hiting");
			return "AdminChangePassword.jsp?faces-redirect=true";
		} else {
			System.out.println("else method is hitting");
			FacesContext.getCurrentInstance().addMessage("form:otp",
					new FacesMessage("Incorrect Answer Try Again"));
			return null;
		}
	}

	public Admin_Details searchuser(String username) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Admin_Details.class);
		cr.add(Restrictions.eq("username", username));
		Admin_Details adminFound = (Admin_Details) cr.uniqueResult();
		return adminFound;
	}

}


