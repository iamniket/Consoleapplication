package com.studentapp;

public class Main {

	public static void main(String[] args) {

		System.out.println("*************Student Management System************");
		System.out.println("********Welcome********");
		
		Student s1 = new Student("Samdish", 25, "S-1");
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.printStudentInfo();
		
		Student s2 = new Student("Shital", 30, "S-2");
		s2.enrollCourse("DevOps");
		s2.printStudentInfo();
		
		Student s3 = new Student("Niket", 34, "S-3");
		s3.enrollCourse("DSA");
		s3.printStudentInfo();
	
	
	}

}
