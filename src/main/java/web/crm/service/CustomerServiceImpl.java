package web.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.crm.dao.CustomerDAO;
import web.crm.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
		
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public  void setCustomer(Customer theCustomer){
		customerDAO.setCustomer(theCustomer);
	}
	
	@Override
	@Transactional
	public void  upadeCustomer(Customer theCustomer) {
		customerDAO.upadeCustomer(theCustomer);
	}
	
	@Override
	@Transactional
	public Customer  getCustomer(int theId) {
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deletCustomer(int theId) {
		
		customerDAO.deletCustomer(theId);
	}
	
	@Override
	@Transactional
	public void deletInQuery(int theId) {
	customerDAO.deletInQuery(theId);
	}
	
	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName){
		
		return customerDAO.searchCustomers(theSearchName);
	}
	
	@Override
	@Transactional
	public Customer searchCustomersone(String theSearchName) {
		
		return customerDAO.searchCustomersone(theSearchName);
	}
}