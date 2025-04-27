package org.jsp.SupplyChainManagement.service;
import java.util.List;
import java.util.Optional;

import org.jsp.SupplyChainManagement.dao.CustomerDao;
import org.jsp.SupplyChainManagement.dto.ResponseStructure;
import org.jsp.SupplyChainManagement.entity.Customer;
import org.jsp.SupplyChainManagement.exception.IdNotFoundException;
import org.jsp.SupplyChainManagement.exception.NoRecordsPresentException;
import org.jsp.SupplyChainManagement.exception.RecordNotPresentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerDao customerDao;
	
	public ResponseEntity<ResponseStructure<Customer>> addCustomer(Customer customer)
	{
		ResponseStructure<Customer> structure=new ResponseStructure<Customer>();
		Customer receiveCustomer=customerDao.addCustomer(customer);
		
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(receiveCustomer);
		return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Customer>> getCustomerById(int id)
	{
		ResponseStructure<Customer> structure=new ResponseStructure<Customer>();
		Optional<Customer> receiveCustomer=customerDao.getCustomerById(id);
		
		if(receiveCustomer.isPresent()) 
		{
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(receiveCustomer.get());
			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.CREATED);
		}
		else 
		{
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomer()
	{
		ResponseStructure<List<Customer>> structure=new ResponseStructure<List<Customer>>();
		List<Customer> receiveCustomer=customerDao.getAllCustomer();
		
		if(receiveCustomer.size()>0)
		{
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(receiveCustomer);
			return new ResponseEntity<ResponseStructure<List<Customer>>>(structure,HttpStatus.CREATED);
		}
		else
		{
			throw new NoRecordsPresentException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Customer>> updateCustomer(Customer customer)
	{
		ResponseStructure<Customer> structure=new ResponseStructure<Customer>();
		Optional<Customer> receiveCustomer=customerDao.updateCustomer(customer.getId());
		
		if(receiveCustomer.isPresent()) 
		{
			Customer customerupdated= customerDao.addCustomer(customer);
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(customer);
			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.CREATED);
		}
		else 
		{
			throw new RecordNotPresentException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Customer>> deleteCustomer(int id)
	{
		ResponseStructure<Customer> structure=new ResponseStructure<Customer>();
		Optional<Customer> receiveCustomer=customerDao.updateCustomer(id);
		
		if(receiveCustomer.isPresent()) 
		{
			customerDao.deleteCustomer(receiveCustomer.get());
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(receiveCustomer.get());
			return new ResponseEntity<ResponseStructure<Customer>>(structure,HttpStatus.OK);
		}
		else 
		{
			throw new IdNotFoundException();
		}
	}
}
