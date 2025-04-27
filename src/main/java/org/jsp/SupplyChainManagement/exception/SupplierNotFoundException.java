package org.jsp.SupplyChainManagement.exception;

public class SupplierNotFoundException extends RuntimeException {
	public String getMessage() {
		return "Supplier Not Found in the DataBase Since Product Cannot be Added";
	}
}
