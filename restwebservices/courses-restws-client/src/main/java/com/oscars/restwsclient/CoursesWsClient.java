package com.oscars.restwsclient;

import com.oscars.restwsclient.model.Course;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

public class CoursesWsClient {
    private static final String COURSES = "/courses";
    private static final String COURSE_SERVICE_URL = "http://localhost:8080/restws/services/courseservice";

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(COURSE_SERVICE_URL).path(COURSES).path("/{id}").resolveTemplate("id", 123);
        Invocation.Builder request = target.request();
        Course course = request.get(Course.class);
        System.out.println(course.getId());
        System.out.println(course.getName());

        course.setName("Object Oriented Programming");

        WebTarget putTarget = client.target(COURSE_SERVICE_URL).path(COURSES);
        Response updateResponse = putTarget.request().put(Entity.entity(course, MediaType.APPLICATION_XML));
        System.out.println(updateResponse.getStatus());
        updateResponse.close();

        Course newCourse = new Course();
        newCourse.setName("Angular JS");
        newCourse.setPrice(new BigDecimal("9.99"));
        newCourse.setRating(1);
        newCourse.setTaughtBy("E.Morris");

        WebTarget postTarget = client.target(COURSE_SERVICE_URL).path(COURSES);
        Course createdCourse = postTarget.request().post(Entity.entity(newCourse, MediaType.APPLICATION_XML), Course.class);
        System.out.println("Created Course ID " + createdCourse.getId());

        WebTarget deleteTarget = client.target(COURSE_SERVICE_URL).path(COURSES).path("/{id}").resolveTemplate("id", 123);
        Response deleteResponse = deleteTarget.request().delete();
        System.out.println(deleteResponse.getStatus());
        deleteResponse.close();

        client.close();

    }
}
