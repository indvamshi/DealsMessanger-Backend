package com.dealsmessanger.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "imagedata")
public class ImageData {

	private String id;
	
	@Field(value = "fName")
    private String fileName;
	
    private byte[] imageData;
}
