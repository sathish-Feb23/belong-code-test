package com.belong.contacts.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.belong.contacts.entity.CustomerDetails;

@Repository
public interface CustomerContactRepository {

	public List<CustomerDetails> getCustContacts();

}
