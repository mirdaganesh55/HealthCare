package com.java.hib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.print.attribute.standard.PDLOverrideSupported;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class ProviderDAOImpl implements ProviderDAO {

	private SessionFactory sf;
	private Session session;
	
	private long elapsedDays;
	
	public List<Provider> showProviderDetails() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Provider.class);
		criteria.add(Restrictions.eq("status", "APPLIED"));
		List<Provider> providerList = criteria.list();
		session.close();
		sf.close();
		return providerList;
	}

	public String cancel() {
		return "ShowProviderPagination.jsp?faces-redirect=true";
	}
	public String cancel2() {
		return "PendingProvider.jsp?faces-redirect=true";
	}

	public String reviewProvider(String providerId) {
		Map<String, Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("providerId", providerId);
		return "Review.jsp?faces-redirect=true";
	}

	public String searchProvider(String providerId) {
		Map<String, Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Provider.class);
		criteria.add(Restrictions.eq("providerId", providerId));
		Provider providerData = (Provider) criteria.uniqueResult();
		session.close();
		sf.close();
		sessionMap.put("list", providerData);
		if (providerData != null) {
			sessionMap.put("providerId", providerData.getProviderId());
			System.out.println("==================" + providerData);
		}
		return "Review.jsp?faces-redirect=true";
	}
	
	public String searchProviderByPending(String providerId) {
		Map<String, Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Provider.class);
		criteria.add(Restrictions.eq("providerId", providerId));
		Provider providerData = (Provider) criteria.uniqueResult();
		session.close();
		sf.close();
		sessionMap.put("list", providerData);
		if (providerData != null) {
			sessionMap.put("providerId", providerData.getProviderId());
			System.out.println("==================" + providerData);
		}
		return "ReviewByPending.jsp?faces-redirect=true";
	}
	
	public Provider searchProvider2(String providerId2) {
		Map<String, Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Provider.class);
		criteria.add(Restrictions.eq("providerId", providerId2));
		System.out.println("SearchProvider Called "+providerId2);
		Provider providerData = (Provider) criteria.uniqueResult();
		session.close();
		sf.close();
		return providerData;
	}

	public List<Provider> filterProvidersByStatus(String status) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Provider.class);
		criteria.add(Restrictions.eq("status", status));
		List<Provider> providerList = criteria.list();
		System.out.println("Calling from filterProvidersByStatus()" +providerList);
		session.close();
		sf.close();
		return providerList;
	}
	public List<Provider> approvedProvider() {
		return filterProvidersByStatus("APPROVED");
	}

	public List<Provider> rejectedProvider() {
		return filterProvidersByStatus("REJECTED");
	}

	public List<Provider> pendingProvider() {
		return filterProvidersByStatus("PENDING");
	}

	public  int calculateYearDifference(Date startDate, Date endDate) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int startYear = startCal.get(Calendar.YEAR);
		int endYear = endCal.get(Calendar.YEAR);

		return endYear - startYear;
	}
	
	public String validating() throws ParseException {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Provider provider = (Provider)sessionMap.get("list");
		sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Doctor.class);
		criteria.add(Restrictions.eqOrIsNull("speciality", provider.getSpeciality()));
		Doctor doctor = (Doctor)criteria.uniqueResult();
		session.close();
		sf.close();
		
		if (doctor == null) {
			denyAndNotify(provider, "Rejection Notification: Provider Details - Speciality Error", "We don't want this Speciality because it  does not Exists...");
			return "CommentsPage.jsp?faces-redirect=true";
		} else {
			String speciality = searchDoc(doctor.getSpeciality()).getSpeciality();
			String Qualification = searchDoc(doctor.getSpeciality()).getQualification();
			String licensePattern="";
			if(speciality.equalsIgnoreCase("Nursing")) {
				licensePattern="^RN\\d{8}$";
			}else if(speciality.equalsIgnoreCase("Dentist")) {
				licensePattern="^DN\\d{8}$";
			}else if(speciality.equalsIgnoreCase("Cardiologist")) {
				licensePattern="^CR\\d{8}$";
			}else if(speciality.equalsIgnoreCase("General Physician")){
				licensePattern="^GN\\d{8}$";
			}else if(speciality.equalsIgnoreCase("Neurologist")) {
				licensePattern="^NE\\d{8}$";
			}else if(speciality.equalsIgnoreCase("Urologist")) {
				licensePattern="^UR\\d{8}$";
			}else if(speciality.equalsIgnoreCase("Psychologist")) {
				licensePattern="^PY\\d{8}$";
			}else {
				licensePattern="";
			}

			boolean condition = Qualification.contains(provider.getQualification()) && Pattern.matches(licensePattern, provider.getLicenseNumber());
			boolean specialityMatch = speciality.equalsIgnoreCase(provider.getSpeciality());
			boolean licenseNumberMatch = Pattern.matches(licensePattern, provider.getLicenseNumber());

			if (condition) {
				
				String date=provider.getLicenseNumber().substring(2);
				SimpleDateFormat oSdf= new SimpleDateFormat("ddMMyyyy");
				Date oDate=oSdf.parse(date);

				SimpleDateFormat tSdf= new SimpleDateFormat("dd-MM-YYYY");
				String tDate=tSdf.format(oDate);
				Date ttDate=tSdf.parse(tDate);
				
				
				int dateDiff=calculateYearDifference(ttDate, new Date());
				System.out.println("Year Difference is : " +dateDiff);
				if(dateDiff <= 5 ) {
					if(dateDiff >= 0) {
						approveAndNotify(provider);
						System.out.println("-------------" +provider);
						return "ApprovedProvider.jsp?faces-redirect=true";
					}else {
						denyAndNotify(provider, "Rejection Notification: Provider Details - Licence Number Error ", "Your Licence Number is Not Valid..");
						return "CommentsPage.jsp?faces-redirect=true";
					}
				}
				else {
					System.out.println("n Lic " +provider);
					pendingAndNotify(provider, "License Number Expired", " you have to Renew the LicNumber");
					return "PendingProvider.jsp?faces-redirect=true";
				}
			} 
			else 
			{
				if (specialityMatch && !licenseNumberMatch) {
					System.out.println("n Lic " +provider);
					denyAndNotify(provider, "Rejection Notification: Provider Details - Licence Number Error ", "Your Licence Number and Speciality not matches");
				} else if (!specialityMatch && licenseNumberMatch) {
					System.out.println("n Spe " +provider);
					denyAndNotify(provider, "Rejection Notification: Provider Details - Speciality error", "Speciality Not Matches With Licence Number");
				} else {
					System.out.println(" Qualification  " +provider);
					denyAndNotify(provider, "Rejection Notification: Provider Details - Qualification Error and Speciality Error", "We don't want this Speciality because Qualification does not match...");
				}
			}
		}
		return "CommentsPage.jsp?faces-redirect=true";
	}
	public void deny(Provider provider) {
		MailSend.mailOtp(provider.getEmail(), "Provider Denied", "Provider does not matchs with the specification");
	}
	public Doctor searchDoc(String speciality) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(Doctor.class);
		criteria.add(Restrictions.eq("speciality", speciality));
		Doctor doc = (Doctor) criteria.uniqueResult();
		session.close();
		sf.close();
		return doc;
	}
	private void approveAndNotify(Provider provider) throws ParseException {
		Map<String, Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String providerId = (String)sessionMap.get("providerId");
		Provider provider2 = searchProvider2(providerId);
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
		String formattedDate = dateFormat.format(currentDate);
        Date parsedDate = dateFormat.parse(formattedDate);
		provider.setReviewDate(parsedDate);
		provider.setStatus("APPROVED");
		provider.setIsActive("YES");
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		System.out.println("---------------Approve----------------");
		session.update(provider);
		trans.commit();
		session.close();
		sf.close();
		FinalMail send = new FinalMail();
		send.sendEmail(provider);
	}

		private void denyAndNotify(Provider provider, String subject, String body) throws ParseException {
		Map<String, Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String providerId = (String)sessionMap.get("providerId");
		Provider provider2 = searchProvider2(providerId);
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
		String formattedDate = dateFormat.format(currentDate);
        Date parsedDate = dateFormat.parse(formattedDate);
		provider.setReviewDate(parsedDate);
		provider.setStatus("REJECTED");
		provider.setIsActive("NO");
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		System.out.println("---------------Deny----------------");
		session.update(provider);
		trans.commit();
		session.close();
		sf.close();
		MailSend.mailOtp(provider.getEmail(), subject, body);
	}
	
	public String commentsPage(String providerId,Provider provider) {
	System.out.println(".......................Comments Page..........................");
	Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		Provider providerFound=(Provider)sessionMap.get("list");
		System.out.println("-------- Called from Comments-Page -------"+providerFound);		
		providerFound.setComments(provider.getComments());
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(providerFound);
		transaction.commit();
		session.close();
		sf.close();
		return "RejectedProvider.jsp?faces-redirect=true";
		}

	private void pendingAndNotify(Provider provider, String subject, String body) throws ParseException {
		System.out.println("===============  Pending is called ==========================");
		Map<String, Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String providerId = (String)sessionMap.get("providerId");
		Provider provider2 = searchProvider2(providerId);
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
		String formattedDate = dateFormat.format(currentDate);
        Date parsedDate = dateFormat.parse(formattedDate);
		provider.setReviewDate(parsedDate);
		provider.setStatus("PENDING");
		provider.setIsActive("NO");
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		System.out.println("--------------PENDING----------------");
		session.update(provider);
		trans.commit();
		session.close();
		sf.close();
		MailSend.mailOtp(provider.getEmail(), subject, body);
	}
	 private boolean diff(Provider provider2) {
		 long ms = new Date().getTime() - provider2.getReviewDate().getTime();
			int diffs = (int)(ms/(1000 * 60 * 60 * 24));
			diffs++;
			if(diffs > 30) {
				return true;
			}else {
				return false;
			}
	}

	public long getElapsedDays() {
	        return elapsedDays;
	    }

	    private static final int LINK_EXPIRATION_DAYS = 30;
	    
	    public boolean isLinkExpired(String providerId) throws ParseException {
			Provider provider2 = searchProvider2(providerId);
			
	        Date recordReviewedDate = provider2.getReviewDate();
	        Date recordUpdatedDate = provider2.getUpdatedDate();
	        
	        if(recordUpdatedDate!=null && recordReviewedDate!=null) {
	        	System.out.println("is true");
	        	long elapsedMillis = recordUpdatedDate.getTime() - recordReviewedDate.getTime();
	        	elapsedDays = TimeUnit.MILLISECONDS.toDays(elapsedMillis);	  
	        	System.out.println(provider2 + "ElapsedDay------------->" +elapsedDays);
	        }
	        if(elapsedDays > LINK_EXPIRATION_DAYS && provider2.getUpdatedDate()!=null ) {
	        	System.out.println("Second if called....");
				denyAndNotify(provider2, "Rejection Notification: Provider Details", "Licence number not Reniewed and your timeline ended");

	        	return true;
	        }
	        else if (diff(provider2)) {
//	        	changeStatusToRejected(providerId);
				denyAndNotify(provider2, "Rejection Notification: Provider Details", "Licence number not Reniewed and your timeline ended");
	        	return true;
	        }
	        else{
	        	return false;
	        }  
	    }
	    
	    public boolean checkUpdateDate(String providerId) {
	    	Provider provider2 = searchProvider2(providerId);
	    	Date recordReviewedDate = provider2.getReviewDate();
	    	Date recordUpdatedDate = provider2.getUpdatedDate();
	    	if(recordUpdatedDate!=null && recordReviewedDate!=null) {
	    		return false;	    		
	    	}else {
	    		return true;
	    	}
	    }
	    public boolean checkReviewDateGreater(String providerId) {
	    	Provider provider2 = searchProvider2(providerId);
	    	Date recordReviewedDate = provider2.getReviewDate();
	    	Date currentDate = new Date();
	    	if(currentDate!=null && recordReviewedDate!=null) {
	    		return false;	    		
	    	}else {
	    		return true;
	    	}
	    }

	    
	    public static int countRows() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Provider.class);
			criteria.add(Restrictions.eq("status", "APPLIED"));
			if (criteria != null) {
				int listSize = criteria.list().size();
				session.close();
				sf.close();
				return listSize;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static int countRows2() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Provider.class);
			criteria.add(Restrictions.eq("status", "REJECTED"));
			if (criteria != null) {
				int listSize = criteria.list().size();
				session.close();
				sf.close();
				return listSize;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static int countRows3() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Provider.class);
			criteria.add(Restrictions.eq("status", "APPROVED"));
			if (criteria != null) {
				int listSize = criteria.list().size();
				session.close();
				sf.close();
				return listSize;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public static int countRows4() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Provider.class);
			criteria.add(Restrictions.eq("status", "PENDING"));
			if (criteria != null) {
				int listSize = criteria.list().size();
				session.close();
				sf.close();
				return listSize;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
/*----------------------------------------Sorting----------------------------------------------*/	
		public List<Provider> getListOfProvider(int firstRow, int rowCount) {
		Map<String, Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Provider.class);
		criteria.add(Restrictions.eq("status", "APPLIED"));

		criteria.setFirstResult(firstRow);
		criteria.setMaxResults(rowCount);

		if ("asc".equals(orderByProviderId)) {
			criteria.addOrder(Order.asc("providerId"));
		} 
		else if ("desc".equals(orderByProviderId)) {
			criteria.addOrder(Order.desc("providerId"));
		}
		else if ("asc".equals(orderBySpeciality)) {
			criteria.addOrder(Order.desc("speciality"));
		}
		else if ("desc".equals(orderBySpeciality)) {
			criteria.addOrder(Order.asc("speciality"));
		}
		else if ("asc".equals(orderByFirstName)) {
			criteria.addOrder(Order.desc("firstName"));
		}
		else if ("desc".equals(orderByFirstName)) {
			criteria.addOrder(Order.asc("firstName"));
		}
		else if ("asc".equals(orderByLastName)) {
			criteria.addOrder(Order.desc("lastName"));
		}
		else if ("desc".equals(orderByLastName)) {
			criteria.addOrder(Order.asc("lastName"));
		}
		else if ("asc".equals(orderByQualification)) {
			criteria.addOrder(Order.desc("qualification"));
		}
		else if ("desc".equals(orderByQualification)) {
			criteria.addOrder(Order.asc("qualification"));
		}
		else if ("asc".equals(orderByGender)) {
			criteria.addOrder(Order.desc("gender"));
		}
		else if ("desc".equals(orderByGender)) {
			criteria.addOrder(Order.asc("gender"));
		}
		else if ("asc".equals(orderByLic)) {
			criteria.addOrder(Order.desc("licenseNumber"));
		}
		else if ("desc".equals(orderByLic)) {
			criteria.addOrder(Order.asc("licenseNumber"));
		}
		else if ("asc".equals(orderByEmail)) {
			criteria.addOrder(Order.desc("email"));
		}
		else if ("desc".equals(orderByEmail)) {
			criteria.addOrder(Order.asc("email"));
		}
		else if ("asc".equals(orderByDate)) {
			criteria.addOrder(Order.desc("enrollmentDate"));
		}
		else if ("desc".equals(orderByDate)) {
			criteria.addOrder(Order.asc("enrollmentDate"));
		}
		List<Provider> providerList = criteria.list();
		session.getTransaction().commit();
		session.close();
		sf.close();
		return providerList;
	}

	static String orderByProviderId = "asc";
	static String orderBySpeciality = "sort";
	static String orderByFirstName = "sort";
	static String orderByLastName = "sort";
	static String orderByQualification = "sort";
	static String orderByGender = "sort";
	static String orderByLic = "sort";
	static String orderByEmail = "sort";
	static String orderByDate = "sort";

	

	public String sortByProviderId() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderByProviderId.length() == 4) {
			orderByProviderId = "asc";
		} else if ("asc".equals(orderByProviderId)) {
			orderByProviderId = "desc";
		}
		sessionMap.put("orderByProviderId", orderByProviderId);
		return "ShowProviderPagination.jsp?faces-redirect=true";
	}

	public String sortBySpeciality() {
		Map<String, Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderBySpeciality.length() == 4) {
			orderBySpeciality = "asc";
			orderByProviderId = "sort";
		} else if ("asc".equals(orderBySpeciality)) {
			orderBySpeciality = "desc";
			orderByProviderId = "sort";
		}
		sessionMap.put("orderBySpeciality", orderBySpeciality);
		return "ShowProviderPagination.jsp?faces-redirect=true";
	}
	public String sortByFirstName() {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderByFirstName.length() == 4) {
			orderByFirstName = "asc";
			orderByProviderId = "sort";
			orderBySpeciality="sort";
		} else if ("asc".equals(orderByFirstName)) {
			orderByFirstName = "desc";
			orderByProviderId = "sort";
			orderBySpeciality="sort";
		}
		sessionMap.put("orderByFirstName", orderByFirstName);
		return "ShowProviderPagination.jsp?faces-redirect=true";
	}
	public String sortByLastName() {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderByLastName.length() == 4) {
			orderByLastName = "asc";
			orderByProviderId = "sort";
			orderBySpeciality="sort";
			orderByFirstName="sort";
		} else if ("asc".equals(orderByLastName)) {
			orderByLastName = "desc";
			orderByProviderId = "sort";
			orderBySpeciality="sort";
			orderByFirstName="sort";
		}
		sessionMap.put("orderByLastName", orderByLastName);
		return "ShowProviderPagination.jsp?faces-redirect=true";
	}	
	public String sortByQualification() {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderByQualification.length() == 4) {
			orderByQualification = "asc";
			orderByProviderId = "sort";
			orderBySpeciality="sort";
			orderByFirstName="sort";
			orderByLastName="sort";
		} else if ("asc".equals(orderByQualification)) {
			orderByQualification = "desc";
			orderByProviderId = "sort";
			orderBySpeciality="sort";
			orderByFirstName="sort";
			orderByLastName="sort";
		}
		sessionMap.put("orderByQualification", orderByQualification);
		return "ShowProviderPagination.jsp?faces-redirect=true";
	}
	public String sortByGender() {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderByGender.length() == 4) {
			orderByGender = "asc";
			orderByProviderId = "sort";
			orderBySpeciality="sort";
			orderByFirstName="sort";
			orderByLastName="sort";
			orderByQualification="sort";
		} else if ("asc".equals(orderByGender)) {
			orderByGender = "desc";
			orderByProviderId = "sort";
			orderBySpeciality="sort";
			orderByFirstName="sort";
			orderByLastName="sort";
			orderByQualification="sort";
		}
		sessionMap.put("orderByGender", orderByGender);
		return "ShowProviderPagination.jsp?faces-redirect=true";
	}
	public String sortByLic() {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderByLic.length() == 4) {
			orderByLic = "asc";
			orderByProviderId = "sort";
			orderBySpeciality="sort";
			orderByFirstName="sort";
			orderByLastName="sort";
			orderByQualification="sort";
			orderByGender="sort";
		} else if ("asc".equals(orderByLic)) {
			orderByLic = "desc";
			orderByProviderId = "sort";
			orderBySpeciality="sort";
			orderByFirstName="sort";
			orderByLastName="sort";
			orderByQualification="sort";
			orderByGender="sort";
		}
		sessionMap.put("orderByLic", orderByLic);
		return "ShowProviderPagination.jsp?faces-redirect=true";
	}
	public String sortByEmail() {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderByEmail.length() == 4) {
			orderByEmail = "asc";
			orderByProviderId = "sort";
			orderBySpeciality="sort";
			orderByFirstName="sort";
			orderByLastName="sort";
			orderByQualification="sort";
			orderByGender="sort";
			orderByLic="sort";
		} else if ("asc".equals(orderByEmail)) {
			orderByEmail = "desc";
			orderByProviderId = "sort";
			orderBySpeciality="sort";
			orderByFirstName="sort";
			orderByLastName="sort";
			orderByQualification="sort";
			orderByGender="sort";
			orderByLic="sort";

		}
		sessionMap.put("orderByEmail", orderByEmail);
		return "ShowProviderPagination.jsp?faces-redirect=true";
	}
	public String sortByDate() {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderByDate.length() == 4) {
			orderByDate = "asc";
			orderByProviderId = "sort";
			orderBySpeciality="sort";
			orderByFirstName="sort";
			orderByLastName="sort";
			orderByQualification="sort";
			orderByGender="sort";
			orderByLic="sort";
			orderByEmail="sort";
		} else if ("asc".equals(orderByDate)) {
			orderByDate = "desc";
			orderByProviderId = "sort";
			orderBySpeciality="sort";
			orderByFirstName="sort";
			orderByLastName="sort";
			orderByQualification="sort";
			orderByGender="sort";
			orderByLic="sort";
			orderByEmail="sort";
			
		}
		sessionMap.put("orderByDate", orderByDate);
		return "ShowProviderPagination.jsp?faces-redirect=true";
	}
