package com.dealsmessanger.service;

import java.io.InputStream;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

public class ImageServiceImpl implements ImageService {

	@Autowired
	private GridFsOperations gridOperation;

	public String saveImage(InputStream inputStream, String contentType, String filename, String id) {
		DBObject metaData = new BasicDBObject();
		metaData.put("meta1", filename);
		metaData.put("meta2", contentType);
		metaData.put("_id", id);

		GridFSFile file = gridOperation.store(inputStream, filename, metaData);
		
		return file.getId().toString();
	}

	public GridFSDBFile getImage(String id) {
		System.out.println("Finding by ID: " + id);
		return gridOperation.findOne(new Query(Criteria.where("_id").is(new ObjectId(id))));
	}

}
