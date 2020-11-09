package com.bharath.restws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

public class FileClient {

	private static final String FILE_NAME = "/Users/oscarsantamaria/Downloads/test.jpg";

	public static void main(String[] args) throws FileNotFoundException {

		WebClient client = WebClient.create("http://localhost:8080/services/fileservice/upload");
		client.type("multipart/form-data");
		ContentDisposition cd = new ContentDisposition("attachment;filename=test.jpg");
		Attachment attachment = new Attachment("root", new FileInputStream(new File(FILE_NAME)), cd);
		client.post(attachment);

	}

}
