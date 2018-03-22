package com.hemant.furniture.store.service;

import java.util.List;

import com.hemant.furniture.store.entity.Customer;
import com.hemant.furniture.store.entity.Order;

public interface OrderService {
	public boolean addOrder(Order order);

	public List<Order> getAllOrdersByCustomer(Customer customer);
}
