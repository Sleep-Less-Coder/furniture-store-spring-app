package com.hemant.furniture.store.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hemant.furniture.store.entity.Product;
import com.hemant.furniture.store.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductRestController {
	
	@Autowired 
	ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return products;
	}
	
	@RequestMapping(value="/{productId}", method = RequestMethod.GET)
	public Product getSingleProductById(@PathVariable("productId") long productId) {
		return productService.getProductById(productId);
	}
	
	@RequestMapping(value = "/all/{count}", method = RequestMethod.GET)
	public int getTotalProductsCount() {
		return productService.getTotalProductsCount();
	}
	
	@RequestMapping(value ="/category/{categoryName}", method = RequestMethod.GET)
	public List<Product> getProductsByCategory(@PathVariable("categoryName") String categoryName) {
		return productService.getProductsByCategory(categoryName);
	}
	
	@RequestMapping(value = "/category/{categoryName}/all/count", method = RequestMethod.GET)
	public int getProductCountByCategory(@PathVariable("categoryName") String categoryName) {
		return productService.getProductCountByCategory(categoryName);
	}
}