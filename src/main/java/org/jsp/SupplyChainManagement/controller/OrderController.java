package org.jsp.SupplyChainManagement.controller;
import java.util.List;

import org.jsp.SupplyChainManagement.dto.ResponseStructure;
import org.jsp.SupplyChainManagement.entity.Order;
import org.jsp.SupplyChainManagement.service.OrderService;
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
@RequestMapping("/api/orders")
public class OrderController 
{
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Order>> createOrder(@RequestBody Order order)
	{
		return orderService.createOrder(order);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Order>> getOrderById(@PathVariable int id)
	{
		return orderService.getOrderById(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Order>>> getAllOrders()
	{
		return orderService.getAllOrders();
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<ResponseStructure<List<Order>>> getOrderByCustomerId(@PathVariable int id)
	{
		return orderService.getOrdersByCustomerId(id);
	}
	
	@GetMapping("/track/{trackingNumber}")
	public ResponseEntity<ResponseStructure<Order>> getOrderByTrackingNumber(@PathVariable String trackingNumber)
	{
		return orderService.getOrderByTrackingNumber(trackingNumber);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Order>> deleteOrder(@PathVariable int id)
	{
		return orderService.deleteOrder(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Order>> updateOrder(@RequestBody Order order)
	{
		return orderService.updateOrder(order);
	}
}
