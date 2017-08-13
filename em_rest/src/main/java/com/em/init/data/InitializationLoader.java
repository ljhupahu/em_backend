package com.em.init.data;

import com.em.core.business.exception.ServiceException;
import com.em.entities.merchant.MerchantStore;
import com.em.services.merchant.MerchantStoreService;
import com.em.services.reference.init.InitializationDatabase;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * Created by Jet on 2017/8/13.
 */
@Component
public class InitializationLoader {
    @Inject
    private InitData initData;

    @Inject
    protected MerchantStoreService merchantService;

    @Inject
    private InitializationDatabase initializationDatabase;

    @PostConstruct
    public void init() throws ServiceException {
        System.out.println("============================init=");

        initializationDatabase.populate("sm-shop");
    }


    public void initInitialData() throws ServiceException {
        //create a merchant
        MerchantStore store = merchantService.getMerchantStore(MerchantStore.DEFAULT_STORE);
    }
}
