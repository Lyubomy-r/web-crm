package web.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import web.crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
				
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by last_name", Customer.class);
				
		List<Customer> customers = theQuery.getResultList();
							
		return customers;
	}
	
	@Override
	public void  setCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
	
	}
	
	@Override
	public Customer  getCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer customer=currentSession.get(Customer.class, theId );
		return customer;
	}
	
	@Override
	public void  upadeCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.update(theCustomer);
		
	}

	@Override
	public void deletCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer customer=currentSession.get(Customer.class, theId );
		
		currentSession.delete(customer);
		
	}
	
	@Override
	public void deletInQuery(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<?> deleCustomer=currentSession.createQuery("DELETE FROM Customer c where c.id=:customerId");
		deleCustomer.setParameter("customerId", theId);		
			
		deleCustomer.executeUpdate();
		
	}

	@Override
	public Customer searchCustomersone(String theSearchName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> searchName=currentSession.createQuery("from Customer where firstName like :theName or lastName like :theName", Customer.class);
		Customer customers = searchName.getSingleResult();
		 
		return customers;
				
	}
	
	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		 Session currentSession = sessionFactory.getCurrentSession();
		 Query theQuery = null;
		 
		 if (theSearchName != null && theSearchName.trim().length() > 0) {
			 theQuery =currentSession.createQuery("from Customer where lower(first_Name) like :theName or lower(last_Name) like :theName", Customer.class);
			 theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		 }else {
				
				 	theQuery =currentSession.createQuery("from Customer", Customer.class);
				  }
				
				List<Customer> customers = theQuery.getResultList();
				 
				return customers;
			 
		 
	}
}
