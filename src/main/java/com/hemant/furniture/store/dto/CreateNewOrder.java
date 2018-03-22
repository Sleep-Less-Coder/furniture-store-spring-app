package com.hemant.furniture.store.dto;

import com.hemant.furniture.store.entity.Customer;
import com.hemant.furniture.store.entity.Product;

public class CreateNewOrder {
	private Product product;
	private Customer customer;
	
	public CreateNewOrder() {
		
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
