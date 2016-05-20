package com.amit.rest.examples.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@XmlRootElement(name = "student")
@XmlType(propOrder = {"id", "lastName", "firstName", "age","courses"})
@JsonPropertyOrder({"id", "lastName", "firstName", "age"})
@JsonIgnoreProperties({"courses"})
public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	@XmlElementWrapper(name="coursesUndertaken")
    @XmlElement(name="course")
	private List<Course> courses;

	public Student() {
	}

	public Student(String fname, String lname, int age, int id) {
		this.firstName = fname;
		this.lastName = lname;
		this.age = age;
		this.id = id;
		this.courses = new ArrayList<Course>();
	}

	@XmlElement
	public void setFirstName(String fname) {
		this.firstName = fname;
	}

	public String getFirstName() {
		return this.firstName;
	}

	@XmlElement
	public void setLastName(String lname) {
		this.lastName = lname;
	}

	public String getLastName() {
		return this.lastName;
	}

	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return new StringBuffer(" First Name : ").append(this.firstName).append(" Last Name : ").append(this.lastName)
				.append(" Age : ").append(this.age).append(" ID : ").append(this.id).toString();
	}

	public List<Course> getCourses() {
		return courses;
	}
	
}
