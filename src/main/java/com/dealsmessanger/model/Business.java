package com.dealsmessanger.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "business")
public class Business implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String businessId;
	
	@Indexed
	private String name;
	
	private String password;
	
	private String vouchercode;
	
	private Date createdTime;
	
    private Date updatedTime;
	
	private BusinessAddress businessAddress;
	
	private List<Deal> deal;

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVouchercode() {
		return vouchercode;
	}

	public void setVouchercode(String vouchercode) {
		this.vouchercode = vouchercode;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public BusinessAddress getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(BusinessAddress businessAddress) {
		this.businessAddress = businessAddress;
	}

	public List<Deal> getDeal() {
		return deal;
	}

	public void setDeal(List<Deal> deal) {
		if (deal == null) {
			deal = new ArrayList<Deal>();
		}
		this.deal = deal;
	}
}
