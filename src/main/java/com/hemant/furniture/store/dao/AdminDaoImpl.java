package com.hemant.furniture.store.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hemant.furniture.store.entity.Admin;
import com.hemant.furniture.store.entity.Customer;
import com.hemant.furniture.store.service.CustomerService;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CustomerService customerService;

	@Override
	public Admin checkIfAdminExists(Admin admin) {
		String username = admin.getUsername();
		String password = admin.getPassword();

		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM Admin where username=:username AND password=:password");

		query.setParameter("username", username);
		query.setParameter("password", password);

		Admin retrievedAdmin = (Admin) query.uniqueResult();

		if (retrievedAdmin != null) {
			return retrievedAdmin;
		}
		return null;
	}

	public void deleteOrderOfACustomer(long customerId, long orderId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Customer customer = customerService.getCustomerById(customerId);
		
		if (customer != null) {
			Query query = currentSession.createQuery("delete from Order where customer = :customer AND id=:orderId");
			
			query.setParameter("customer", customer);
			query.setParameter("orderId", orderId);
			
			int executeUpdate = query.executeUpdate();
			
			if(executeUpdate >= 1) {
				System.out.println("deleted");
			}
		}
	}

}
