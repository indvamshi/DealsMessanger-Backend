package com.dealsmessanger.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "business")
public class Business implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String merchantId;
	
	@Indexed
	private String name;
	
	private String password;
	
	private String vocuherCode;
	
	private Date createTime;
	
    private Date updateTime;
	
	private BusinessAddress mAddress;
	
	private List<Deal> deal;
}
