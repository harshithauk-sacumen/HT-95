package com.sacumen.hiretalent.requisitiontype;

public enum RequisitionType{
	
	FullTime("Full Time"),
	Contractor("Contractor"); 
	private String type;
	
	private RequisitionType(String type) {
		this.type=type;		
	}
	
	public String getType() {
		return this.type;
	}
}