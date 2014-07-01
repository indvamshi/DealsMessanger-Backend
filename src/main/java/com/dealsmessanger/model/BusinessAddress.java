package com.dealsmessanger.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "businessaddress")
public class BusinessAddress {
	
	@Id
	private String addressId;
	
	private String houseNo;
	
	private String firstLine;
	
	private String secondLine;
	
	private String city;
	
	@Indexed
	private String postCode;
	
	private String state;
	
	@Indexed
	private String country;
	
	private String telephone1;
	
	private String telepone2;
	
	private String fax;
	
	private String email;
	
}