/*----------------------------------------Sorting---------------------------------------------*/	
	public List<Provider> getRejProviderList(int firstRowR, int rowCountR) {
		Map<String, Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Provider.class);
		criteria.add(Restrictions.eq("status", "REJECTED"));
		
		criteria.setFirstResult(firstRowR);
		criteria.setMaxResults(rowCountR);
		
		if ("asc".equals(orderByProviderIdR)) {
			criteria.addOrder(Order.asc("providerId"));
		} 
		else if ("desc".equals(orderByProviderIdR)) {
			criteria.addOrder(Order.desc("providerId"));
		}
		else if ("asc".equals(orderBySpecialityR)) {
			criteria.addOrder(Order.desc("speciality"));
		}
		else if ("desc".equals(orderBySpecialityR)) {
			criteria.addOrder(Order.asc("speciality"));
		}
		else if ("asc".equals(orderByFirstNameR)) {
			criteria.addOrder(Order.desc("firstName"));
		}
		else if ("desc".equals(orderByFirstNameR)) {
			criteria.addOrder(Order.asc("firstName"));
		}
		else if ("asc".equals(orderByLastNameR)) {
			criteria.addOrder(Order.desc("lastName"));
		}
		else if ("desc".equals(orderByLastNameR)) {
			criteria.addOrder(Order.asc("lastName"));
		}
		else if ("asc".equals(orderByQualificationR)) {
			criteria.addOrder(Order.desc("qualification"));
		}
		else if ("desc".equals(orderByQualificationR)) {
			criteria.addOrder(Order.asc("qualification"));
		}
		else if ("asc".equals(orderByGenderR)) {
			criteria.addOrder(Order.desc("gender"));
		}
		else if ("desc".equals(orderByGenderR)) {
			criteria.addOrder(Order.asc("gender"));
		}
		else if ("asc".equals(orderByDateR)) {
			criteria.addOrder(Order.desc("enrollmentDate"));
		}
		else if ("desc".equals(orderByDateR)) {
			criteria.addOrder(Order.asc("enrollmentDate"));
		}
		else if ("asc".equals(orderByLicR)) {
			criteria.addOrder(Order.desc("licenseNumber"));
		}
		else if ("desc".equals(orderByLicR)) {
			criteria.addOrder(Order.asc("licenseNumber"));
		}
		List<Provider> providerList = criteria.list();
		session.getTransaction().commit();
		session.close();
		sf.close();
		return providerList;
	}
	
	static String orderByProviderIdR = "asc";
	static String orderBySpecialityR = "sort";
	static String orderByFirstNameR = "sort";
	static String orderByLastNameR = "sort";
	static String orderByQualificationR = "sort";
	static String orderByGenderR = "sort";
	static String orderByDateR = "sort";
	static String orderByLicR = "sort";
	
	public String sortByProviderIdR() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderByProviderIdR.length() == 4) {
			orderByProviderIdR = "asc";
		} else if ("asc".equals(orderByProviderIdR)) {
			orderByProviderIdR = "desc";
		}
		sessionMap.put("orderByProviderIdR", orderByProviderIdR);
		return "RejectedProvider.jsp?faces-redirect=true";
	}
	
	public String sortBySpecialityR() {
		Map<String, Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderBySpecialityR.length() == 4) {
			orderBySpecialityR = "asc";
			orderByProviderIdR = "sort";
		} else if ("asc".equals(orderBySpecialityR)) {
			orderBySpecialityR = "desc";
			orderByProviderIdR = "sort";
		}
		sessionMap.put("orderBySpecialityR", orderBySpecialityR);
		return "RejectedProvider.jsp?faces-redirect=true";
	}
	public String sortByFirstNameR() {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderByFirstNameR.length() == 4) {
			orderByFirstNameR = "asc";
			orderByProviderIdR = "sort";
			orderBySpecialityR="sort";
		} else if ("asc".equals(orderByFirstNameR)) {
			orderByFirstNameR = "desc";
			orderByProviderIdR = "sort";
			orderBySpecialityR="sort";
		}
		sessionMap.put("orderByFirstNameR", orderByFirstNameR);
		return "RejectedProvider.jsp?faces-redirect=true";
	}
	public String sortByLastNameR() {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderByLastNameR.length() == 4) {
			orderByLastNameR = "asc";
			orderByProviderIdR = "sort";
			orderBySpecialityR="sort";
			orderByFirstNameR="sort";
		} else if ("asc".equals(orderByLastNameR)) {
			orderByLastNameR = "desc";
			orderByProviderIdR = "sort";
			orderBySpecialityR="sort";
			orderByFirstNameR="sort";
		}
		sessionMap.put("orderByLastNameR", orderByLastNameR);
		return "RejectedProvider.jsp?faces-redirect=true";
	}	
	public String sortByQualificationR() {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderByQualificationR.length() == 4) {
			orderByQualificationR = "asc";
			orderByProviderIdR = "sort";
			orderBySpecialityR="sort";
			orderByFirstNameR="sort";
			orderByLastNameR="sort";
		} else if ("asc".equals(orderByQualificationR)) {
			orderByQualificationR = "desc";
			orderByProviderIdR = "sort";
			orderBySpecialityR="sort";
			orderByFirstNameR="sort";
			orderByLastNameR="sort";
		}
		sessionMap.put("orderByQualificationR", orderByQualificationR);
		return "RejectedProvider.jsp?faces-redirect=true";
	}	
	public String sortByGenderR() {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderByGenderR.length() == 4) {
			orderByGenderR = "asc";
			orderByProviderIdR = "sort";
			orderBySpecialityR="sort";
			orderByFirstNameR="sort";
			orderByLastNameR="sort";
			orderByQualificationR="sort";
		} else if ("asc".equals(orderByGenderR)) {
			orderByGenderR = "desc";
			orderByProviderIdR = "sort";
			orderBySpecialityR="sort";
			orderByFirstNameR="sort";
			orderByLastNameR="sort";
			orderByQualificationR="sort";
		}
		sessionMap.put("orderByGenderR", orderByGenderR);
		return "RejectedProvider.jsp?faces-redirect=true";
	}	
	public String sortByDateR() {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (orderByDateR.length() == 4) {
			orderByDateR = "asc";
			orderByProviderIdR = "sort";
			orderBySpecialityR="sort";
			orderByFirstNameR="sort";
			orderByLastNameR="sort";
			orderByQualificationR="sort";
			orderByGenderR="sort";
		} else if ("asc".equals(orderByDateR)) {
			orderByDateR = "desc";
			orderByProviderIdR = "sort";
			orderBySpecialityR="sort";
			orderByFirstNameR="sort";
			orderByLastNameR="sort";
			orderByQualificationR="sort";
			orderByGenderR="sort";
		}
		sessionMap.put("orderByDateR", orderByDateR);
		return "RejectedProvider.jsp?faces-redirect=true";
	}	

