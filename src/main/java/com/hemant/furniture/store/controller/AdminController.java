package com.hemant.furniture.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hemant.furniture.store.dto.CustomerSelector;
import com.hemant.furniture.store.entity.Customer;
import com.hemant.furniture.store.entity.Order;
import com.hemant.furniture.store.service.AdminService;
import com.hemant.furniture.store.service.CustomerService;
import com.hemant.furniture.store.service.OrderService;

@Controller
@RequestMapping("secure/admin/")
public class AdminController {

	@Autowired
	CustomerService customerService;

	@Autowired
	OrderService orderService;
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("chooseACustomer")
	public String ordersOfAllCustomers(Model model) {
		List<Customer> allCustomers = customerService.getAllCustomers();
		model.addAttribute("customers", allCustomers);
		model.addAttribute("selectCustomer", new CustomerSelector());
		return "admin/all-customer-orders";
	}

	@RequestMapping("getOrderOfaCustomer")
	public String getOrderOfaCustomer(@ModelAttribute("selectCustomer") CustomerSelector customerSelector, Model model) {
		int customerId = customerSelector.getCustomerId();

		Customer customer = customerService.getCustomerById(customerId);
		if (customer != null) {
			List<Order> allOrdersByCustomer = orderService.getAllOrdersByCustomer(customer);
			model.addAttribute("orders", allOrdersByCustomer);
			model.addAttribute("customer", customer);
			return "admin/orders-of-a-customer";
		}
		return null;
	}
	
	@RequestMapping("deleteCustomerOrder")
	public String deleteCustomerOrder(@RequestParam("customerId") long customerId, @RequestParam("orderId") long orderId, HttpServletRequest request) {
		System.out.println(orderId);
		adminService.deleteOrderOfACustomer(customerId, orderId);
		String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}
}
