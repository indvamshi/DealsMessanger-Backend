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
	
	//@Indexed
	private String postCode;
	
	private String state;
	
	//@Indexed
	private String country;
	
	private String telephone1;
	
	private String telepone2;
	
	private String fax;
	
	private String email;
	
	private String website;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getTelepone2() {
		return telepone2;
	}

	public void setTelepone2(String telepone2) {
		this.telepone2 = telepone2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "BusinessAddress [addressId=" + addressId + ", houseNo="
				+ houseNo + ", firstLine=" + firstLine + ", secondLine="
				+ secondLine + ", city=" + city + ", postCode=" + postCode
				+ ", state=" + state + ", country=" + country + ", telephone1="
				+ telephone1 + ", telepone2=" + telepone2 + ", fax=" + fax
				+ ", email=" + email + ", website=" + website + "]";
	}
	
	
}
