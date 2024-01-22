package com.java.hib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ProviderDetailsDAOImpl implements ProviderDetailsDAO {
	
	SessionFactory sf;
	Session session;

	@Override
	public List<ProviderDetails> showProviderDetails() {
		sf = SessionHelper.getConnection();
		session=sf.openSession();
		Criteria cr = session.createCriteria(ProviderDetails.class);
		List<ProviderDetails> ProviderList=cr.list();
		return ProviderList;
	}

	@Override
	public String searchProviderDetails(String providerid) {
		System.out.println("From controller : "+providerid);
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Query query = session.createQuery("from ProviderDetails where providerid= ?");
		query.setParameter(0, providerid);
		System.out.println("Search "+providerid);
		List<ProviderDetails> providerList = query.list();
		System.out.println("Saerch "+providerList);
		ProviderDetails provider = providerList.get(0);
		sessionMap.put("editProvider", provider);
		System.err.println(provider);
		return"UpdateProviderDetails.jsp?faces-redirect=true";
		
	}

	@Override
	public String updateProviderDetails(ProviderDetails ProviderDetailsUpdate) throws ParseException {
		Map<String, Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		System.out.println("Inside update provider details");
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria criteria = session.createCriteria(ProviderDetails.class);
		Transaction trans = session.beginTransaction();
		
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
		String formattedDate = dateFormat.format(currentDate);
        Date parsedDate = dateFormat.parse(formattedDate);
        ProviderDetailsUpdate.setUpdatedDate(parsedDate);;
		
		session.update(ProviderDetailsUpdate);
		trans.commit();
		return "ShowProviderDetailsP.jsp?faces-redirect=true";
	}
	
//	public ProviderDetails searchProvider2(String providerId2) {
//		Map<String, Object> sessionMap = 
//				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//		sf = SessionHelper.getConnection();
//		session = sf.openSession();
//		Criteria criteria = session.createCriteria(ProviderDetails.class);
//		criteria.add(Restrictions.eq("providerId", providerId2));
//		System.out.println("SearchProvider Called "+providerId2);
//		ProviderDetails providerData = (ProviderDetails) criteria.uniqueResult();
//		return providerData;
//	}
	
	public List<ProviderDetails> getListOfProvider(int firstRow, int rowCount) throws ParseException {
		
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		List<Patientenrollment> cdList = null;
			session.beginTransaction();
			Criteria criteria = session.createCriteria(ProviderDetails.class);
			criteria.setFirstResult(firstRow);
			criteria.setMaxResults(rowCount);
			return criteria.list();
	}
	
	public int countRows() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(ProviderDetails.class);
			if (criteria != null) {
				return criteria.list().size();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
