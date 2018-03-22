package com.hemant.furniture.store.dao;

import java.util.List;

import com.hemant.furniture.store.entity.Customer;
import com.hemant.furniture.store.entity.Order;

public interface OrderDao {
	public boolean addOrder(Order order);

	public List<Order> getAllOrdersByCustomer(Customer customer);
}
