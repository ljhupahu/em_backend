package com.em.services.reference.zone;

import com.em.core.business.exception.ServiceException;
import com.em.core.constants.Constants;
import com.em.entities.reference.country.Country;
import com.em.entities.reference.language.Language;
import com.em.entities.reference.zone.Zone;
import com.em.entities.reference.zone.ZoneDescription;
import com.em.repositories.reference.zone.ZoneRepository;
import com.em.services.common.generic.EMEntityServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("zoneService")
public class ZoneServiceImpl extends EMEntityServiceImpl<Long, Zone> implements
		ZoneService {
	
	private final static String ZONE_CACHE_PREFIX = "ZONES_";

	private ZoneRepository zoneRepository;
	

	
	private static final Logger LOGGER = LoggerFactory.getLogger(ZoneServiceImpl.class);

	@Inject
	public ZoneServiceImpl(ZoneRepository zoneRepository) {
		super(zoneRepository);
		this.zoneRepository = zoneRepository;
	}

	@Override
	public Zone getByCode(String code) {
		return zoneRepository.findByCode(code);
	}

	@Override
	public void addDescription(Zone zone, ZoneDescription description) throws ServiceException {
		if (zone.getDescriptions()!=null) {
				if(!zone.getDescriptions().contains(description)) {
					zone.getDescriptions().add(description);
					update(zone);
				}
		} else {
			List<ZoneDescription> descriptions = new ArrayList<ZoneDescription>();
			descriptions.add(description);
			zone.setDescriptons(descriptions);
			update(zone);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Zone> getZones(Country country, Language language) throws ServiceException {
		
		List<Zone> zones = null;
		try {

			String cacheKey = ZONE_CACHE_PREFIX + country.getIsoCode() + Constants.UNDERSCORE + language.getCode();
			
//			zones = (List<Zone>) cache.getFromCache(cacheKey);
//
//
//
//			if(zones==null) {
			
				zones = zoneRepository.listByLanguageAndCountry(country.getIsoCode(), language.getId());
			
				//set names
				for(Zone zone : zones) {
					ZoneDescription description = zone.getDescriptions().get(0);
					zone.setName(description.getName());
					
				}
//				cache.putInCache(zones, cacheKey);
//			}

		} catch (Exception e) {
			LOGGER.error("getZones()", e);
		}
		return zones;
		
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Zone> getZones(Language language) throws ServiceException {
		
		Map<String, Zone> zones = null;
		try {

			String cacheKey = ZONE_CACHE_PREFIX + language.getCode();
			
//			zones = (Map<String, Zone>) cache.getFromCache(cacheKey);
//
//
//
//			if(zones==null) {
				zones = new HashMap<String, Zone>();
				List<Zone> zns = zoneRepository.listByLanguage(language.getId());
			
				//set names
				for(Zone zone : zns) {
					ZoneDescription description = zone.getDescriptions().get(0);
					zone.setName(description.getName());
					zones.put(zone.getCode(), zone);
					
				}
//				cache.putInCache(zones, cacheKey);
//			}

		} catch (Exception e) {
			LOGGER.error("getZones()", e);
		}
		return zones;
		
		
	}

}
