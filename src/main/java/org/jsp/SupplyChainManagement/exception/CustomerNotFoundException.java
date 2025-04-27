package org.jsp.SupplyChainManagement.exception;

public class CustomerNotFoundException extends RuntimeException {
	public String getMessage() {
		return "Customer Not Found in the DataBase Since Order Cannot be Added";
	}
}
