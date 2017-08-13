package com.em.services.reference.init;


import com.em.core.business.exception.ServiceException;

public interface InitializationDatabase {
	
	boolean isEmpty();
	
	void populate(String name) throws ServiceException;

}
