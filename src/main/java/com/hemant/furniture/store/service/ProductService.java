package com.hemant.furniture.store.service;

import java.util.List;

import com.hemant.furniture.store.entity.Product;

public interface ProductService {
	public List<Product> getAllProducts();

	public Product getProductById(long productId);

	public int getTotalProductsCount();

	public List<Product> getProductsByCategory(String categoryName);

	public int getProductCountByCategory(String categoryName);
}
