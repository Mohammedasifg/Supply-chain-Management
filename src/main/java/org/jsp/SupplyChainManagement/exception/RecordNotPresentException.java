package org.jsp.SupplyChainManagement.exception;

public class RecordNotPresentException extends RuntimeException {
	public String getMessage() {
		return "Record is not present in the DataBase";
	}
}
