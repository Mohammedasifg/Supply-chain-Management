package org.jsp.SupplyChainManagement.dao;
import java.util.List;
import java.util.Optional;

import org.jsp.SupplyChainManagement.entity.Order;
import org.jsp.SupplyChainManagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao 
{
	@Autowired
	private OrderRepository  orderRepository;
	
	public Order createOrder(Order order) 
	{
		return orderRepository.save(order);
	}
	
	public Optional<Order> getOrderById(int id)
	{
		return orderRepository.findById(id);
	}
	
	public List<Order> getAllOrders()
	{
		return orderRepository.findAll();
	}
	
	public List<Order> getOrdersByCustomerId(int id)
	{
		return orderRepository.getOrdersByCustomerId(id);
	}
	
	public Optional<Order> getOrderByTrackingNumber(String trackingNumber)
	{
		return orderRepository.getOrderByTrakingNumber(trackingNumber);
	}
	
	public void deleteOrder(Order order) 
	{
		orderRepository.delete(order);
	}
	
	public Order updateOrder(Order order)
	{
		return orderRepository.save(order);
	}
}
