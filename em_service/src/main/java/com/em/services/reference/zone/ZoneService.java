package com.em.services.reference.zone;


import com.em.core.business.exception.ServiceException;
import com.em.entities.reference.country.Country;
import com.em.entities.reference.language.Language;
import com.em.entities.reference.zone.Zone;
import com.em.entities.reference.zone.ZoneDescription;
import com.em.services.common.generic.EMEntityService;

import java.util.List;
import java.util.Map;

public interface ZoneService extends EMEntityService<Long, Zone> {
	
	Zone getByCode(String code);

	void addDescription(Zone zone, ZoneDescription description) throws ServiceException;

	List<Zone> getZones(Country country, Language language)
			throws ServiceException;

	Map<String, Zone> getZones(Language language) throws ServiceException;


}
