package com.java.hib;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Controller 
{
	private AdminReset adminreset = new AdminReset();
	private AdminResetDaoImpl daoimpl = new AdminResetDaoImpl();
	public AdminReset getAdminreset() {
		return adminreset;
	}
	public void setAdminreset(AdminReset adminreset) {
		this.adminreset = adminreset;
	}
	public AdminResetDaoImpl getDaoimpl() {
		return daoimpl;
	}
	public void setDaoimpl(AdminResetDaoImpl daoimpl) {
		this.daoimpl = daoimpl;
	}
	public boolean addvalid(AdminReset admin)
	{		FacesContext context = FacesContext.getCurrentInstance();
			//String oldpass = "^(?!/s*$).*";
			String newpassword="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{8,}$";
			if (!Pattern.matches(newpassword, admin.getNew_password())) {
			    String errorMessage = "At least 8 characters.\n"
			                        + "Contains at least one uppercase letter.\n"
			                        + "Contains at least one lowercase letter.\n"
			                        + "Contains at least one digit (0-9).\n"
			                        + "May contain special characters.";

			    context.addMessage("form:newpassword", new FacesMessage(errorMessage));
			    return false;
			}
			if(admin.getOld_password().equals(admin.getNew_password()))
			{
				context.addMessage("form:newpassword", new FacesMessage("Old Password and New Password cannot same "));
				return false;
			}
			return true;
	}
	public String addAdminReset(AdminReset adminreset)
	{
		if(addvalid(adminreset))
		{
			return daoimpl.addAdminResetDao(adminreset);
		}
		return "";
	}
	}

