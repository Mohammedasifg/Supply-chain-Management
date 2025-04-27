package org.jsp.SupplyChainManagement.exception;

public class ProductNotFoundException extends RuntimeException {
	public String getMessage() {
		return "Product is Not Present in the DataBase";
	}
}
