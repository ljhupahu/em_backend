package com.em.repositories.reference.language;

import com.em.core.business.exception.ServiceException;
import com.em.entities.reference.language.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
	
	Language findByCode(String code) throws ServiceException;
	


}
