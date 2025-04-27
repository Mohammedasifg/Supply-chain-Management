package org.jsp.SupplyChainManagement.dto;
import org.jsp.SupplyChainManagement.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExcepionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Not Found");
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoRecordsPresentException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoRecardsFoundException(NoRecordsPresentException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Not Found");
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RecordNotPresentException.class)
	public ResponseEntity<ResponseStructure<String>> handleRecordNotPresentException(RecordNotPresentException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Not Found");
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SupplierNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleSupplierNotFoundException(SupplierNotFoundException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Not Found");
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleOrderNotFoundException(OrderNotFoundException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Not Found");
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SupplierAndOrderNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleSupplierAndOrderNotFoundException(SupplierAndOrderNotFoundException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Not Found");
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleCustomerNotFoundException(CustomerNotFoundException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Not Found");
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TrackingNumberNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleTrackingNumberNotFoundException(TrackingNumberNotFoundException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Not Found");
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleProductNotFoundException(ProductNotFoundException exception)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Not Found");
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
