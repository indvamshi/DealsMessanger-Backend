package com.dealsmessanger.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "businessaddress")
public class BusinessAddress implements Serializable {
	
	private static final long serialVersionUID = 1L;

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
