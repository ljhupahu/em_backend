package com.em.services.reference.language;


import com.em.core.business.exception.ServiceException;
import com.em.entities.reference.language.Language;
import com.em.services.common.generic.EMEntityService;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public interface LanguageService extends EMEntityService<Integer, Language> {

	Language getByCode(String code) throws ServiceException;

	Map<String, Language> getLanguagesMap() throws ServiceException;

	List<Language> getLanguages() throws ServiceException;

	Locale toLocale(Language language);

	Language toLanguage(Locale locale);
	
	Language defaultLanguage();
}
