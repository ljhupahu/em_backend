package com.em.services.merchant;

import com.em.core.business.exception.ServiceException;
import com.em.entities.generic.EMEntity;
import com.em.entities.merchant.MerchantStore;
import com.em.services.common.generic.EMEntityService;

/**
 * Created by Jet on 2017/8/13.
 */
public interface MerchantStoreService  extends EMEntityService<Integer, MerchantStore> {


    MerchantStore getMerchantStore(String merchantStoreCode)
            throws ServiceException;

    MerchantStore getByCode(String code) throws ServiceException ;

    void saveOrUpdate(MerchantStore store) throws ServiceException;
}
