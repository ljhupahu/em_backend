package com.em.repositories.merchant;

import com.em.entities.merchant.MerchantStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MerchantRepository extends JpaRepository<MerchantStore, Integer> {

	@Query("select m from MerchantStore m left join fetch m.country mc left join fetch m.currency mc left join fetch m.zone mz left join fetch m.defaultLanguage md left join fetch m.languages mls where m.code = ?1")
	MerchantStore findByCode(String code);
}
