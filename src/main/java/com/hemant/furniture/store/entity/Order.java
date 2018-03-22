package com.hemant.furniture.store.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
	private long id;	
	
	@ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "customer_id", nullable = false) 
	private Customer customer;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "orders_products",
        joinColumns = { @JoinColumn(name = "order_id", nullable = false, updatable = false)},
        inverseJoinColumns = { @JoinColumn(name = "product_id", nullable = false, updatable = false)}
    )
	private Set<Product> products = new HashSet<>(0);
	
	public Order() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}	
	
	@Override
	public String toString() {
		return "Order: [" + this.id + " " + this.customer + " " + this.products + "]";
	}
}
