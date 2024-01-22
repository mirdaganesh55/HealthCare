package com.java.hib;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class AdminResetDaoImpl implements AdminResetDAO
{
	SessionFactory sf;
	Session session;
	@Override
	public String addAdminResetDao(AdminReset adminreset) 
	{
	    if (checkPassword(adminreset)) 
	    {
	        if (checkfield(adminreset)) 
	        {
	        	System.out.println("================If Reset===================="+adminreset);
	        	String mailpass = adminreset.getNew_password();
	            String newEncryptedPassword = EncryptPassword.getCode(adminreset.getNew_password());
	            adminreset.setNew_password(newEncryptedPassword);
	            sf = SessionHelper.getConnection();
	            session = sf.openSession();
	            Transaction trans = session.beginTransaction();
	            String username = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
	            Admin_auth adminAuth = (Admin_auth) session.createCriteria(Admin_auth.class)
	                .add(Restrictions.eq("username", username))
	                .uniqueResult();  
	       
	            if (adminAuth != null) 
	            {
	            	System.out.println("===============If AdminAuth================="+adminAuth);
	            	String oldpass = adminAuth.getPassword();
	            	adminreset.setNew_password(newEncryptedPassword);
	            	adminreset.setOld_password(oldpass);
	                adminAuth.setPassword(newEncryptedPassword);
	                session.update(adminAuth);
	                session.save(adminreset);
	                trans.commit();
	                System.out.println("Hii");
	                String email = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("email");
	        		String body = "Welcome to Mr/Miss  " + username + "\r\n" + "Newpassword is " +mailpass;
	        		MailSendSiri.mailOtpSiri(email, "Password has been updated successfully", body);
	        		 FacesContext context = FacesContext.getCurrentInstance();
	        		 context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "Password reset successfully."));
	        		return "AdminLogin.jsp?faces-redirect=true";
	            } 
	            
	            else 
	            {
	            	System.out.println("=============== Else ================"+adminAuth);
	                FacesContext context = FacesContext.getCurrentInstance();
	                context.addMessage("form:oldpassword", new FacesMessage("User not found"));
	                return "";
	            }
	        }
	        else
	        {
	            FacesContext context = FacesContext.getCurrentInstance();
	            context.addMessage("form:retypepassword", new FacesMessage("Password and Confirm password must be the same"));
	            return "";
	        }
	    } else {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage("form:oldpassword", new FacesMessage("Enter your old password correctly "));
	        return "";
	    }
	}
	public boolean checkPassword(AdminReset adminReset) 
	{
	    sf = SessionHelper.getConnection();
	    Session session = sf.openSession();
	    String oldpwd = EncryptPassword.getCode(adminReset.getOld_password());
	    Criteria cr = session.createCriteria(Admin_auth.class);
	    cr.add(Restrictions.eq("password", oldpwd));
	    List<Admin_auth> results = cr.list();
	    if (results != null && !results.isEmpty()) {
	        return true; 
	    } else {
	        return false;
	    }
	}
	public boolean checkfield(AdminReset obj)
	{
		sf=SessionHelper.getConnection();
		Session session=sf.openSession();
		if(obj.getNew_password().equals(obj.getRetype_password()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
