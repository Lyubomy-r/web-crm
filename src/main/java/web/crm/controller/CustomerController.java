package web.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.crm.entity.Customer;
import web.crm.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService ;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
	
		List<Customer> theCustomers = customerService.getCustomers();
				
		
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("addCustomer",theCustomer);
		
		
		return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("addCustomer") Customer theCustomer) {
		
		customerService.setCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showInfoCustomer(@RequestParam("customerId") int theId, Model theModel) {
		
		Customer upCustomer=customerService.getCustomer(theId);
		
		theModel.addAttribute("addCustomer", upCustomer);
		
		return "customer-form";
	}
	
	@RequestMapping ("/showFormForDelet")
	public String showFormForDelet(@RequestParam("customerId") int theId) {
		
		customerService.deletInQuery(theId);
		
		
		
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/search")
	 public String searchCustomers(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		
		//List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
		List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
		 theModel.addAttribute("customers", theCustomers);
		 
		 return "list-customers";
	}
}
