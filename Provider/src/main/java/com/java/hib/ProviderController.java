//package com.java.hib;
//
//import java.util.Map;
//import java.util.regex.Pattern;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//public class ProviderController {
//	
//	SessionFactory sf;
//	Session session;
// 
//	private ProviderDetailsDAOImpl daoImpl;
//	private ProviderDetails providerDetails;
// 
//	public ProviderDetails getProviderDetails() {
//		return providerDetails;
//	}
//	public void setProviderDetails(ProviderDetails providerDetails) {
//		this.providerDetails = providerDetails;
//	}
//
//	public ProviderDetailsDAOImpl getDaoImpl() {
//		return daoImpl;
//	}
//	public void setDaoImpl(ProviderDetailsDAOImpl daoImpl) {
//		this.daoImpl = daoImpl;
//	}
// 
//	public String searchProviderDetails(String providerid) {
//		System.out.println("From controller : "+providerid);
//		return daoImpl.searchProviderDetails(providerid);
//	}
//	public String updateProviderDetails(ProviderDetails provider) {
//		System.out.println(provider);
//		System.out.println(daoImpl);
//		System.out.println("addProviderValid is Hittingggggggggg");
//		System.out.println(updateValid(provider));
//		if (updateValid(provider)) {
//			return daoImpl.updateProviderDetails(provider);
//		}
//		return "";
// 
//	}
// 
//	
// 
//	public boolean updateValid(ProviderDetails provider) {
//		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//		FacesContext context = FacesContext.getCurrentInstance();
//		String firstName = "^[A-Za-z\\s]+$";
//		String lastName = "^[A-Za-z\\s]+$";
//		String userName = "^[^\\s]{8,10}$";
////		String phoneno = "^(\\+91|91|0)?[6789]\\d{9}$";
//		String email = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
//		System.out.println("list from cont : "+provider);
//		
// 
//		if (!Pattern.matches(userName, provider.getUsername())) {
//		    context.addMessage("form:userName", new FacesMessage("Provider Username Contains min 8 characters"));
//			System.out.println("UserName Failed...");
//			Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//			sessionMap2.put("FirstError" ,"Invalid Address.Provider Username Contains min 8 characters.");
//			return false;
//		}
//		if (!Pattern.matches(firstName, provider.getFirstname())) {
//			context.addMessage("form:firstName", new FacesMessage("Invalid FirstName. Only letters are allowed."));
//			System.out.println("FirstName Failed...");
//			Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//			sessionMap2.put("FirstError1" ,"Invalid FirstName. Only letters are allowed.");
//			return false;
//		}
//		if (!Pattern.matches(lastName, provider.getLastname())) {
//			context.addMessage("form:lastName", new FacesMessage("Invalid LastName. Only letters are allowed."));
//			System.out.println("LastName Failed...");
//			Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//			sessionMap2.put("FirstError2" ,"Invalid LastName. Only letters are allowed.");
//			return false;
//		}
////		if (!Pattern.matches(phoneno, provider.getPhoneno())) {
////			context.addMessage("form:phoneno", new FacesMessage("Invalid Phone Number."));
////			System.out.println("PhoneNo Failed...");
////			return false;
////		}
//		if (!Pattern.matches(email, provider.getEmail())) {
//			context.addMessage("form:email", new FacesMessage("Invalid Email."));
//			System.out.println("Email Failed...");
//			Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//			sessionMap2.put("FirstError3" ,"Invalid Email.");
//			return false;
//		
//}
//		return true;
//	}
//}package com.java.jsp;
 
package com.java.hib;

