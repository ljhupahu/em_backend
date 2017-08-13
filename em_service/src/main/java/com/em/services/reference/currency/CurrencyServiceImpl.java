package com.em.services.reference.currency;

import com.em.entities.reference.currency.Currency;
import com.em.repositories.reference.currency.CurrencyRepository;
import com.em.services.common.generic.EMEntityServiceImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service("currencyService")
public class CurrencyServiceImpl extends EMEntityServiceImpl<Long, Currency>
	implements CurrencyService {
	
	private CurrencyRepository currencyRepository;
	
	@Inject
	public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
		super(currencyRepository);
		this.currencyRepository = currencyRepository;
	}

	@Override
	public Currency getByCode(String code) {
		return currencyRepository.getByCode(code);
	}

}
