package com.hemant.furniture.store.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hemant.furniture.store.dto.CustomerLoginObj;
import com.hemant.furniture.store.entity.Customer;
import com.hemant.furniture.store.entity.CustomerLogin;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM Customer");
		List<Customer> customers = query.list();
		return customers;
	}

	@Override
	public Customer getCustomerById(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, id);
		return customer;
	}
	
	@Override
	public void addCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
	}
	
	@Override
	public Customer checkIfUserExists(CustomerLoginObj customerLoginObj) {
		String username = customerLoginObj.getUsername();
		String password = customerLoginObj.getPassword();
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM CustomerLogin where username=:username AND password=:password");
		
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		CustomerLogin customerLogin = (CustomerLogin) query.uniqueResult();
		
		if(customerLogin != null) {
			Customer customer = customerLogin.getCustomer();
			return customer;
		}
		return null;
	}
}
