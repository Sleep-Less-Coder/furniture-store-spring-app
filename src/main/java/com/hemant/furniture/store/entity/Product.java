package com.hemant.furniture.store.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
	private long id;

	@Column(name = "product_name", nullable = false, length = 255)
	private String name;
	
	@Column(name = "product_category", nullable = false, length = 255)
	private String category;
	
	@Column(name = "product_price", nullable = false)
	private double price;
	
	@Column(name = "product_description", nullable = false, columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "product_image")
	private String image;
	
	@Transient
	@JsonIgnore
	private MultipartFile imageFile;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "products")
	@JsonIgnore
	private Set<Order> orders = new HashSet<>();
	
	public Product() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public String toString() {
		return "Product [" + this.id + ", " + this.name + ", " + this.category + ", " + this.price + ", " + this.description + ", " + this.image + "]";
	}
}
