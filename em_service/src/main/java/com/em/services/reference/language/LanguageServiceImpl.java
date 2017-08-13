package com.em.services.reference.language;

import com.em.core.business.exception.ServiceException;
import com.em.core.constants.Constants;
import com.em.entities.reference.language.Language;
import com.em.repositories.reference.language.LanguageRepository;
import com.em.services.common.generic.EMEntityServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * https://samerabdelkafi.wordpress.com/2014/05/29/spring-data-jpa/
 * @author c.samson
 *
 */

@Service("languageService")
public class LanguageServiceImpl extends EMEntityServiceImpl<Integer, Language>
	implements LanguageService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LanguageServiceImpl.class);
	

	
	private LanguageRepository languageRepository;
	
	@Inject
	public LanguageServiceImpl(LanguageRepository languageRepository) {
		super(languageRepository);
		this.languageRepository = languageRepository;
	}
	
	
	@Override
	public Language getByCode(String code) throws ServiceException {
		return languageRepository.findByCode(code);
	}
	
	@Override
	public Locale toLocale(Language language) {
		return new Locale(language.getCode());
	}
	
	@Override
	public Language toLanguage(Locale locale) {
		
		try {
			Language lang = getLanguagesMap().get(locale.getLanguage());
			return lang;
		} catch (Exception e) {
			LOGGER.error("Cannot convert locale " + locale.getLanguage() + " to language");
		}
		
		return new Language(Constants.DEFAULT_LANGUAGE);

	}
	
	@Override
	public Map<String,Language> getLanguagesMap() throws ServiceException {
		
		List<Language> langs = this.getLanguages();
		Map<String,Language> returnMap = new LinkedHashMap<String,Language>();
		
		for(Language lang : langs) {
			returnMap.put(lang.getCode(), lang);
		}
		return returnMap;

	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Language> getLanguages() throws ServiceException {
		
		
		List<Language> langs = null;
		try {

				langs = this.list();

		} catch (Exception e) {
			LOGGER.error("getCountries()", e);
			throw new ServiceException(e);
		}
		
		return langs;
		
	}
	
	@Override
	public Language defaultLanguage() {
		return toLanguage(Locale.ENGLISH);
	}

}
