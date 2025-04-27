package org.jsp.SupplyChainManagement.service;
import java.util.List;
import java.util.Optional;
import org.jsp.SupplyChainManagement.dao.CustomerDao;
import org.jsp.SupplyChainManagement.dao.OrderDao;
import org.jsp.SupplyChainManagement.dto.ResponseStructure;
import org.jsp.SupplyChainManagement.entity.Customer;
import org.jsp.SupplyChainManagement.entity.Order;
import org.jsp.SupplyChainManagement.exception.CustomerNotFoundException;
import org.jsp.SupplyChainManagement.exception.IdNotFoundException;
import org.jsp.SupplyChainManagement.exception.NoRecordsPresentException;
import org.jsp.SupplyChainManagement.exception.RecordNotPresentException;
import org.jsp.SupplyChainManagement.exception.TrackingNumberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService
{
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	public ResponseEntity<ResponseStructure<Order>> createOrder(Order order)
	{
		ResponseStructure<Order> structure=new ResponseStructure<Order>();
		Optional<Customer> receiveCustomer=customerDao.getCustomerById(order.getCustomer().getId());
		
		if(receiveCustomer.isPresent())
		{
			receiveCustomer.get().getOrders().add(order);
			order.setCustomer(receiveCustomer.get());
			Order reOrder= orderDao.createOrder(order);
			
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(reOrder);
			return new ResponseEntity<ResponseStructure<Order>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new CustomerNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Order>> getOrderById(int id)
	{
		ResponseStructure<Order> structure=new ResponseStructure<Order>();
		Optional<Order> receiveOrder=orderDao.getOrderById(id);
		
		if(receiveOrder.isPresent())
		{
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(receiveOrder.get());
			return new ResponseEntity<ResponseStructure<Order>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Order>>> getAllOrders()
	{
		ResponseStructure<List<Order>> structure=new ResponseStructure<List<Order>>();
		List<Order> receiveOrders=orderDao.getAllOrders();
		
		if(receiveOrders.size()>0) 
		{
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(receiveOrders);
			return new ResponseEntity<ResponseStructure<List<Order>>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new NoRecordsPresentException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Order>>> getOrdersByCustomerId(int id)
	{
		ResponseStructure<List<Order>> structure=new ResponseStructure<List<Order>>();
		Optional<Customer> receiveCustomer=customerDao.getCustomerById(id);
		
		if(receiveCustomer.isPresent())
		{
			List<Order> receiveOrders=orderDao.getOrdersByCustomerId(id);
			if(receiveOrders.size()>0) 
			{
				structure.setStatusCode(HttpStatus.OK.value());
				structure.setMessage("Success");
				structure.setData(receiveOrders);
				return new ResponseEntity<ResponseStructure<List<Order>>>(structure,HttpStatus.OK);
			}
			else
			{
				throw new NoRecordsPresentException();
			}
		}
		throw new CustomerNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Order>> getOrderByTrackingNumber(String trackingNumber)
	{
		ResponseStructure<Order> structure=new ResponseStructure<Order>();
		Optional<Order> receiveOrder=orderDao.getOrderByTrackingNumber(trackingNumber);
		
		if(receiveOrder.isPresent()) 
		{
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(receiveOrder.get());
			return new ResponseEntity<ResponseStructure<Order>>(structure,HttpStatus.OK);
		}
		throw new TrackingNumberNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Order>> deleteOrder(int id)
	{
		ResponseStructure<Order> structure=new ResponseStructure<Order>();
		Optional<Order> receiveOrder=orderDao.getOrderById(id);
		
		if(receiveOrder.isPresent())
		{
			orderDao.deleteOrder(receiveOrder.get());
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(receiveOrder.get());
			return new ResponseEntity<ResponseStructure<Order>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Order>> updateOrder(Order order)
	{
		ResponseStructure<Order> structure=new ResponseStructure<Order>();
		Optional<Order> receiveOrder=orderDao.getOrderById(order.getId());
		
		if(receiveOrder.isPresent()) 
		{
			Order updatedOrder=orderDao.updateOrder(order);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(updatedOrder);
			return new ResponseEntity<ResponseStructure<Order>>(structure,HttpStatus.OK);
		}
		throw new RecordNotPresentException();
	}

}
