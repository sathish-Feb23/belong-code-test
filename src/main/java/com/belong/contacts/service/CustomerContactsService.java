package com.belong.contacts.service;

import java.util.List;

import com.belong.contacts.entity.CustomerDetails;

public interface CustomerContactsService {

	public List<CustomerDetails> getCustContactDetails();

	public CustomerDetails getContactDetailsForCustomer(String customerId);

	public CustomerDetails updateActivateStatus(String customerId);

}
