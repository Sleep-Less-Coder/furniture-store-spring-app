package com.hemant.furniture.store.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemant.furniture.store.dao.OrderDao;
import com.hemant.furniture.store.entity.Customer;
import com.hemant.furniture.store.entity.Order;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;
	
	@Override
	@Transactional
	public boolean addOrder(Order order) {
		return orderDao.addOrder(order);
	}

	@Override
	@Transactional
	public List<Order> getAllOrdersByCustomer(Customer customer) {
		return orderDao.getAllOrdersByCustomer(customer);
	}

}
