package com.hemant.furniture.store.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hemant.furniture.store.entity.Customer;
import com.hemant.furniture.store.entity.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addOrder(Order order) {
		Session currentSession = sessionFactory.getCurrentSession();

		System.out.println("Now saving");

		try {
			currentSession.saveOrUpdate(order);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Order> getAllOrdersByCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("from Order where customer = :customer");
		query.setParameter("customer", customer);

		List<Order> orders = query.list();
		
		System.out.println(orders);
		return orders;
	}
}
