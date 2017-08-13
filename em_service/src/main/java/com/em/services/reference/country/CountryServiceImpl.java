package com.em.services.reference.country;

import com.em.core.business.exception.ServiceException;
import com.em.entities.reference.country.Country;
import com.em.entities.reference.country.CountryDescription;
import com.em.entities.reference.language.Language;
import com.em.repositories.reference.CountryRepository;
import com.em.services.common.generic.EMEntityServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service("countryService")
public class CountryServiceImpl extends EMEntityServiceImpl<Integer, Country>
		implements CountryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceImpl.class);
	
	private CountryRepository countryRepository;
	

	@Inject
	public CountryServiceImpl(CountryRepository countryRepository) {
		super(countryRepository);
		this.countryRepository = countryRepository;
	}
	
	public Country getByCode(String code) throws ServiceException {
		return countryRepository.findByIsoCode(code);
	}

	@Override
	public void addCountryDescription(Country country, CountryDescription description) throws ServiceException {
		country.getDescriptions().add(description);
		description.setCountry(country);
		update(country);
	}
	
	@Override
	public Map<String,Country> getCountriesMap(Language language) throws ServiceException {
		
		List<Country> countries = this.getCountries(language);
		
		Map<String,Country> returnMap = new LinkedHashMap<String,Country>();
		
		for(Country country : countries) {
			returnMap.put(country.getIsoCode(), country);
		}
		
		return returnMap;
	}
	
	
	@Override
	public List<Country> getCountries(final List<String> isoCodes, final Language language) throws ServiceException {
		List<Country> countryList = getCountries(language);
		List<Country> requestedCountryList = new ArrayList<Country>();
		if(!CollectionUtils.isEmpty(countryList)) {
			for(Country c : countryList) {
				if(isoCodes.contains(c.getIsoCode())) {
					requestedCountryList.add(c);
				}
			}
		}
		return requestedCountryList;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Country> getCountries(Language language) throws ServiceException {
		
		List<Country> countries = null;
		try {


			
				countries = countryRepository.listByLanguage(language.getId());
			
				//set names
				for(Country country : countries) {
					
					CountryDescription description = country.getDescriptions().get(0);
					country.setName(description.getName());
					
				}
				

		
		
		} catch (Exception e) {
			LOGGER.error("getCountries()", e);
		}
		
		return countries;
		
		
	}


}