public String sortByLicR() {
	Map<String, Object> sessionMap =
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	if (orderByLicR.length() == 4) {
		orderByLicR = "asc";
		orderByProviderIdR = "sort";
		orderBySpecialityR="sort";
		orderByFirstNameR="sort";
		orderByLastNameR="sort";
		orderByQualificationR="sort";
		orderByGenderR="sort";
		orderByDateR="sort";
	} else if ("asc".equals(orderByLicR)) {
		orderByLicR = "desc";
		orderByProviderIdR = "sort";
		orderBySpecialityR="sort";
		orderByFirstNameR="sort";
		orderByLastNameR="sort";
		orderByQualificationR="sort";
		orderByGenderR="sort";
		orderByDateR="sort";

	}
	sessionMap.put("orderByLicR", orderByLicR);
	return "RejectedProvider.jsp?faces-redirect=true";
}	

/*-------------------------App Sorting Pagination---------------------------------------------*/

public List<Provider> getAppProviderList(int firstRowR, int rowCountR) throws ParseException {
	Map<String, Object> sessionMap = 
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	sf = SessionHelper.getConnection();
	session = sf.openSession();
	session.beginTransaction();
	Criteria criteria = session.createCriteria(Provider.class);
	criteria.add(Restrictions.eq("status", "APPROVED"));
	
	criteria.setFirstResult(firstRowR);
	criteria.setMaxResults(rowCountR);
	
	if ("asc".equals(orderByProviderIdA)) {
		criteria.addOrder(Order.asc("providerId"));
	} 
	else if ("desc".equals(orderByProviderIdA)) {
		criteria.addOrder(Order.desc("providerId"));
	}
	else if ("asc".equals(orderBySpecialityA)) {
		criteria.addOrder(Order.desc("speciality"));
	}
	else if ("desc".equals(orderBySpecialityA)) {
		criteria.addOrder(Order.asc("speciality"));
	}
	else if ("asc".equals(orderByFirstNameA)) {
		criteria.addOrder(Order.desc("firstName"));
	}
	else if ("desc".equals(orderByFirstNameA)) {
		criteria.addOrder(Order.asc("firstName"));
	}
	else if ("asc".equals(orderByLastNameA)) {
		criteria.addOrder(Order.desc("lastName"));
	}
	else if ("desc".equals(orderByLastNameA)) {
		criteria.addOrder(Order.asc("lastName"));
	}
	else if ("asc".equals(orderByQualificationA)) {
		criteria.addOrder(Order.desc("qualification"));
	}
	else if ("desc".equals(orderByQualificationA)) {
		criteria.addOrder(Order.asc("qualification"));
	}
	else if ("asc".equals(orderByGenderA)) {
		criteria.addOrder(Order.desc("gender"));
	}
	else if ("desc".equals(orderByGenderA)) {
		criteria.addOrder(Order.asc("gender"));
	}
	else if ("asc".equals(orderByDateA)) {
		criteria.addOrder(Order.desc("enrollmentDate"));
	}
	else if ("desc".equals(orderByDateA)) {
		criteria.addOrder(Order.asc("enrollmentDate"));
	}
	else if ("asc".equals(orderByLicA)) {
		criteria.addOrder(Order.desc("licenseNumber"));
	}
	else if ("desc".equals(orderByLicA)) {
		criteria.addOrder(Order.asc("licenseNumber"));
	}
	List<Provider> providerList = criteria.list();
	session.close();
	sf.close();
	return providerList;
}

