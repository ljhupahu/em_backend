package com.em.repositories.reference.zone;

import com.em.entities.reference.zone.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ZoneRepository extends JpaRepository<Zone, Long> {
	
	
	Zone findByCode(String code);
	
	@Query("select z from Zone z left join fetch z.descriptions zd where zd.language.id=?1")
	List<Zone> listByLanguage(Integer id);
	
	@Query("select z from Zone z left join fetch z.descriptions zd join fetch z.country zc where zc.isoCode=?1 and zd.language.id=?2")
	List<Zone> listByLanguageAndCountry(String isoCode, Integer languageId);

}
