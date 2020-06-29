package com.clothmart.vyntramart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.clothmart.vyntramart.model.User;
import com.clothmart.vyntramart.service.UserService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

	@RequestMapping(value = "/addNewCustomer", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addCustomer", "cust", new Customer());
	}

	@RequestMapping(value = "/addNewCustomer", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("cust") Customer cust) {

		customerService.insertCustomer(cust);
		List<Customer> customers = customerService.getAllCustomers();
		ModelAndView model = new ModelAndView("getCustomers");
		model.addObject("customers", customers);
		return model;
	}

	@RequestMapping("/getCustomers")
	public ModelAndView getUse() {
		List<User> users = userService.getAllUsers();
		ModelAndView model = new ModelAndView("getUsers");
		model.addObject("users", users);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "login";
	}

}

