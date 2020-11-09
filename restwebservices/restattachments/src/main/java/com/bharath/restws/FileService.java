package com.bharath.restws;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@Path("/fileservice")
@Service
public class FileService {

	private static final String FILE_PATH = "/Users/oscarsantamaria/git/personal/trainingnotes/Udemy/my_courses/JavaWebServices/uploaded/uploaded.jpg";

	@Path("/upload")
	@POST
	public void upload(List<Attachment> attachments) throws FileNotFoundException, IOException {
		for (Attachment attachment : attachments) {
			copyFile(attachment.getDataHandler().getInputStream());
		}
	}

	@GET
	@Path("/download")
	public Response download() {
		File file = new File(FILE_PATH);
		Response.ResponseBuilder responseBuilder = Response.ok(file);
		responseBuilder.header("Content-Disposition", "attachment;filename=downloaded.jpg");
		return responseBuilder.build();
	}

	private void copyFile(InputStream inputStream) throws FileNotFoundException, IOException {
		OutputStream out = null;
		int read = 0;
		byte[] bytes = new byte[1024];

		out = new FileOutputStream(new File(FILE_PATH));
		while ((read = inputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();	
	}

}