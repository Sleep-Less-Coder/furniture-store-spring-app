package com.hemant.furniture.store.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemant.furniture.store.dao.CustomerDao;
import com.hemant.furniture.store.dto.CustomerLoginObj;
import com.hemant.furniture.store.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired 
	CustomerDao customerDao;

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomerById(long id) {
		return customerDao.getCustomerById(id);
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);	
	}
	
	@Override
	@Transactional
	public Customer checkIfUserExists(CustomerLoginObj customerLoginObj) {
		return customerDao.checkIfUserExists(customerLoginObj);
	}
}
