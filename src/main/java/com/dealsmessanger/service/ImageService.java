package com.dealsmessanger.service;

import java.io.InputStream;

import com.mongodb.gridfs.GridFSDBFile;

public interface ImageService {

	String saveImage(InputStream inputStream, String contentType, String filename, String id);
	
	GridFSDBFile getImage(String id);
}
