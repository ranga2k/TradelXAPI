package com.tradelxapp.model;

public enum Status {
	AVAILABLE("available"),
	PENDING("pending"),
	SOLD("sold");
	
	private final String status;
	
	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	
	
	

}
