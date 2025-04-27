package org.jsp.SupplyChainManagement.exception;

public class IdNotFoundException extends RuntimeException {
	public String getMessage() {
		return "Id is Not Found in the DataBase";
	}
}
