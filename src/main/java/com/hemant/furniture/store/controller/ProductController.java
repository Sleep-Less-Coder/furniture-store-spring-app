package com.hemant.furniture.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hemant.furniture.store.dto.CreateNewOrder;
import com.hemant.furniture.store.entity.Product;
import com.hemant.furniture.store.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public String getAllProducts(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "home";
	}
	
	@GetMapping("/showProductDetail")
	public String getProductById(@RequestParam("productId") long productId, Model model) {
		Product product = productService.getProductById(productId);
		model.addAttribute("product", product);
		model.addAttribute("createNewOrder", new CreateNewOrder());
		return "product-detail";
	}
}
