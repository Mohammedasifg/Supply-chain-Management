package org.jsp.SupplyChainManagement.exception;

public class NoRecordsPresentException extends RuntimeException {
	public String getMessage() {
		return "No Records Present in the DataBase";
	}
}
