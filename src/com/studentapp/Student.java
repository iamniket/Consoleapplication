package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	private String name;
	private int age;
	private String StudentID;
	private List<String> courses;

	public Student(String name, int age, String studentID) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentID(studentID)) {
			this.name = name;
			this.age = age;
			StudentID = studentID;
			courses = new ArrayList<String>();
		}
	}

	public void enrollCourse(String course) {
		if (validateCourse(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println("Student is enrolled to " + course + " Successfully");

			} else {
				System.err.println("Student is already Enrolled for the course " + course);
			}
		}

	}

	public void printStudentInfo() {
		System.out.println("**********Student Information*********");
		System.out.println("Student Name " + name);
		System.out.println("Student age " + age);
		System.out.println("Student studentID " + StudentID);
		System.out.println("Enrolled for " + courses);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", StudentID=" + StudentID + ", courses=" + courses + "]";
	}

	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else
			System.err.println("Invalid age !! , Please enter the age between 19 and 35");
		return false;
	}

	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z//s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid name !!, Please enter the valid name");
			return false;
		}
	}

	public boolean validateStudentID(String StudentID) {
		String studentIDRegex = "S-\\d+$";
		Pattern studentIDPattern = Pattern.compile(studentIDRegex);
		Matcher studentIDMatcher = studentIDPattern.matcher(StudentID);
		if (studentIDMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid StudentID!!, Please Enter the Valid student ID");
			return false;
		}
	}

	public boolean validateCourse(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("DevOps")) {
			return true;
		} else {
			System.err.println("Invalid course , Please select the course from List [Java, DSA, DevOps]");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentID() {
		return StudentID;
	}

	public List<String> getCourses() {
		return courses;
	}
	
	

}