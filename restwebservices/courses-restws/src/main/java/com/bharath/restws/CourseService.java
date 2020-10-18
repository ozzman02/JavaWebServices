package com.bharath.restws;

import com.bharath.restws.model.Course;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/courseservice")
public interface CourseService {

	@Path("/courses")
	@GET
	List<Course> getCourses();

	@Path("/courses/{id}")
	@GET
	Course getCourse(@PathParam("id") Long id);

	@Path("/courses")
	@POST
	Response createCourse(Course course);

	@Path("/courses")
	@PUT
	Response updateCourse(Course course);

	@Path("/courses/{id}")
	@DELETE
	Response deleteCourse(@PathParam("id") Long id);

}
