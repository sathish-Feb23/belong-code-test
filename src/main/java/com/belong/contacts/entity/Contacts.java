package com.belong.contacts.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contacts {
	
	@JsonProperty("primary")
	private String primaryContactNo;
	@JsonProperty("secondary")
	private String secondaryContactNo;
	
	
	public Contacts() {
		
	}
	
	public Contacts(String primaryContactNo, String secondaryContactNo) {
		super();
		this.primaryContactNo = primaryContactNo;
		this.secondaryContactNo = secondaryContactNo;
		
	}
	
	/**
	 * @return the secondaryContactNo
	 */
	public String getSecondaryContactNo() {
		return secondaryContactNo;
	}
	
	/**
	 * @param secondaryContactNo the secondaryContactNo to set
	 */
	public void setSecondaryContactNo(String secondaryContactNo) {
		this.secondaryContactNo = secondaryContactNo;
	}
	
	
	/**
	 * @return the primaryContactNo
	 */
	public String getPrimaryContactNo() {
		return primaryContactNo;
	}
	/**
	 * @param primaryContactNo the primaryContactNo to set
	 */
	public void setPrimaryContactNo(String primaryContactNo) {
		this.primaryContactNo = primaryContactNo;
	}

	@Override
	public String toString() {
		return "Contacts [primaryContactNo=" + primaryContactNo + ", secondaryContactNo=" + secondaryContactNo + "]";
	}

	
	

}
