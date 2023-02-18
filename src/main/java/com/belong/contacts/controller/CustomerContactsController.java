package com.belong.contacts.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.belong.contacts.entity.CustomerDetails;
import com.belong.contacts.service.CustomerContactsService;

@RestController
@RequestMapping("/api")
public class CustomerContactsController {

	@Autowired
	private CustomerContactsService customercontactservice;

	@GetMapping("/getphonenumbers")
	public ResponseEntity<?> getContactDetails() {
		return new ResponseEntity<>(customercontactservice.getCustContactDetails(), HttpStatus.OK);
	}

	@GetMapping("/getphonenumberforcustomer")
	public ResponseEntity<?> getContactDetailsForCustomer(@RequestParam String customerId) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		CustomerDetails customerdetails = customercontactservice.getContactDetailsForCustomer(customerId);
		if (customerdetails != null) {
			return new ResponseEntity<>(customercontactservice.getContactDetailsForCustomer(customerId), HttpStatus.OK);
		} else {
			map.clear();
			map.put("Message", "No Matching Record Exist");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/activatecontact/{id}")
	public ResponseEntity<?> activatecontact(@PathVariable String id) {

		return new ResponseEntity<>(customercontactservice.updateActivateStatus(id), HttpStatus.OK);

	}

}