static String orderByProviderIdA = "asc";
static String orderBySpecialityA = "sort";
static String orderByFirstNameA = "sort";
static String orderByLastNameA = "sort";
static String orderByQualificationA = "sort";
static String orderByGenderA = "sort";
static String orderByDateA = "sort";
static String orderByLicA = "sort";

public String sortByProviderIdA() {
	Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	if (orderByProviderIdA.length() == 4) {
		orderByProviderIdA = "asc";
	} else if ("asc".equals(orderByProviderIdA)) {
		orderByProviderIdA = "desc";
	}
	sessionMap.put("orderByProviderIdA", orderByProviderIdA);
	return "ApprovedProvider.jsp?faces-redirect=true";
}

public String sortBySpecialityA() {
	Map<String, Object> sessionMap = 
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	if (orderBySpecialityA.length() == 4) {
		orderBySpecialityA = "asc";
		orderByProviderIdA = "sort";
	} else if ("asc".equals(orderBySpecialityA)) {
		orderBySpecialityA = "desc";
		orderByProviderIdA = "sort";
	}
	sessionMap.put("orderBySpecialityA", orderBySpecialityA);
	return "ApprovedProvider.jsp?faces-redirect=true";
}
public String sortByFirstNameA() {
	Map<String, Object> sessionMap =
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	if (orderByFirstNameA.length() == 4) {
		orderByFirstNameA = "asc";
		orderByProviderIdA = "sort";
		orderBySpecialityA="sort";
	} else if ("asc".equals(orderByFirstNameA)) {
		orderByFirstNameA = "desc";
		orderByProviderIdA= "sort";
		orderBySpecialityA="sort";
	}
	sessionMap.put("orderByFirstNameA", orderByFirstNameA);
	return "ApprovedProvider.jsp?faces-redirect=true";
}
public String sortByLastNameA() {
	Map<String, Object> sessionMap =
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	if (orderByLastNameA.length() == 4) {
		orderByLastNameA = "asc";
		orderByProviderIdA= "sort";
		orderBySpecialityA="sort";
		orderByFirstNameA="sort";
	} else if ("asc".equals(orderByLastNameA)) {
		orderByLastNameA= "desc";
		orderByProviderIdA= "sort";
		orderBySpecialityA="sort";
		orderByFirstNameA="sort";
	}
	sessionMap.put("orderByLastNameA", orderByLastNameA);
	return "ApprovedProvider.jsp?faces-redirect=true";
}	
public String sortByQualificationA() {
	Map<String, Object> sessionMap =
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	if (orderByQualificationA.length() == 4) {
		orderByQualificationA = "asc";
		orderByProviderIdA = "sort";
		orderBySpecialityA="sort";
		orderByFirstNameA="sort";
		orderByLastNameA="sort";
	} else if ("asc".equals(orderByQualificationA)) {
		orderByQualificationA = "desc";
		orderByProviderIdA = "sort";
		orderBySpecialityA="sort";
		orderByFirstNameA="sort";
		orderByLastNameA="sort";
	}
	sessionMap.put("orderByQualificationA", orderByQualificationA);
	return "ApprovedProvider.jsp?faces-redirect=true";
}	
public String sortByGenderA() {
	Map<String, Object> sessionMap =
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	if (orderByGenderA.length() == 4) {
		orderByGenderA = "asc";
		orderByProviderIdA= "sort";
		orderBySpecialityA="sort";
		orderByFirstNameA="sort";
		orderByLastNameA="sort";
		orderByQualificationA="sort";
	} else if ("asc".equals(orderByGenderA)) {
		orderByGenderA= "desc";
		orderByProviderIdA= "sort";
		orderBySpecialityA="sort";
		orderByFirstNameA="sort";
		orderByLastNameA="sort";
		orderByQualificationA="sort";
	}
	sessionMap.put("orderByGenderA", orderByGenderA);
	return "ApprovedProvider.jsp?faces-redirect=true";
}	
public String sortByDateA() {
	Map<String, Object> sessionMap =
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	if (orderByDateA.length() == 4) {
		orderByDateA = "asc";
		orderByProviderIdA= "sort";
		orderBySpecialityA="sort";
		orderByFirstNameA="sort";
		orderByLastNameA="sort";
		orderByQualificationA="sort";
		orderByGenderA="sort";
	} else if ("asc".equals(orderByDateA)) {
		orderByDateA= "desc";
		orderByProviderIdA= "sort";
		orderBySpecialityA="sort";
		orderByFirstNameA="sort";
		orderByLastNameA="sort";
		orderByQualificationA="sort";
		orderByGenderA="sort";
	}
	sessionMap.put("orderByDateA", orderByDateA);
	return "ApprovedProvider.jsp?faces-redirect=true";
}	

