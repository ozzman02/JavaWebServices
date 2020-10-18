package com.bharath.restws;

import com.bharath.restws.exceptions.CourseBusinessException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CourseBusinessExceptionMapper implements ExceptionMapper<CourseBusinessException> {

	@Override
	public Response toResponse(CourseBusinessException e) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"status\":\"error\"");
		sb.append(",");
		sb.append("\"message\":\"Try Again Later\"");
		sb.append("}");

		return Response.serverError().entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
	}

}
