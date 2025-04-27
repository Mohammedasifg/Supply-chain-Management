package org.jsp.SupplyChainManagement.controller;
import java.util.List;

import org.jsp.SupplyChainManagement.dto.ResponseStructure;
import org.jsp.SupplyChainManagement.entity.Customer;
import org.jsp.SupplyChainManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Customer>> addCustomer(@RequestBody Customer customer)
	{
		return customerService.addCustomer(customer);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(@PathVariable int id)
	{
		return customerService.getCustomerById(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomer()
	{
		return customerService.getAllCustomer();
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(@RequestBody Customer customer)
	{
		return customerService.updateCustomer(customer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(@PathVariable int id)
	{
		return customerService.deleteCustomer(id);
	}
}
