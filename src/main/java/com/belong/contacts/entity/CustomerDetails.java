package com.belong.contacts.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDetails {
	@JsonProperty("customertid")
	private String custId;
	@JsonProperty("customername")
	private String custName;
	@JsonProperty("status")
	private String activateFlag;
	@JsonProperty("customercontacts")
	private List<Contacts> custContacts;
	
	public CustomerDetails() {
	 
	}
	
	public CustomerDetails(String custId, String custName, List<Contacts> custContacts) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custContacts = custContacts;
	}
	/**
	 * @return the custId
	 */
	public String getCustId() {
		return custId;
	}
	/**
	 * @param custId the custId to set
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}
	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}
	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	/**
	 * @return the activateFlag
	 */
	public String getActivateFlag() {
		return activateFlag;
	}
	/**
	 * @param activateFlag the activateFlag to set
	 */
	public void setActivateFlag(String activateFlag) {
		this.activateFlag = activateFlag;
	}
	/**
	 * @return the custContacts
	 */
	public List<Contacts> getCustContacts() {
		return custContacts;
	}
	/**
	 * @param custContacts the custContacts to set
	 */
	public void setCustContacts(List<Contacts> custContacts) {
		this.custContacts = custContacts;
	}

	@Override
	public String toString() {
		return "CustomerDetails [custId=" + custId + ", custName=" + custName + ", custContacts=" + custContacts + "]";
	}
	
	
	

}
