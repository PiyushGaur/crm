package com.piyush.crm.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piyush.crm.entity.Customer;
import com.piyush.crm.exceptionhandling.EntityNotFoundException;
import com.piyush.crm.service.CustomerService;

@RestController
@RequestMapping("/hello")
public class CrmController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		System.out.println("I am in");
		return customerService.getCustomer();

	}

	@GetMapping("/customers/{customerId}")
	public String getCustomer(@PathVariable int customerId) {

		String customer = customerService.getCustomer(customerId);
		if (customer == null) {
			throw new EntityNotFoundException("Customer not available with Id = " + customerId);
		}
		return customer;
	}

	@PostMapping("/customers")
	public String saveCustomer(@RequestBody String customer) {
		System.out.println("kjfnvk");
		customerService.saveCustomer(customer);
		return customer;
	}

	@PutMapping("/customers")
	public String updateCustomer(@RequestBody String customer) {
		customerService.saveCustomer(customer);
		return customer;
	}

	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping("/demoHeader")
	public String getHeader(@RequestHeader MultiValueMap<String,String> http ) {
		System.out.println("Host=" + http.get("user").get(1));
		System.out.println("Origin=" + http.toString());
		
		return "";
		
	}
}
