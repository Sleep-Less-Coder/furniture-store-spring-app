package com.hemant.furniture.store.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
	private long id;
	
	@Column(name = "customer_firstname", nullable = false, length = 50)
	@NotNull(message = "First name is required")
	@NotEmpty(message = "First name cannot be empty")
	@Size(min = 3, message = "At least 3 characters is required")
	private String firstName;
	
	@Column(name = "customer_lastname", nullable = false, length = 50)
	@NotNull(message = "Last name is required")
	@NotEmpty(message = "Last name cannot be empty")
	@Size(min = 3, message = "At least 3 characters is required")
	private String lastName;
	
	@Column(name = "customer_email_address", nullable = false, columnDefinition = "TEXT")
	@NotNull(message = "Email is required")
	@NotEmpty(message = "Email cannot be empty")
	@Email
	private String email;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
	private Set<Order> orders = new HashSet<>(0);
	
	@OneToOne(mappedBy = "customer", cascade = {CascadeType.ALL})
	private CustomerLogin customerLogin;
	
	public Customer() {
		
	}
	
	
	public long getId() {
		return this.id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return this.firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return this.lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return this.email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Set<Order> getOrders() {
		return this.orders;
	}


	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}


	public CustomerLogin getCustomerLogin() {
		return this.customerLogin;
	}


	public void setCustomerLogin(CustomerLogin customerLogin) {
		this.customerLogin = customerLogin;
	}


	@Override
	public String toString() {
		return "Customer [" + this.id + ", " + this.firstName + ", " + this.lastName + ", " + this.email + "]";
	}
}
