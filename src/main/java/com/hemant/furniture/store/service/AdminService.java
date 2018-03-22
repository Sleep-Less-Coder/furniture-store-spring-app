package com.hemant.furniture.store.service;

import com.hemant.furniture.store.entity.Admin;

public interface AdminService {

	public Admin checkIfAdminExists(Admin admin);
	public void deleteOrderOfACustomer(long customerId, long orderId);
}
