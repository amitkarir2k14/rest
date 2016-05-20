package com.amit.rest.examples.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.amit.rest.examples.pojo.Course;
import com.amit.rest.examples.pojo.CourseResult;
import com.amit.rest.examples.pojo.Student;

@Path("/student")
public class JSONStudentService {

	@GET
	@Path("/print/json/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudentJsonRepresentation(@PathParam("name") String name) {
		List<Student> students = new ArrayList<Student>();
		Student st = new Student(name, "Diaz", 22, 1);
		addCourses(st);
		students.add(st);
		st = new Student("Cameron", "Diaz", 39, 2);
		addCourses(st);
		students.add(st);
		return students;

	}

	@GET
	@Path("/print/xml/{name}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Student> getStudentXmlRepresentation(@PathParam("name") String name) {
		List<Student> students = new ArrayList<Student>();
		Student st = new Student(name, "Diaz", 22, 1);
		addCourses(st);
		students.add(st);
		st = new Student("Cameron", "Diaz", 39, 2);
		addCourses(st);
		students.add(st);
		return students;

	}

	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertOrUpdateStudent(Student student) {
		String output = student.toString();
		return Response.status(200).entity(output).build();
	}

	private static void addCourses(Student st) {
		Course course = new Course();
		course.setAchievedPerc(40.5);
		course.setCourseID(1);
		course.setCourseName("Mathematics");
		course.setMinPercReqd(60.0);
		course.setResult(CourseResult.Fail);
		course.setResultDate(new Date());
		st.getCourses().add(course);
		course = new Course();
		course.setAchievedPerc(90.75);
		course.setCourseID(2);
		course.setCourseName("Physics");
		course.setMinPercReqd(60.0);
		course.setResult(CourseResult.Pass);
		course.setResultDate(new Date());
		st.getCourses().add(course);
	}

}