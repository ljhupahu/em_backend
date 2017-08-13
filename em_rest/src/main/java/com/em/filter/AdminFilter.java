package com.em.filter;

import com.em.core.constants.Constants;
import com.em.entities.merchant.MerchantStore;
import com.em.services.merchant.MerchantStoreService;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Jet on 2017/8/12.
 */
public class AdminFilter extends HandlerInterceptorAdapter {
    @Inject
    private MerchantStoreService merchantService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        System.out.println("=================");

        String storeCode = MerchantStore.DEFAULT_STORE;
        MerchantStore store = (MerchantStore)request.getSession().getAttribute(Constants.ADMIN_STORE);

        if(store==null) {
            store = merchantService.getByCode(storeCode);
            request.getSession().setAttribute(Constants.ADMIN_STORE, store);
        }


        return true;
    }
}
