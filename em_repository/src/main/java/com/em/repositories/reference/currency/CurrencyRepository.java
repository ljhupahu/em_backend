package com.em.repositories.reference.currency;

import com.em.entities.reference.currency.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

	
	Currency getByCode(String code);
}
