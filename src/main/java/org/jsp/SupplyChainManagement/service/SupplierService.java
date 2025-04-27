package org.jsp.SupplyChainManagement.service;
import java.util.List;
import java.util.Optional;

import org.jsp.SupplyChainManagement.dao.SupplierDao;
import org.jsp.SupplyChainManagement.dto.ResponseStructure;
import org.jsp.SupplyChainManagement.entity.Supplier;
import org.jsp.SupplyChainManagement.dto.GlobalExcepionHandler;
import org.jsp.SupplyChainManagement.exception.IdNotFoundException;
import org.jsp.SupplyChainManagement.exception.NoRecordsPresentException;
import org.jsp.SupplyChainManagement.exception.RecordNotPresentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SupplierService
{
	@Autowired
	private SupplierDao supplierDao;
	
	public ResponseEntity<ResponseStructure<Supplier>> saveSupplier(Supplier supplier) 
	{
		ResponseStructure<Supplier> structure=new ResponseStructure<Supplier>();
		Supplier recievedSupplier= supplierDao.saveSupplier(supplier);
		
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(recievedSupplier);
		
		return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Supplier>> getSupplierById(int id)
	{
		ResponseStructure<Supplier> structure=new ResponseStructure<Supplier>();
		Optional<Supplier> recievedSupplier=supplierDao.getSupplierById(id);
		
		if(recievedSupplier.isPresent()) 
		{
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(recievedSupplier.get());
			return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.CREATED);
		}
		else 
		{
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Supplier>>> getAllSupplier()
	{
		ResponseStructure<List<Supplier>> structure=new ResponseStructure<List<Supplier>>();
		List<Supplier> suppliers=supplierDao.getAllSupplier();
		
		if(suppliers.size()>0)
		{
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(suppliers);
			return new ResponseEntity<ResponseStructure<List<Supplier>>>(structure,HttpStatus.CREATED);
		}
		else 
		{
			throw new NoRecordsPresentException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Supplier>> updateSupplier(Supplier supplier)
	{
		ResponseStructure<Supplier> structure=new ResponseStructure<Supplier>();
		Optional<Supplier> recieveSupplier=supplierDao.updateSupplier(supplier.getId());
		
		if(recieveSupplier.isPresent())
		{
			Supplier updatedSupplier=supplierDao.saveSupplier(supplier);
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Success");
			structure.setData(updatedSupplier);
			return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.OK);
		}
		else 
		{
			throw new RecordNotPresentException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Supplier>> deleteSupplier(int id)
	{
		ResponseStructure<Supplier> structure=new ResponseStructure<Supplier>();
		Optional<Supplier> recieveSupplier=supplierDao.getSupplierById(id);
		
		if(recieveSupplier.isPresent()) 
		{
			supplierDao.deleteSupplier(recieveSupplier.get());
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(recieveSupplier.get());
			return new ResponseEntity<ResponseStructure<Supplier>>(structure,HttpStatus.CREATED);
		}
		else 
		{
			throw new IdNotFoundException();
		}
	}
}
