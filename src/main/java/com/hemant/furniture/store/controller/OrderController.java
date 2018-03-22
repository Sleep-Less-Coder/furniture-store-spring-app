package com.hemant.furniture.store.controller;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hemant.furniture.store.dto.CreateNewOrder;
import com.hemant.furniture.store.entity.Customer;
import com.hemant.furniture.store.entity.Order;
import com.hemant.furniture.store.entity.Product;
import com.hemant.furniture.store.service.CustomerService;
import com.hemant.furniture.store.service.OrderService;
import com.hemant.furniture.store.service.ProductService;

@Controller
@RequestMapping("/secure/orders")
public class OrderController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/list")
	public String listAllOrders(@RequestParam("customerId") long customerId, Model model) {
		
		Customer customer = customerService.getCustomerById(customerId);
		
		List<Order> orders = orderService.getAllOrdersByCustomer(customer);
		
		model.addAttribute("orders", orders);
		
		return "customer-orders";
	}
	
	@RequestMapping(value = "/create", method=RequestMethod.POST)
	public String createANewOrder(@ModelAttribute("createNewOrder") CreateNewOrder createNewOrder) {
		
		Order order = new Order();
		long customerId = createNewOrder.getCustomer().getId();
		long productId = createNewOrder.getProduct().getId();
		
		Customer customer = customerService.getCustomerById(customerId);
		Product product = productService.getProductById(productId);
		
		HashSet<Product> products = new HashSet<>();
		products.add(product);
		
		order.setCustomer(customer);
		order.setProducts(products);
		
		System.out.println(order);
		
		orderService.addOrder(order);
		
		return "redirect:/product/all";
	}
}
