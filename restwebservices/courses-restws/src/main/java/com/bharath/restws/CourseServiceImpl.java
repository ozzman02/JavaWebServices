package com.bharath.restws;

import com.bharath.restws.exceptions.CourseBusinessException;
import com.bharath.restws.model.Course;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.*;

@Service
public class CourseServiceImpl implements CourseService {

	Map<Long, Course> courses = new HashMap<>();
	long currentId = 123;

	public CourseServiceImpl() {
		init();
	}

	void init() {
		Course course = new Course();
		course.setId(currentId);
		course.setName("Mathematics");
		course.setPrice(new BigDecimal("10.99"));
		course.setRating(1);
		course.setTaughtBy("A.Philips");
		courses.put(course.getId(), course);
	}

	@Override
	public List<Course> getCourses() {
		Collection<Course> results = courses.values();
		List<Course> response = new ArrayList<>(results);
		return response;
	}

	@Override
	public Course getCourse(Long id) {
		if (courses.get(id) == null) {
			throw new NotFoundException();
		}
		return courses.get(id);
	}

	@Override
	public Response createCourse(Course course) {
		course.setId(++currentId);
		courses.put(course.getId(), course);
		return Response.ok(course).build();
	}

	@Override
	public Response updateCourse(Course course) {

		Course currentCourse = courses.get(course.getId());

		Response response;
		if (currentCourse != null) {
			courses.put(course.getId(), course);
			response = Response.ok().build();
		} else {
			throw new CourseBusinessException();
		}
		return response;
	}

	@Override
	public Response deleteCourse(Long id) {
		Course course = courses.get(id);

		Response response;

		if (course != null) {
			courses.remove(id);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

}
