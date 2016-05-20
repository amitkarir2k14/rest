package com.amit.rest.examples.jerseyclient;

import java.util.Date;

import com.amit.rest.examples.pojo.Course;
import com.amit.rest.examples.pojo.CourseResult;
import com.amit.rest.examples.pojo.Student;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RestPostClient {

	public static void main(String[] args) {
		try {

			Student st = new Student("Adriana", "Barrer", 12, 9);
			addCourses(st);

			ClientConfig clientConfig = new DefaultClientConfig();

			clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

			Client client = Client.create(clientConfig);

			WebResource webResource = client.resource("http://localhost:9080/myapps/rest/student/send");

			ClientResponse response = webResource.accept("application/json").type("application/json")
					.post(ClientResponse.class, st);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Server response .... \n");
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

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