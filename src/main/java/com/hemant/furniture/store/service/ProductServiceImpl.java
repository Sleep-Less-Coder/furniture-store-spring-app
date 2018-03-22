package com.hemant.furniture.store.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemant.furniture.store.dao.ProductDao;
import com.hemant.furniture.store.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Transactional
	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}
	
	@Transactional
	@Override
	public Product getProductById(long productId) {
		return productDao.getProductById(productId);
	}

	@Transactional
	@Override
	public int getTotalProductsCount() {
		return productDao.getTotalProductsCount();
	}

	@Transactional
	@Override
	public List<Product> getProductsByCategory(String categoryName) {
		return productDao.getProductsByCategory(categoryName);
	}
	
	@Transactional
	@Override
	public int getProductCountByCategory(String categoryName) {
		return productDao.getProductCountByCategory(categoryName);
	}
}
