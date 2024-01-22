package com.java.hib;
//Subadhiiiii

import java.util.Map;
import java.util.Random;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class AdminLoginImpl implements AdminLoginDAO{
	
	SessionFactory sf;
	Session session;
	
	public static int generateOtp() {
		Random r = new Random(System.currentTimeMillis());
		return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	}

	@Override
	public String adminSignIn(AdminLogin admin) {
		String encr = EncryptPassword.getCode(admin.getPassword());
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(AdminLogin.class);
		cr.add(Restrictions.eq("username", admin.getUsername()));
		cr.setProjection(Projections.rowCount());
		long userNameCount = (long) cr.uniqueResult();
		if(userNameCount > 0) {
			sessionMap.put("passWordErr4", "User Name or Password Already Exist");
			return "SignInAdmin.jsp?faces-redirect=true";
		}
		
		admin.setPassword(encr.trim());
		session.beginTransaction();
		int otp = generateOtp();
		admin.setOtp(String.valueOf(otp));
		session.save(admin);
		session.getTransaction().commit();
		String subject = "Welcome to My app";
		String body = "Welcome to Mr/Miss  " + admin.getName() + "\r\n" + "Your OTP Generated Successfully..."
				+ "\r\n" + "OTP is " + otp;
		MailSend3.mailOtp3(admin.getEmail(), "Otp Send Successfully...", body);
		String useremail=admin.getEmail();
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("email", useremail);
		return "AdminLogin.jsp?faces-redirect=true";	
	}
	
	public String loginDao(AdminLogin adminauth) {
		sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(AdminLogin.class);
		cr.add(Restrictions.eq("username",adminauth.getUsername()));
		cr.add(Restrictions.eq("password",EncryptPassword.getCode(adminauth.getPassword())));
		
		cr.setProjection(Projections.rowCount());
		System.out.println("Called from Logindao "+adminauth);
		long count = (long) cr.uniqueResult();
		
		if(count == 1) {
			String useremail=adminauth.getEmail();
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("email", useremail);
			String username=adminauth.getUsername();
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
			return"Dummy.jsf?faces-redirect=true";
		}
		
		else {
			Map<String,Object> sessionMap =
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("passWordErr3", "Enter a valid UserName and Password.");
		}
		return "";
	}

}
