package org.jsp.SupplyChainManagement.exception;

public class TrackingNumberNotFoundException extends RuntimeException {
	public String getMessage() {
		return "Tracking Number Not Found in the DataBase";
	}
}
