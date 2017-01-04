package com.asurion.bo.sb.customermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asurion.bo.sb.customermanagement.dto.Customer;
import com.asurion.bo.sb.customermanagement.service.CustomerService;
import com.asurion.bo.sb.customermanagement.service.GetLogsService;

/*
 * In order to pass data between controller and view there are multiple options available (other than most popular "Model")
 * Controller can accept HttpSession. You can use session.setAttribute(key, value).
 * Session is persisted as long as user is using the browser. Session has expiry time as well.
 * Another option could be ModelAndView object Refer:S7L57	
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	
	@Autowired
	private GetLogsService getLogs;
	/*
	 * @RequestMapping("/list") 
	 * This annotation handles both GET and POST type of HTTP requests. 
	 * In order to constrain we can use : @RequestMapping(path="/list", method=RequestMethod.GET) 
	 * With Spring 4.3 they have introduced @GetMapping or @PostMapping as shortcut methods
	 */
	@GetMapping("/list")
	public String listCustomers(Model model) {

		System.out.println("Inside list Controller");
		List<Customer> customers = customerService.getCustomers();

		for (Customer cust : customers) {
			System.out.println("List Customer : "+cust);
		}
		
		model.addAttribute("customers", customers);
		
		System.out.println(model);

		return "list-customers";
	}
	
	@GetMapping("/add")
	public String addCustomer(Model model) {
		System.out.println("Inside add Controller");
		
		Customer customer = new Customer();

		model.addAttribute("customer", customer);

		return "add-update-customer";
	}

	/*
	 * @Valid tells that we are trying to validate Customer
	 * @BindingResult contains the result of validation 
	 * We are using annotations on the fields of entity classes to validate those fields 
	 * Since customer object contains address, somehow validator is not validating sub object address
	 */
	@PostMapping("/addOrUpdate")
	public String createCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result) {
		
		System.out.println("Inside addOrUpdate Controller");
		// Check if form passes validation
		if (result.hasErrors()) {
			System.out.println("Validation errors on form");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			// Stay on the same page and data filled on the form is not lost
			return "add-update-customer";
		} else {
			customerService.addOrUpdateCustomer(customer);
			return "redirect:/customer/list";
		}
	}

	@GetMapping("/update")
	public String updateCustomer(@RequestParam("customerId") int customerId, Model model) {

		System.out.println("Inside update Controller");
		
		Customer customer = customerService.getCustomer(customerId);

		// Using the same model attribute as add-update-customer.jsp
		model.addAttribute("customer", customer);

		// Re-using the add-update-customer.jsp
		return "add-update-customer";
	}

	@GetMapping("/logs")
	public String showS3Logs(Model model) {

		System.out.println("Inside log Controller");
		
		List<String> s3Logs = getLogs.getS3Logs();
		
		List<String> sqsLogs = getLogs.getSqsLogs();
		
		model.addAttribute("s3Logs", s3Logs);
		
		model.addAttribute("sqsLogs", sqsLogs);
		
		return "logs";
	}
}
