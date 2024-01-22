package com.java.hib;

import java.text.ParseException;
import java.util.List;

public interface ProviderDetailsDAO {
	
	List<ProviderDetails> showProviderDetails();
	String searchProviderDetails(String providerid);
	String updateProviderDetails(ProviderDetails ProviderDetailsUpdate) throws ParseException;

}
