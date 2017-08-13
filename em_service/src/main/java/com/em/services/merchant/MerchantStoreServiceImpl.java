package com.em.services.merchant;

import com.em.core.business.exception.ServiceException;
import com.em.entities.merchant.MerchantStore;
import com.em.repositories.merchant.MerchantRepository;
import com.em.services.common.generic.EMEntityServiceImpl;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service("merchantService")
public class MerchantStoreServiceImpl extends EMEntityServiceImpl<Integer, MerchantStore>
		implements MerchantStoreService {
	

		
//	@Inject
//	protected ProductTypeService productTypeService;
//
//	@Inject
//	private TaxClassService taxClassService;
	
/*	@Inject
	private ContentService contentService;
	
	@Inject
	private MerchantConfigurationService merchantConfigurationService;
	
	@Inject
	private CategoryService categoryService;
	
	@Inject
	private UserService userService;
	
	@Inject
	private OrderService orderService;
	
	@Inject
	private CustomerService customerService;*/
	
//	@Inject
//	private ManufacturerService manufacturerService;
	
	private MerchantRepository merchantRepository;
	
	@Inject
	public MerchantStoreServiceImpl(MerchantRepository merchantRepository) {
		super(merchantRepository);
		this.merchantRepository = merchantRepository;
	}


	public MerchantStore getMerchantStore(String merchantStoreCode) throws ServiceException {
		return merchantRepository.findByCode(merchantStoreCode);
	}
	
	@Override
	public void saveOrUpdate(MerchantStore store) throws ServiceException {
		super.save(store);

	}
	

	@Override
	public MerchantStore getByCode(String code) throws ServiceException {
		
		return merchantRepository.findByCode(code);
	}
	
/*	@Override
	public void delete(MerchantStore merchant) throws ServiceException {
		
		merchant = this.getById(merchant.getId());
		
		
		//reference
		List<Manufacturer> manufacturers = manufacturerService.listByStore(merchant);
		for(Manufacturer manufacturer : manufacturers) {
			manufacturerService.delete(manufacturer);
		}
		
		List<MerchantConfiguration> configurations = merchantConfigurationService.listByStore(merchant);
		for(MerchantConfiguration configuration : configurations) {
			merchantConfigurationService.delete(configuration);
		}
		

		//TODO taxService
		List<TaxClass> taxClasses = taxClassService.listByStore(merchant);
		for(TaxClass taxClass : taxClasses) {
			taxClassService.delete(taxClass);
		}
		
		//content
		contentService.removeFiles(merchant.getCode());
		//TODO staticContentService.removeImages
		
		//category / product
		List<Category> categories = categoryService.listByStore(merchant);
		for(Category category : categories) {
			categoryService.delete(category);
		}

		//users
		List<User> users = userService.listByStore(merchant);
		for(User user : users) {
			userService.delete(user);
		}
		
		//customers
		List<Customer> customers = customerService.listByStore(merchant);
		for(Customer customer : customers) {
			customerService.delete(customer);
		}
		
		//orders
		List<Order> orders = orderService.listByStore(merchant);
		for(Order order : orders) {
			orderService.delete(order);
		}
		
		super.delete(merchant);
		
	}*/

}
