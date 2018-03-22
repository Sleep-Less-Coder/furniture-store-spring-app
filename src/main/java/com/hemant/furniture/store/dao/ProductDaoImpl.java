package com.hemant.furniture.store.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hemant.furniture.store.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("FROM Product");
		List<Product> list = query.list();
		return list;
	}

	@Override
	public Product getProductById(long productId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Product product = currentSession.get(Product.class, productId);
		return product;
	}
	
	@Override
	public int getTotalProductsCount() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("select count(*) from Product");
		int totalCount = Integer.valueOf(query.uniqueResult().toString());
		return totalCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductsByCategory(String categoryName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Product where category=:categoryName");
		query.setParameter("categoryName", categoryName);
		List<Product> products = query.list();
		return products;
	}

	@Override
	public int getProductCountByCategory(String categoryName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("select count(*) from Product where category=:categoryName");
		query.setParameter("categoryName", categoryName);
		int totalCount = Integer.valueOf(query.uniqueResult().toString());
		return totalCount;
	}
}
