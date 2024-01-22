package com.java.hib;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ProviderDAO {
	


    String reviewProvider(String providerId);

    String searchProvider(String providerId);

    List<Provider> filterProvidersByStatus(String status);

    List<Provider> approvedProvider();

    List<Provider> rejectedProvider();

    List<Provider> pendingProvider();

    int calculateYearDifference(Date startDate, Date endDate);

    String validating() throws ParseException;

    Doctor searchDoc(String speciality);

    String commentsPage(String providerId, Provider provider);
    List<Provider> getListOfProvider(int firstRow, int rowCount);

    String sortByProviderId();

    String sortBySpeciality();

    String sortByFirstName();

    String sortByLastName();

    String sortByQualification();

	
}
