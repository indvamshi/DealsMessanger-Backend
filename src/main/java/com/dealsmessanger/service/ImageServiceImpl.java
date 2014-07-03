package com.dealsmessanger.service;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private GridFsTemplate gridFsTemplate;
	
	public String saveImage(InputStream inputStream, String contentType, String filename, String id) {
		DBObject metaData = new BasicDBObject();
		metaData.put("targetId", id);

		GridFSFile file = gridFsTemplate.store(inputStream, filename, contentType, metaData);
		
		return file.getMetaData().get("targetId").toString();
	}

	public GridFSDBFile getImage(String id) {
		return gridFsTemplate.findOne(new Query(Criteria.where("metadata.targetId").is(id)));
	}

}
