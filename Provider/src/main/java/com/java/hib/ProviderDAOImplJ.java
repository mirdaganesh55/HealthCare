package com.java.hib;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ProviderDAOImplJ<ProviderDAO> {
	SessionFactory sf;
	Session session;
	
	
	public List<ProviderJ> getProvidersByStatus(int firstRow, int rowCount,String isActive) {
	    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    SessionFactory sf = SessionHelper.getConnection();
	    Session session = sf.openSession();
	    Criteria cr = session.createCriteria(ProviderJ.class);

	    if (isActive != null && !isActive.isEmpty()) {
	        cr.add(Restrictions.eq("isActive", isActive.toUpperCase()));
	    }
//	    if(orderByProviderId.equals("asc")) {
//
//	    	cr.addOrder(Order.asc("providerId"));
//
//		}else if(orderByProviderId.equals("desc")){
//
//			cr.addOrder(Order.desc("providerId"));
//
//		}
	    
	    cr.setFirstResult(firstRow);
		cr.setMaxResults(rowCount);
	    List<ProviderJ> providerList = cr.list();
	    sessionMap.put("providerList", providerList);
	    return providerList;
	}

		
	
	static void resetSession() {
		Map<String,Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.clear();		
    }
	
	public String searchProvider(String providerId) {
		Map<String, Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(ProviderJ.class);
		criteria.add(Restrictions.eq("providerId", providerId));
		ProviderJ providerData = (ProviderJ) criteria.uniqueResult();
		sessionMap.put("providerListNew", providerData);
		System.out.println("test1234 " + providerData);
		if (providerData != null) {
			sessionMap.put("providerId", providerData.getProviderId());
			System.out.println("==================" + providerData);
		}
		return "ShowProviderDetails.jsp?faces-redirect=true";
	}
	
	public String providerId(String providerId) {	
		System.out.println("proviet"+providerId);
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(ProviderJ.class);
		cr.add(Restrictions.eq("providerId", providerId));
		System.out.println(providerId);
		List<ProviderJ> providerList = cr.list();
		sessionMap.put("providerList", providerList);
		System.out.println(providerList);
		return "ShowProviderDetails.jsp?faces-redirect=true";
	}
	public String redirectToProviderDetails(String providerId) {
	    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    
	    ProviderDAOImplJ providerDAO = new ProviderDAOImplJ(); 
	    List providerFound = providerDAO.getProviderById(providerId);
	    
	    sessionMap.put("providerFound", providerFound);
	    System.out.println("test : " + providerFound);
	    
	    return "ShowProviderDetails.jsp?faces-redirect=true";
	}
	
	public List<ProviderJ> getProviderById(String providerId) {
	    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    SessionFactory sf = SessionHelper.getConnection();
	    Session session = sf.openSession();
	    Criteria cr = session.createCriteria(ProviderJ.class);
	    if (providerId != null && !providerId.isEmpty()) {
	        cr.add(Restrictions.eq("providerId",providerId));
	    }
	    
	   
	    List<ProviderJ> providerList = cr.list();
	    sessionMap.put("providerList", providerList);
	    return providerList;
	}

	
	
	public List showProviderDao() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(ProviderJ.class);
		List<ProviderJ> providerList = criteria.list();
		return providerList;
	}
	
	public List<ProviderJ> getIdLists(int firstRow, int rowCount,String providerId) {
	    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    SessionFactory sf = SessionHelper.getConnection();
	    Session session = sf.openSession();
	    Criteria cr = session.createCriteria(ProviderJ.class);
//	    cr.add(Restrictions.eqOrIsNull("providerId", providerId));
	    if (providerId != null && !providerId.isEmpty()) {
	        // Use the "like" operator to match any character in the PROV field
	        cr.add(Restrictions.ilike("providerId", "%" + providerId + "%"));
	    }
//	    if(orderByProviderId.equals("asc")) {
//
//	    	cr.addOrder(Order.asc("providerId"));
//
//		}else if(orderByProviderId.equals("desc")){
//
//			cr.addOrder(Order.desc("providerId"));
//
//		}
	    
	    cr.setFirstResult(firstRow);
		cr.setMaxResults(rowCount);
	    List<ProviderJ> providerList = cr.list();
	    sessionMap.put("providerList", providerList);
	    return providerList;
	}
	public List<ProviderJ> getUsLists(int firstRow, int rowCount,String username) {
	    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    System.out.println("GetUsLists Method Hitted...");
	    SessionFactory sf = SessionHelper.getConnection();
	    Session session = sf.openSession();
	    Criteria cr = session.createCriteria(ProviderJ.class);
	        cr.add(Restrictions.ilike("username", "%" + username + "%"));
	    
	    cr.setFirstResult(firstRow);
		cr.setMaxResults(rowCount);
	    List<ProviderJ> providerList = cr.list();
	    sessionMap.put("providerList", providerList);
	    return providerList;
	}
	public List<ProviderJ> getFnLists(int firstRow, int rowCount,String firstName) {
	    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    SessionFactory sf = SessionHelper.getConnection();
	    Session session = sf.openSession();
	    Criteria cr = session.createCriteria(ProviderJ.class);
	    if (firstName != null && !firstName.isEmpty()) {
	        cr.add(Restrictions.ilike("firstName", "%" + firstName + "%"));
	    }
	    
	    cr.setFirstResult(firstRow);
		cr.setMaxResults(rowCount);
	    List<ProviderJ> providerList = cr.list();
	    sessionMap.put("providerList", providerList);
	    return providerList;
	}
	public List<ProviderJ> getSpLists(int firstRow, int rowCount,String speciality) {
	    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    SessionFactory sf = SessionHelper.getConnection();
	    Session session = sf.openSession();
	    Criteria cr = session.createCriteria(ProviderJ.class);
	    if (speciality != null && !speciality.isEmpty()) {
	        cr.add(Restrictions.ilike("speciality", "%" + speciality + "%"));
	    }
	    
	    cr.setFirstResult(firstRow);
		cr.setMaxResults(rowCount);
	    List<ProviderJ> providerList = cr.list();
	    sessionMap.put("providerList", providerList);
	    return providerList;
	}
	public List<ProviderJ> getListOfProvider(int firstRow, int rowCount,ProviderJ provider) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(ProviderJ.class);
			criteria.setFirstResult(firstRow);
			criteria.setMaxResults(rowCount);
		return criteria.list();
	}
	public int countRows(ProviderJ provider) {
		
		 String sat = provider.getIsActive();
		    String idd = provider.getProviderId();
		    String uss = provider.getUsername();
		    String fnn = provider.getFirstName();


		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		sf = SessionHelper.getConnection();

		session = sf.openSession();

		try {
			
			session.beginTransaction();
			Criteria cr = session.createCriteria(ProviderJ.class);

			if (null!= sat && sat.length()!=0) {
//			       return getProvidersByStatus(firstRow,rowCount,provider.getIsActive());
				 cr.add(Restrictions.eq("isActive", provider.getIsActive().toUpperCase()));
//				 sessionMap.put("isActive",provider.getIsActive().toUpperCase() );
			    } 

			 if (idd!=null && idd.length()!=0 ) {
//			       return getIdLists(firstRow,rowCount,provider.getProviderId());
			        cr.add(Restrictions.ilike("providerId", "%" + provider.getProviderId() + "%"));
//					 sessionMap.put("providerId",provider.getProviderId() );


			    } 
			 if (uss!=null && uss.length()!=0) {
//			    	System.out.println("Individual User Hitted...");
//			    	return getUsLists(firstRow,rowCount,provider.getUsername());
			        cr.add(Restrictions.ilike("username", "%" + provider.getUsername() + "%"));
//					 sessionMap.put("username",provider.getUsername() );


			    } 
			 	if (fnn.length() != 0 && fnn!=null) {
//			      return  getFnLists(firstRow,rowCount,provider.getFirstName());
			        cr.add(Restrictions.ilike("firstName", "%" + provider.getFirstName() + "%"));
//					 sessionMap.put("firstName",provider.getFirstName() );


			    }
			 
			if (provider.getSpeciality()!=null && provider.getSpeciality().length() !=0) {
				 if (null!= provider.getIsActive() && provider.getIsActive().length()!=0) {
					 cr.add(Restrictions.and(
							    Restrictions.eq("isActive",  provider.getIsActive().toUpperCase()),
							    Restrictions.ilike("speciality", "%" + provider.getSpeciality() + "%")
							));


				 }else if (provider.getProviderId().length()!=0 ) {
				        cr.add(Restrictions.and(
				        		Restrictions.ilike("providerId", "%" + provider.getProviderId() + "%"),
				        		Restrictions.ilike("speciality", "%" + provider.getSpeciality() + "%")
							));


				    }else if (provider.getUsername().length()!=0 ) {
				        cr.add(Restrictions.and(
				        		Restrictions.ilike("username", "%" + provider.getUsername() + "%"),
				        		Restrictions.ilike("speciality", "%" + provider.getSpeciality() + "%")
							));


				    }else if (provider.getFirstName().length()!=0 ) {
				        cr.add(Restrictions.and(
				        		Restrictions.ilike("firstName", "%" + provider.getFirstName() + "%"),
				        		Restrictions.ilike("speciality", "%" + provider.getSpeciality() + "%")
							));


				    }else {
				        cr.add(Restrictions.ilike("speciality", "%" + provider.getSpeciality() + "%"));

				    	
				    }
				
			
				
			}
			if (cr != null) {
				return cr.list().size();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return 0;

	}
	
	static String orderByProviderId = "asc";

	public String sortByProviderId() {
	    Map<String, Object> sessionMap = 
	    		FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    
	    if(orderByProviderId.length() == 4) {
	        orderByProviderId = "asc";
	    } else if("asc".equals(orderByProviderId)) {
	    	System.out.println("desc order");
	        orderByProviderId = "desc";
	    }
	    sessionMap.put("orderByProviderId", orderByProviderId);
	    return "Search_final.jsp?faces-redirect=true";
    }

	


//	public int countRows() {
//		SessionFactory sf = SessionHelper.getConnection();
//		Session session = sf.openSession();
//		try {
//			session.beginTransaction();
//			Criteria criteria = session.createCriteria(Provider.class);
//			if (criteria != null) {
//				return criteria.list().size();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
public List<ProviderJ> searchProviders(int firstRow, int rowCount,ProviderJ provider) {
	List<ProviderJ> providerList = null;
	SessionFactory sf = SessionHelper.getConnection();
	Session session = sf.openSession();
	Criteria cr = session.createCriteria(ProviderJ.class);
    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    FacesContext cont = FacesContext.getCurrentInstance();
    String sat = provider.getIsActive();
    String idd = provider.getProviderId();
    String uss = provider.getUsername();
    String fnn = provider.getFirstName();
    String Spp = provider.getSpeciality();



    if ((fnn == null || fnn.isEmpty()) && (Spp == null || Spp.isEmpty()) && (uss == null || uss.isEmpty())&& (idd == null || idd.isEmpty())&& (sat == null || sat.isEmpty())) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please provide at least one search parameter.", null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        return null; // Returning null to stay on the same page
    }
    
	//		System.out.println("isAc  "+provider.getIsActive());
//		System.out.println("spe  "+provider.getSpeciality());
//		System.out.println(null!= provider.getIsActive());

		 if (null!= sat && sat.length()!=0) {
//		       return getProvidersByStatus(firstRow,rowCount,provider.getIsActive());
			 cr.add(Restrictions.eq("isActive", provider.getIsActive().toUpperCase()));
//			 sessionMap.put("isActive",provider.getIsActive().toUpperCase() );
		    } 
		

		 if (idd!=null && idd.length()!=0 ) {
//		       return getIdLists(firstRow,rowCount,provider.getProviderId());
		        cr.add(Restrictions.ilike("providerId", "%" + provider.getProviderId() + "%"));
//				 sessionMap.put("providerId",provider.getProviderId() );
		    
		 List<ProviderJ> provList1 = cr.list();
 		
			
		    boolean recordsFound1 = provList1.stream()
		            .anyMatch(poo -> poo.getProviderId().toLowerCase().contains(provider.getProviderId().toLowerCase()));

		    if (!recordsFound1) {
		        // handle the case where no records are found in the specified date range
		        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record Not Found", null);
		        FacesContext.getCurrentInstance().addMessage(null, message);
 		}
		    }
		 if (uss!=null && uss.length()!=0) {
//		    	System.out.println("Individual User Hitted...");
//		    	return getUsLists(firstRow,rowCount,provider.getUsername());
		        cr.add(Restrictions.ilike("username", "%" + provider.getUsername() + "%"));
//				 sessionMap.put("username",provider.getUsername() );


		    
		 List<ProviderJ> provList3 = cr.list();
	 		
			
		    boolean recordsFound3 = provList3.stream()
		            .anyMatch(poo -> poo.getUsername().toLowerCase().contains(provider.getUsername().toLowerCase()));

		    if (!recordsFound3) {
		        // handle the case where no records are found in the specified date range
		        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record Not Found", null);
		        FacesContext.getCurrentInstance().addMessage(null, message);
		}
		    }
		 	if (fnn.length() != 0 && fnn!=null) {
//		      return  getFnLists(firstRow,rowCount,provider.getFirstName());
		        cr.add(Restrictions.ilike("firstName", "%" + provider.getFirstName() + "%"));
//				 sessionMap.put("firstName",provider.getFirstName() );


		    
		 	 List<ProviderJ> provList4 = cr.list();
		 		
				
			    boolean recordsFound4 = provList4.stream()
			            .anyMatch(poo -> poo.getFirstName().toLowerCase().contains(provider.getFirstName().toLowerCase()));

			    if (!recordsFound4) {
			        // handle the case where no records are found in the specified date range
			        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record Not Found ", null);
			        FacesContext.getCurrentInstance().addMessage(null, message);
			}
		 	}
		 
		if (provider.getSpeciality()!=null && provider.getSpeciality().length() !=0) {
			 if (null!= provider.getIsActive() && provider.getIsActive().length()!=0) {
				 cr.add(Restrictions.and(
						    Restrictions.eq("isActive",  provider.getIsActive().toUpperCase()),
						    Restrictions.ilike("speciality", "%" + provider.getSpeciality() + "%")
						));
				 List<ProviderJ> provList7 = cr.list();
			 		
					
				    boolean recordsFound7 = provList7.stream()
				            .anyMatch(poo -> poo.getSpeciality().toLowerCase().contains(provider.getSpeciality().toLowerCase()));

				    if (!recordsFound7) {
				        // handle the case where no records are found in the specified date range
				        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record Not Found", null);
				        FacesContext.getCurrentInstance().addMessage(null, message);
				    }
				 

			 }else if (provider.getProviderId().length()!=0 ) {
			        cr.add(Restrictions.and(
			        		Restrictions.ilike("providerId", "%" + provider.getProviderId() + "%"),
			        		Restrictions.ilike("speciality", "%" + provider.getSpeciality() + "%")
						));
			   	 List<ProviderJ> provList2 = cr.list();
			 		
					
				    boolean recordsFound2 = provList2.stream()
				            .anyMatch(poo -> poo.getProviderId().toLowerCase().contains(provider.getProviderId().toLowerCase()));

				    if (!recordsFound2) {
				        // handle the case where no records are found in the specified date range
				        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record Not Found", null);
				        FacesContext.getCurrentInstance().addMessage(null, message);
		 		}

			    }else if (provider.getUsername().length()!=0 ) {
			        cr.add(Restrictions.and(
			        		Restrictions.ilike("username", "%" + provider.getUsername() + "%"),
			        		Restrictions.ilike("speciality", "%" + provider.getSpeciality() + "%")
						));
                    List<ProviderJ> provList5 = cr.list();
			 		
					
				    boolean recordsFound5 = provList5.stream()
				            .anyMatch(poo -> poo.getUsername().toLowerCase().contains(provider.getUsername().toLowerCase()));

				    if (!recordsFound5) {
				        // handle the case where no records are found in the specified date range
				        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record Not Found", null);
				        FacesContext.getCurrentInstance().addMessage(null, message);

				    }

			    }else if (provider.getFirstName().length()!=0 ) {
			        cr.add(Restrictions.and(
			        		Restrictions.ilike("firstName", "%" + provider.getFirstName() + "%"),
			        		Restrictions.ilike("speciality", "%" + provider.getSpeciality() + "%")
						));
			        List<ProviderJ> provList6 = cr.list();
			 		
					
				    boolean recordsFound6 = provList6.stream()
				            .anyMatch(poo -> poo.getFirstName().toLowerCase().contains(provider.getFirstName().toLowerCase()));

				    if (!recordsFound6) {
				        // handle the case where no records are found in the specified date range
				        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Record Not Found", null);
				        FacesContext.getCurrentInstance().addMessage(null, message);
				    }

			    }else {
			        cr.add(Restrictions.ilike("speciality", "%" + provider.getSpeciality() + "%"));

			    	
			    }
			
		}
//			providerList= getSpLists(firstRow,rowCount,provider.getSpeciality());
//		providerList=(List<Provider>) cr.add(Restrictions.ilike("speciality", "%" + provider.getSpeciality() + "%"));
//
//			System.out.println(providerList);
//			if (provider.getFirstName().length()!=0) {
//				List<Provider> providerNew = new ArrayList<Provider>();
//				for (Provider provider2 : providerList) {
//					if (provider2.getFirstName().contains(provider.getFirstName())) {
//						providerNew.add(provider2);
//					}
//				}
//				providerList = providerNew;
//			}
//			else {
//				providerList= getSpLists(firstRow,rowCount,provider.getSpeciality());
//				System.out.println(providerList);
//			}
//			 if (provider.getUsername().length()!=0) {
//				List<Provider> providerNew = new ArrayList<Provider>();
//				for (Provider provider2 : providerList) {
//					if (provider2.getUsername().contains(provider.getUsername())) {
//						providerNew.add(provider2);
//					}
//				}
//			
//				providerList = providerNew;
//		}else if (provider.getProviderId().length()!=0) {
//			List<Provider> providerNew = new ArrayList<Provider>();
//			for (Provider provider2 : providerList) {
//				if (provider2.getProviderId().contains(provider.getProviderId())) {
//					providerNew.add(provider2);
//				}
//			}
//			
//			
//		
//			providerList = providerNew;
//		}else if (provider.getIsActive().length()!=0) {
//			List<Provider> providerNew = new ArrayList<Provider>();
//			for (Provider provider2 : providerList) {
//				if (provider2.getIsActive().equals(provider.getIsActive())) {
//					providerNew.add(provider2);
//				}
//			}
//			
//			
//		
//			System.out.println("Updated List " +providerNew);
//			providerList = providerNew;
//		}
//		}
		if("asc".equals(orderByProviderId)) {
		 cr.addOrder(Order.asc("providerId"));
		 
		}else if("desc".equals(orderByProviderId)){
			cr.addOrder(Order.desc("providerId"));
			}
		cr.setFirstResult(firstRow);
		cr.setMaxResults(rowCount);
		providerList=cr.list();
		
		System.out.println("Default List is  " +providerList);
//	    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    sessionMap.put("providerList", providerList);
		return providerList;
	   
	}



	



}



