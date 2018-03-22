package com.hemant.furniture.store.dao;

import java.util.List;

import com.hemant.furniture.store.dto.CustomerLoginObj;
import com.hemant.furniture.store.entity.Customer;

public interface CustomerDao {
	public List<Customer> getAllCustomers();

	public Customer getCustomerById(long id);

	public void addCustomer(Customer customer);

	public Customer checkIfUserExists(CustomerLoginObj customerLoginObj);
}
