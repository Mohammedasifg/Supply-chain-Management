package org.jsp.SupplyChainManagement.exception;

public class OrderNotFoundException extends RuntimeException {
	public String getMessage() {
		return "Order Not Found in the DataBase since Product Cannot be Added";
	}
}