public String sortByLicA() {
Map<String, Object> sessionMap =
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
if (orderByLicA.length() == 4) {
	orderByLicA = "asc";
	orderByProviderIdA= "sort";
	orderBySpecialityA="sort";
	orderByFirstNameA="sort";
	orderByLastNameA="sort";
	orderByQualificationA="sort";
	orderByGenderA="sort";
	orderByDateA="sort";
} else if ("asc".equals(orderByLicA)) {
	orderByLicA= "desc";
	orderByProviderIdA= "sort";
	orderBySpecialityA="sort";
	orderByFirstNameA="sort";
	orderByLastNameA="sort";
	orderByQualificationA="sort";
	orderByGenderA="sort";
	orderByDateA="sort";
}
sessionMap.put("orderByLicA", orderByLicA);
return "ApprovedProvider.jsp?faces-redirect=true";
}
/*-------------------------Pending Sorting Pagination---------------------------------------------*/

public List<Provider> getPendProviderList(int firstRowP, int rowCountP) throws ParseException {
	Map<String, Object> sessionMap = 
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	sf = SessionHelper.getConnection();
	session = sf.openSession();
	session.beginTransaction();
	Criteria criteria = session.createCriteria(Provider.class);
	criteria.add(Restrictions.eq("status", "PENDING"));
	
	criteria.setFirstResult(firstRowP);
	criteria.setMaxResults(rowCountP);
	
	if ("asc".equals(orderByProviderIdP)) {
		criteria.addOrder(Order.asc("providerId"));
	} 
	else if ("desc".equals(orderByProviderIdP)) {
		criteria.addOrder(Order.desc("providerId"));
	}
	if ("asc".equals(orderBySpecialityP)) {
		criteria.addOrder(Order.asc("speciality"));
	} 
	else if ("desc".equals(orderBySpecialityP)) {
		criteria.addOrder(Order.desc("speciality"));
	}
	else if ("asc".equals(orderByFirstNameP)) {
		criteria.addOrder(Order.desc("firstName"));
	}
	else if ("desc".equals(orderByFirstNameP)) {
		criteria.addOrder(Order.asc("firstName"));
	}
	else if ("asc".equals(orderByLastNameP)) {
		criteria.addOrder(Order.desc("lastName"));
	}
	else if ("desc".equals(orderByLastNameP)) {
		criteria.addOrder(Order.asc("lastName"));
	}
	else if ("asc".equals(orderByQualificationP)) {
		criteria.addOrder(Order.desc("qualification"));
	}
	else if ("desc".equals(orderByQualificationP)) {
		criteria.addOrder(Order.asc("qualification"));
	}
	else if ("asc".equals(orderByGenderP)) {
		criteria.addOrder(Order.desc("gender"));
	}
	else if ("desc".equals(orderByGenderP)) {
		criteria.addOrder(Order.asc("gender"));
	}
	List<Provider> providerList = criteria.list();
	session.close();
	sf.close();
	return providerList;
}
static String orderByProviderIdP = "asc";
static String orderBySpecialityP = "sort";
static String orderByFirstNameP = "sort";
static String orderByLastNameP = "sort";
static String orderByQualificationP= "sort";
static String orderByGenderP = "sort";
static String orderByDateP = "sort";
static String orderByLicP = "sort";

