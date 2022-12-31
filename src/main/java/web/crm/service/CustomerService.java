package web.crm.service;

import java.util.List;

import web.crm.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public  void setCustomer(Customer theCustomer) ;
	
	public void  upadeCustomer(Customer theCustomer);
	
	public Customer  getCustomer(int theId);

	public void deletCustomer(int theId);
	
	public void deletInQuery(int theId);
	
	public List<Customer> searchCustomers(String theSearchName);
	
	public Customer searchCustomersone(String theSearchName) ;

}
