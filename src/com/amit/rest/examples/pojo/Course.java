package com.amit.rest.examples.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@XmlRootElement(name = "Courses")
@XmlType(propOrder = { "courseID", "courseName", "minPercReqd", "achievedPerc", "result", "resultDate" })
public class Course {

	private int courseID;
	private String courseName;
	private double minPercReqd;
	private double achievedPerc;
	private CourseResult result;
	private Date resultDate;

	public int getCourseID() {
		return courseID;
	}

	@XmlAttribute(name = "id")
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public double getMinPercReqd() {
		return minPercReqd;
	}

	@XmlElement(name = "minPercentgeRequired")
	public void setMinPercReqd(double minPercReqd) {
		this.minPercReqd = minPercReqd;
	}

	public double getAchievedPerc() {
		return achievedPerc;
	}

	@XmlElement(name = "percentageAchievedInSubject")
	public void setAchievedPerc(double achievedPerc) {
		this.achievedPerc = achievedPerc;
	}

	public CourseResult getResult() {
		return result;
	}

	@XmlElement(name = "courseResult")
	public void setResult(CourseResult result) {
		this.result = result;
	}

	@JsonSerialize(using = DateSerializer.class)
	public Date getResultDate() {
		return resultDate;
	}

	@XmlElement(name = "resultPublishedOn")
	@JsonDeserialize(using = DateDeSerializer.class)
	public void setResultDate(Date resultDate) {
		this.resultDate = resultDate;
	}

	public String getCourseName() {
		return courseName;
	}

	@XmlElement(name = "subjectName")
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
