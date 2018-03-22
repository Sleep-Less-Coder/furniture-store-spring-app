package com.hemant.furniture.store.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemant.furniture.store.dao.AdminDao;
import com.hemant.furniture.store.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired 
	AdminDao adminDao;
	
	@Override
	@Transactional
	public Admin checkIfAdminExists(Admin admin) {
		return adminDao.checkIfAdminExists(admin);
	}

	@Override
	@Transactional
	public void deleteOrderOfACustomer(long customerId, long orderId) {
		adminDao.deleteOrderOfACustomer(customerId, orderId);
	}

}