import java.text.ParseException;
import java.util.Map;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProviderController {
 
	SessionFactory sf;
	Session session;

 
	private ProviderDetailsDAOImpl daoImpl;
	private ProviderDetails providerDetails;
 
	public ProviderDetailsDAOImpl getDaoImpl() {
		return daoImpl;
	}

	public void setDaoImpl(ProviderDetailsDAOImpl daoImpl) {
		this.daoImpl = daoImpl;
	}

	public ProviderDetails getProviderDetails() {
		return providerDetails;
	}

	public void setProviderDetails(ProviderDetails providerDetails) {
		this.providerDetails = providerDetails;
	}



	public String updateProviderDetails(ProviderDetails provider) throws ParseException {
		System.out.println(provider);
		System.out.println(daoImpl);
		System.out.println("addProviderValid is Hittingggggggggg");
		System.out.println("Provider  " +provider);
		System.out.println(updateValid(provider));
		if (updateValid(provider)) {
			return daoImpl.updateProviderDetails(provider);
		}
		return "";
 
	}
 
	
 
	public boolean updateValid(ProviderDetails provider) {
		FacesContext context = FacesContext.getCurrentInstance();
		String firstName = "^[A-Za-z\\s]+$";
		String lastName = "^[A-Za-z\\s]+$";
		String userName = "^[^\\s]{8,10}$";
		String licenseNumber = "^[A-Z0-9]{8}$";
		String qualification = "^[A-Za-z0-9\\s]{1,100}$";
		String speciality = "^[A-Za-z0-9\\s]{1,100}$";
		String phoneno = "^(\\+91|91|0)?[6789]\\d{9}$";
		String email = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		String password = "^(?=.*[A-Z])(?=.*[a-z0-9])(?=.*[^a-zA-Z0-9]).{8,18}$";
//		String dateFormatRegex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
 
	
//FIRSTNAME
		boolean flag=true;
	    System.out.println("FirstName Length is " +provider.getFirstname().length());
	    if (provider.getFirstname().length() <= 0) {
			 context.addMessage("form:firstName", new FacesMessage("FirstName Cannot be Empty..."));
			 System.out.println("FirstName Null Failed...");
			 Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			 sessionMap2.put("FirstError" ,"Invalid FirstName.FirstName Cannot be Empty...");
			 flag = false;
				}

		if (!Pattern.matches(firstName, provider.getFirstname())) {
			context.addMessage("form:firstName", new FacesMessage("Invalid FirstName. Only letters are allowed."));
			System.out.println("FirstName Failed...");
			Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap2.put("FirstError1" ,"Invalid FirstName. Only letters are allowed.");
			flag = false;
		}
//LASTNAME
		if(provider.getLastname().length() <= 0) {
		   context.addMessage("form:lastName", new FacesMessage("LastName Cannot Be Empty."));
		   System.out.println("LastName Failed...");
		   Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap2.put("FirstError2" ,"Invalid LastName. LastName Cannot Be Empty..");
		   flag = false;
		}  

		if (!Pattern.matches(lastName, provider.getLastname())) {
			context.addMessage("form:lastName", new FacesMessage("Invalid LastName. Only letters are allowed."));
			System.out.println("LastName Failed...");
			Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap2.put("FirstError3" ,"Invalid LastName. Only letters are allowed.");
			flag = false;
		}
//USERNAME			
		if (!Pattern.matches(userName, provider.getUsername())) {
		    context.addMessage("form:userName", new FacesMessage("Provider Username Contains min 8 characters"));
			System.out.println("UserName Failed...");
			Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap2.put("FirstError4" ,"Invalid username.Provider Username Contains min 8 characters.");
			flag = false;
		}
////PASSWORD
//			if (provider.getPassword().length() <= 0) {
//			    context.addMessage("form:Password", new FacesMessage("Password Cannot be Empty..."));
//			    System.out.println("Password Null Failed...");
//			    Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//				sessionMap2.put("FirstError5" ,"Invalid Password.Password Cannot be Empty...");
//			    flag = false;
//			    
//			}
//			if (!Pattern.matches(password, provider.getPassword())) {
//			    context.addMessage("form:Password", new FacesMessage("Invalid Password format.Hint: @Abcde1234"));
//			    System.out.println("Password failed.");
//			    Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//				sessionMap2.put("FirstError6" ,"Invalid Password.Invalid Password format.Hint: @Abcde1234");
//			    flag = false;
//			}
//PHONENUMBER
		if (provider.getPhoneno().length() <= 0) {
		   context.addMessage("form:phoneno", new FacesMessage("Enter Your Phone Number."));
		   System.out.println("PhoneNo Failed...");
		   Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		   sessionMap2.put("FirstError7" ,"Invalid Phonenumber.Enter Your Phone Number.");
		   flag = false;
		}
		if (!Pattern.matches(phoneno, provider.getPhoneno())) {
			context.addMessage("form:phoneno", new FacesMessage("Invalid Phone Number."));
			System.out.println("PhoneNo Failed...");
			Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap2.put("FirstError8" ,"Invalid Phone number");
			flag = false;
		}
//ADDRESS
//				if (provider.getAddress().length() <= 0) {
//					context.addMessage("form:address", new FacesMessage("Please Enter Your Address."));
//					System.out.println("Enter Your Address");
//					Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//					sessionMap2.put("FirstError8" ,"Invalid address.Please Enter Your Address.");
//					flag = false;
//		}

//LicenseNumber				
//				if (provider.getLicenseNumber() == null || provider.getLicenseNumber().isEmpty()) {
//				    context.addMessage("form:licenseNumber", new FacesMessage("License Number Cannot Be Empty"));
//				    System.out.println("License Number Failed...");
//				    Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//					sessionMap2.put("FirstError9" ,"Invalid LicenseNumber.License Number Cannot Be Empty");
//				    flag = false;
//				}
//				if (!Pattern.matches(licenseNumber, provider.getLicenseNumber())) {
//				    context.addMessage("form:licenseNumber", new FacesMessage("Invalid License Number. It should be 8 characters long and contain only uppercase letters and digits."));
//				    System.out.println("License Number Failed...");
//				    Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//					sessionMap2.put("FirstError10" ,"Invalid LicenseNumber.It should be 8 characters long and contain only uppercase letters and digits.");
//				    flag = false;
//				}
//Qualification				
//				if (provider.getQualification() == null || provider.getQualification().isEmpty()) {
//				    context.addMessage("form:qualification", new FacesMessage("Qualification Cannot Be Empty"));
//				    System.out.println("Qualification Failed...");
//				    Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//					sessionMap2.put("FirstError11" ,"Invalid Qualification.Qualification Cannot Be Empty");
//				    flag = false;
//				}
//				if (!Pattern.matches(qualification, provider.getQualification())) {
//				    context.addMessage("form:qualification", new FacesMessage("Invalid Qualification. It should be 1 to 100 characters long and may contain letters, digits, and spaces."));
//				    System.out.println("Qualification Failed...");
//				    Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//					sessionMap2.put("FirstError12" ,"Invalid Qualification.It should be 1 to 100 characters long and may contain letters, digits, and spaces.");
//				    flag = false;
//				}
//Specialty				
//				if (provider.getSpecialty() == null || provider.getSpecialty().isEmpty()) {
//				    context.addMessage("form:speciality", new FacesMessage("Speciality Cannot Be Empty"));
//				    System.out.println("Speciality Failed...");
//				    Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//					sessionMap2.put("FirstError13" ,"Invalid Specialty.Speciality Cannot Be Empty.");
//				    flag = false;
//				    
//				} if (!Pattern.matches(speciality, provider.getSpecialty())) {
//				    context.addMessage("form:speciality", new FacesMessage("Invalid Speciality. It should be 1 to 100 characters long and may contain letters, digits, and spaces."));
//				    System.out.println("Speciality Failed...");
//				    Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//					sessionMap2.put("FirstError14" ,"Invalid Specialty. It should be 1 to 100 characters long and may contain letters, digits, and spaces.");
//				    flag = false;
//				}
 
				
//GENDER
//			    if (provider.getGender() == null || provider.getGender().isEmpty()) {
//			        context.addMessage("form:gender", new FacesMessage("Select Gender."));
//			        System.out.println("Select Gender Failed...");
//			        Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//					sessionMap2.put("FirstError15" ,"Invalid Gender.Select Gender.");
//			        flag = false;
//		}
// 
				
////DateOfBirth
//			    if (provider.getDateOfBirth()==null || provider.getDateOfBirth().equals("")) {
//		        context.addMessage("form:dob", new FacesMessage("DateOfBirth cannot be empty."));
//			        System.out.println("Enter Your DateOfBirth");
//			        Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//					sessionMap2.put("FirstError16" ,"Invalid DateOfBirth.DateOfBirth cannot be empty.");
//			        flag = false;
//			    }
//EnrollmentDate
//			    if (provider.getEnrollmentdate()==null || provider.getEnrollmentdate().equals("")) {
//			        context.addMessage("form:enrollmentdate", new FacesMessage("EnrollmentDate cannot be empty."));
//			        System.out.println("Enter Your EnrollmentDate");
//			        Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//					sessionMap2.put("FirstError17" ,"Invalid enrollmentDate.EnrollmentDate cannot be empty.");
//			        flag = false;
//			    }
// 
				
//GMAIL
//		if (provider.getEmail().length() <= 0) {
//		    context.addMessage("form:email", new FacesMessage("Email Cannot Be Empty"));
//			System.out.println("Email Failed...");
//			Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//			sessionMap2.put("FirstError18" ,"Email Cannot Be Empty");
//			flag = false;
//		}
		
//		if (!Pattern.matches(email, provider.getEmail())) {
//			context.addMessage("form:email", new FacesMessage("Invalid Email."));
//			System.out.println("Email Failed...");
//			 Map<String, Object> sessionMap2 = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//			 sessionMap2.put("FirstError19" ,"Invalid Email.");
//			flag = false;
//		}
	     
		return flag;
}
}



