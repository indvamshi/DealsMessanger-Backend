package com.dealsmessanger.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.dealsmessanger.service.ImageService;
import com.mongodb.gridfs.GridFSDBFile;

@Controller
@RequestMapping(value = "/image")
public class ImageController {

	@Autowired
	private ImageService imageService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> saveImage(@RequestParam("file") MultipartFile file,
			@RequestParam("id") String id, WebRequest request) {
		try {
			String imageId = imageService.saveImage(file.getInputStream(),
					file.getContentType(), file.getName(), id);

			HttpHeaders responseHeaders = new HttpHeaders();
			return new ResponseEntity<String>(imageId, responseHeaders,
					HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<String>(e.getMessage(),
					new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public void getById (@PathVariable (value="id") String id, HttpServletResponse response) throws IOException {
	        GridFSDBFile file = imageService.getImage(id);
	        if (file!=null) {
	            byte[] data = IOUtils.toByteArray(file.getInputStream());
	            response.setContentType(file.getContentType());
	            response.setContentLength((int)file.getLength());
	            response.getOutputStream().write(data);
	            response.getOutputStream().flush();
	        } else {
	            response.setStatus(HttpStatus.NOT_FOUND.value());
	        }
	    }  
}
