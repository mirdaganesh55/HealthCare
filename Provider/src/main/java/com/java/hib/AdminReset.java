package com.java.hib;

public class AdminReset 
{
	public String getRetype_password() {
		return retype_password;
	}
	public void setRetype_password(String retype_password) {
		this.retype_password = retype_password;
	}
	private String old_password;
	private String new_password;
	private String retype_password;
	public String getOld_password() {
		return old_password;
	}
	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
	@Override
	public String toString() {
		return "AdminReset [old_password=" + old_password + ", new_password=" + new_password + ", retype_password="
				+ retype_password + "]";
	}
	public AdminReset(String old_password, String new_password, String retype_password) {
		super();
		this.old_password = old_password;
		this.new_password = new_password;
		this.retype_password = retype_password;
	}
	public AdminReset() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
