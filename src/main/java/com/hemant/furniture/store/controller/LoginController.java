package com.hemant.furniture.store.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hemant.furniture.store.dto.CustomerLoginObj;
import com.hemant.furniture.store.entity.Admin;
import com.hemant.furniture.store.entity.Customer;
import com.hemant.furniture.store.service.AdminService;
import com.hemant.furniture.store.service.CustomerService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	CustomerService customerService;
	
	@Autowired 
	AdminService adminService;
	
	@RequestMapping("/showFormForLogin")
	public String showFormForLogin(Model model) {
		model.addAttribute("customerLoginDetails", new CustomerLoginObj());
		return "login-form";
	}

	@PostMapping("/logInTheUser")
	public String logInTheUser(HttpServletRequest request,
			@ModelAttribute("customerLoginDetails") @Valid CustomerLoginObj customerLoginObj,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "login-form";
		} else {
			Customer customer = customerService.checkIfUserExists(customerLoginObj);

			HttpSession httpSession = request.getSession();

			if (customer != null) {
				httpSession.setAttribute("customer", customer);
				httpSession.setAttribute("loggedInUser", customer.getCustomerLogin().getUsername());
				httpSession.setAttribute("customerId", customer.getId());

				return "redirect:/product/all";
			} else {
				return "redirect:/showFormForLogin";
			}
		}

	}

	@GetMapping("/logOutTheUser")
	public String logOutTheUser(HttpServletRequest request) {
		System.out.println("logout now");

		HttpSession session = request.getSession();
		session.removeAttribute("customer");
		session.removeAttribute("customerId");
		session.removeAttribute("loggedInUser");
		session.removeAttribute("admin");
		session.invalidate();

		return "redirect:/product/all";
	}

	@RequestMapping("/showFormForSignUp")
	public String showFormForSignUp(Model model) {
		model.addAttribute("customer", new Customer());
		return "create-new-customer";
	}

	@PostMapping("/createCustomer")
	public String createCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "create-new-customer";
		} else {
			customer.getCustomerLogin().setCustomer(customer);
			customerService.addCustomer(customer);
			return "redirect:/product/all";
		}
	}
	
	/**
	 * For Admin
	 */
	@RequestMapping("/showFormForAdminLogin")
	public String showFormForAdminLogin(Model model) {
		model.addAttribute("adminLogin", new Admin());
		return "admin/login-form";
	}
	
	@PostMapping("/logInTheAdmin")
	public String logInTheUser(HttpServletRequest request,
			@ModelAttribute("adminLogin") @Valid Admin admin,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "admin/login-form";
		} else {
			Admin retrievedAdmin = adminService.checkIfAdminExists(admin);

			if (retrievedAdmin != null) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("admin", retrievedAdmin);
				
				return "redirect:/product/all";
			} else {
				return "redirect:/showFormForAdminLogin";
			}
		}

	}
}