public String sortByProviderIdP() {
	Map<String, Object> sessionMap = 
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	if (orderByProviderIdP.length() == 4) {
		orderByProviderIdP = "asc";
	} else if ("asc".equals(orderByProviderIdP)) {
		orderByProviderIdP = "desc";
	}
	sessionMap.put("orderByProviderIdP", orderByProviderIdP);
	return "PendingProvider.jsp?faces-redirect=true";
}
public String sortBySpecialityP() {
	Map<String, Object> sessionMap = 
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	if (orderBySpecialityP.length() == 4) {
		orderBySpecialityP = "asc";
		orderByProviderIdP = "sort";
	} else if ("asc".equals(orderBySpecialityP)) {
		orderBySpecialityP = "desc";
		orderByProviderIdP = "sort";
	}
	sessionMap.put("orderBySpecialityP", orderBySpecialityP);
	return "PendingProvider.jsp?faces-redirect=true";
}
public String sortByFirstNameP() {
	Map<String, Object> sessionMap =
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	if (orderByFirstNameP.length() == 4) {
		orderByFirstNameP = "asc";
		orderByProviderIdP = "sort";
		orderBySpecialityP="sort";
	} else if ("asc".equals(orderByFirstNameP)) {
		orderByFirstNameP = "desc";
		orderByProviderIdP= "sort";
		orderBySpecialityP="sort";
	}
	sessionMap.put("orderByFirstNameP", orderByFirstNameP);
	return "PendingProvider.jsp?faces-redirect=true";
	}

