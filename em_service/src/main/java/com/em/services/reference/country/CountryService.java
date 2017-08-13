package com.em.services.reference.country;


import com.em.core.business.exception.ServiceException;
import com.em.entities.reference.country.Country;
import com.em.entities.reference.country.CountryDescription;
import com.em.entities.reference.language.Language;
import com.em.services.common.generic.EMEntityService;

import java.util.List;
import java.util.Map;

public interface CountryService extends EMEntityService<Integer, Country> {

	public Country getByCode(String code) throws ServiceException;
	
	public void addCountryDescription(Country country, CountryDescription description) throws ServiceException;

	public List<Country> getCountries(Language language) throws ServiceException;

	Map<String, Country> getCountriesMap(Language language)
			throws ServiceException;

	List<Country> getCountries(List<String> isoCodes, Language language)
			throws ServiceException;
}
