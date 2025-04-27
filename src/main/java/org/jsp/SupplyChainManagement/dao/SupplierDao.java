package org.jsp.SupplyChainManagement.dao;
import java.util.List;
import java.util.Optional;

import org.jsp.SupplyChainManagement.entity.Supplier;
import org.jsp.SupplyChainManagement.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SupplierDao
{
	@Autowired
	private SupplierRepository supplierRepository;
	
	public Supplier saveSupplier(Supplier supplier) 
	{
		return supplierRepository.save(supplier);
	}
	
	public Optional<Supplier> getSupplierById(int id) 
	{
		return supplierRepository.findById(id);
	}
	
	public List<Supplier> getAllSupplier()
	{
		return supplierRepository.findAll();
	}
	
	public Optional<Supplier> updateSupplier(int id) 
	{
		return supplierRepository.findById(id);
	}
	
	public void deleteSupplier(Supplier supplier) 
	{
		supplierRepository.delete(supplier);
	}
}
