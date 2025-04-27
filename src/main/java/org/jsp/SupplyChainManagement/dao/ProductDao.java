package org.jsp.SupplyChainManagement.dao;
import java.util.List;
import java.util.Optional;

import org.jsp.SupplyChainManagement.entity.Product;
import org.jsp.SupplyChainManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao 
{
	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product) 
	{
		return productRepository.save(product);
	}
	
	public Optional<Product> getProductById(int id) 
	{
		return productRepository.findById(id);
	}
	
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}
	
	public List<Product> getProductBySupplierId(int id) 
	{
		return productRepository.getProductBySupplierId(id);
	}
	
	public Product updateProduct(Product product)
	{
		return productRepository.save(product);
	}
	
	public void deleteProduct(Product product) 
	{
		productRepository.delete(product);
	}
}
