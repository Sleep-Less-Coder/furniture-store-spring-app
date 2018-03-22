package com.hemant.furniture.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "customer_login")
public class CustomerLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_login_id")
	private long id;
	
	@Column(name = "username", nullable = false)
	@NotNull(message = "Username is required")
	@NotEmpty(message = "Username cannot be empty")
	@Size(min = 3, message = "At least 3 characters is required")
	private String username;
	
	@Column(name = "password", nullable = false)
	@NotNull(message = "Password is required")
	@NotEmpty(message = "Password cannot be empty")
	@Size(min = 5, message = "At least 5 characters is required")
	private String password;
	
	@OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	
	public CustomerLogin() {
		
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}