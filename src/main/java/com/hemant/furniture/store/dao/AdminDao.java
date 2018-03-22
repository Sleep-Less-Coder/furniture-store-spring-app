package com.hemant.furniture.store.dao;

import com.hemant.furniture.store.entity.Admin;

public interface AdminDao {
	public Admin checkIfAdminExists(Admin admin);
	public void deleteOrderOfACustomer(long customerId, long orderId);
}
