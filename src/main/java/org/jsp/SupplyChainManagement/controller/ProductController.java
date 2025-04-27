package org.jsp.SupplyChainManagement.controller;
import java.util.List;

import org.jsp.SupplyChainManagement.dto.ResponseStructure;
import org.jsp.SupplyChainManagement.entity.Product;
import org.jsp.SupplyChainManagement.service.ProductService;
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
@RequestMapping("/api/products")
public class ProductController
{
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> getProductById(@PathVariable int id)
	{
		return productService.getProductById(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/supplier/{id}")
	public ResponseEntity<ResponseStructure<List<Product>>> getProductBySupplierId(@PathVariable int id)
	{
		return productService.getProductBySupplierId(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product)
	{
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@PathVariable int id)
	{
		return productService.deleteProduct(id);
	}
}
