package org.jsp.SupplyChainManagement.exception;

public class SupplierAndOrderNotFoundException extends RuntimeException {
	public String getMessage() {
		return "Supplier and Order Not Found in the Database Since Product Cannot be Added";
	}
}
