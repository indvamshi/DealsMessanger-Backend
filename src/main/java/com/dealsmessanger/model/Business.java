package com.dealsmessanger.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "business")
public class Business {

	@Id
	private String merchantId;
	
	@Indexed
	private String name;
	
	private String password;
	
	private String vocuherCode;
	
	private Date createTime;
	
    private Date updateTime;
	
	private BusinessAddress mAddress;
	
	private Deal deal;
}
