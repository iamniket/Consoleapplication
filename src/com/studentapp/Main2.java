package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {

	private static List<Student> StudentList;

	public static void main(String[] args) {

		System.out.println("*************Student Management System************");
		System.out.println("********Welcome********");
		StudentList = new ArrayList<Student>();

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
		
		Student s4 = new Student("Vicky", 35, "S-17");
		s4.enrollCourse("DevOps");
		s4.printStudentInfo();

		StudentList.add(s1);
		StudentList.add(s2);
		StudentList.add(s3);
		StudentList.add(s4);

		Student result = findStudentByID("S-10");
		System.out.println("Result" + result);
		sortByName();

	}

	private static void sortByName() {

		Comparator<Student> studentNameComparator = (o1,o2) ->o1.getName().compareTo(o2.getName());
				
//				new Comparator<Student>() {
//
//			@Override
//			public int compare(Student o1, Student o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//		};
		Collections.sort(StudentList, studentNameComparator);
		System.out.println(StudentList);

	}

	private static Student findStudentByID(String studentID) {

		Student result = null;
		try {
			result = StudentList.stream().filter(x -> x.getStudentID().equalsIgnoreCase(studentID)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found!!"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentID + " not found");
		}

		return result;
	}

}
