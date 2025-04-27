package org.jsp.SupplyChainManagement.service;
import java.util.List;
import java.util.Optional;

import org.jsp.SupplyChainManagement.dao.OrderDao;
import org.jsp.SupplyChainManagement.dao.ProductDao;
import org.jsp.SupplyChainManagement.dao.SupplierDao;
import org.jsp.SupplyChainManagement.dto.ResponseStructure;
import org.jsp.SupplyChainManagement.entity.Order;
import org.jsp.SupplyChainManagement.entity.Product;
import org.jsp.SupplyChainManagement.entity.Supplier;
import org.jsp.SupplyChainManagement.exception.IdNotFoundException;
import org.jsp.SupplyChainManagement.exception.OrderNotFoundException;
import org.jsp.SupplyChainManagement.exception.ProductNotFoundException;
import org.jsp.SupplyChainManagement.exception.SupplierAndOrderNotFoundException;
import org.jsp.SupplyChainManagement.exception.SupplierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService
{
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	private OrderDao orderDao;
	
	public ResponseEntity<ResponseStructure<Product>> addProduct(Product product)
	{
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		Optional<Supplier> recieveSupplier= supplierDao.getSupplierById(product.getSupplier().getId());
		Optional<Order> recieveOrder=orderDao.getOrderById(product.getOrder().getId());
		
		if(recieveSupplier.isPresent() && recieveOrder.isPresent())
		{
			recieveSupplier.get().getProducts().add(product);
			recieveOrder.get().getProducts().add(product);
			Product reProduct=productDao.addProduct(product);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(reProduct);
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		else if(!recieveSupplier.isPresent() && !recieveOrder.isPresent()) 
		{
			throw new SupplierAndOrderNotFoundException();
		}
		else if(!recieveSupplier.isPresent())
		{
			throw new SupplierNotFoundException();
		}
		else 
		{
			throw new OrderNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Product>> getProductById(int id)
	{
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		Optional<Product> receiveProduct=productDao.getProductById(id);
		
		if(receiveProduct.isPresent())
		{
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(receiveProduct.get());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts()
	{
		ResponseStructure<List<Product>> structure=new ResponseStructure<List<Product>>();
		List<Product> receiveProduct=productDao.getAllProducts();
		
		if(receiveProduct.size()>0) 
		{
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(receiveProduct);
			return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> getProductBySupplierId(int id)
	{
		ResponseStructure<List<Product>> structure=new ResponseStructure<List<Product>>();
		Optional<Supplier> receiveSupplier=supplierDao.getSupplierById(id);
		
		if(receiveSupplier.isPresent()) 
		{
			List<Product> receiveProduct=productDao.getProductBySupplierId(receiveSupplier.get().getId());
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(receiveProduct);
			return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.OK);
		}
		else 
		{
			throw new SupplierNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product)
	{
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		Optional<Supplier> recieveSupplier= supplierDao.getSupplierById(product.getSupplier().getId());
		Optional<Order> recieveOrder=orderDao.getOrderById(product.getOrder().getId());
		Optional<Product> recieveProduct=productDao.getProductById(product.getId());
		
		if(recieveProduct.isPresent() && recieveSupplier.isPresent() && recieveOrder.isPresent())
		{
			Product reProduct=productDao.updateProduct(product);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(reProduct);
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		else if(!recieveSupplier.isPresent() && !recieveOrder.isPresent()) 
		{
			throw new SupplierAndOrderNotFoundException();
		}
		else if(!recieveSupplier.isPresent())
		{
			throw new SupplierNotFoundException();
		}
		else if(!recieveOrder.isPresent())
		{
			throw new OrderNotFoundException();
		}
		else 
		{
			throw new ProductNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int id)
	{
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		Optional<Product> receiveProduct=productDao.getProductById(id);
		
		if(receiveProduct.isPresent()) 
		{
			productDao.deleteProduct(receiveProduct.get());
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(receiveProduct.get());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFoundException();
		}
	}
}