public String sortByLastNameP() {
	Map<String, Object> sessionMap =
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	if (orderByLastNameP.length() == 4) {
		orderByLastNameP = "asc";
		orderByProviderIdP= "sort";
		orderBySpecialityP="sort";
		orderByFirstNameP="sort";
	} else if ("asc".equals(orderByLastNameP)) {
		orderByLastNameP= "desc";
		orderByProviderIdP= "sort";
		orderBySpecialityP="sort";
		orderByFirstNameP="sort";
	}
	sessionMap.put("orderByLastNameP", orderByLastNameP);
	return "PendingProvider.jsp?faces-redirect=true";
	}
public String sortByQualificationP() {
	Map<String, Object> sessionMap =
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	if (orderByQualificationP.length() == 4) {
		orderByQualificationP = "asc";
		orderByProviderIdP = "sort";
		orderBySpecialityP="sort";
		orderByFirstNameP="sort";
		orderByLastNameP="sort";
	} else if ("asc".equals(orderByQualificationP)) {
		orderByQualificationP= "desc";
		orderByProviderIdP = "sort";
		orderBySpecialityP="sort";
		orderByFirstNameP="sort";
		orderByLastNameP="sort";
	}
	sessionMap.put("orderByQualificationP", orderByQualificationP);
	return "PendingProvider.jsp?faces-redirect=true";
}	
public String sortByGenderP() {
	Map<String, Object> sessionMap =
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	if (orderByGenderP.length() == 4) {
		orderByGenderP = "asc";
		orderByProviderIdP = "sort";
		orderBySpecialityP="sort";
		orderByFirstNameP="sort";
		orderByLastNameP="sort";
		orderByQualificationP="sort";
	} else if ("asc".equals(orderByGenderP)) {
		orderByGenderP= "desc";
		orderByProviderIdP = "sort";
		orderBySpecialityP="sort";
		orderByFirstNameP="sort";
		orderByLastNameP="sort";
		orderByQualificationP="sort";
	}
	sessionMap.put("orderByGenderP", orderByGenderP);
	return "PendingProvider.jsp?faces-redirect=true";
}	
}