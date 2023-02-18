package com.belong.contacts.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.belong.contacts.common.Constants;
import com.belong.contacts.entity.CustomerDetails;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Service

public class CustomerContactsImpl implements CustomerContactsService {

	@Override
	public List<CustomerDetails> getCustContactDetails() {

		ObjectMapper jsonMapper = new ObjectMapper();
		jsonMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		List<CustomerDetails> custContact = null;
		try {
			custContact = jsonMapper.readValue(new File(Constants.JSON_FILE_PATH),
					new TypeReference<List<CustomerDetails>>() {
					});
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return custContact;
	}

	@Override
	public CustomerDetails getContactDetailsForCustomer(String customerId) {
		List<CustomerDetails> contacts = getCustContactDetails();
		return contacts.stream().filter(cust -> cust.getCustId().equals(customerId)
				&& cust.getActivateFlag().equalsIgnoreCase(Constants.ACTIVATE_FLAG)).findAny().orElse(null);

	}

	@Override
	public CustomerDetails updateActivateStatus(String customerId) {

		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray = null;
		JSONObject itemArr = null;
		ObjectWriter writer = null;
		JSONArray array = new JSONArray();
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonArray = (JSONArray) jsonParser.parse(new FileReader(Constants.JSON_FILE_PATH));
			for (int i = 0; i < jsonArray.size(); i++) {
				itemArr = (JSONObject) jsonArray.get(i);
				if (itemArr.get(Constants.CUSTOMER_ID).equals(customerId)) {
					itemArr.put(Constants.STATUS, "Y");
					array.add(i, itemArr);
				} else {
					array.add(i, itemArr);
				}
			}
			writer = mapper.writer(new DefaultPrettyPrinter());
			writer.writeValue(new File(Constants.JSON_FILE_PATH), array);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer = null;
			}
		}
		return getContactDetailsForCustomer(customerId);

	}

}
