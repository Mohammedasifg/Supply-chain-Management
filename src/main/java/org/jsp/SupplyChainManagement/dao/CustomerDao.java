package org.jsp.SupplyChainManagement.dao;
import java.util.List;
import java.util.Optional;
import org.jsp.SupplyChainManagement.entity.Customer;
import org.jsp.SupplyChainManagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao
{
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) 
	{
		return customerRepository.save(customer);
	}
	
	public Optional<Customer> getCustomerById(int id)
	{
		return customerRepository.findById(id);
	}
	
	public List<Customer> getAllCustomer()
	{
		return customerRepository.findAll();
	}
	
	public Optional<Customer> updateCustomer(int id)
	{
		return customerRepository.findById(id);
	}
	
	public void deleteCustomer(Customer customer)
	{
		customerRepository.delete(customer);
	}
}
