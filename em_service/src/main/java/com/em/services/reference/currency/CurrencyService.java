package com.em.services.reference.currency;


import com.em.entities.reference.currency.Currency;
import com.em.services.common.generic.EMEntityService;

public interface CurrencyService extends EMEntityService<Long, Currency> {

	Currency getByCode(String code);

}
