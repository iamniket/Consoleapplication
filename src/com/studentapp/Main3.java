package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	private static List<Student> StudentList;
	private static Scanner scanner;

	public static void main(String[] args) {

		System.out.println("*************Student Management System************");
		StudentList = new ArrayList<Student>();
		scanner = new Scanner(System.in);
		while (true) {
			System.out.println("********Welcome********");
			System.out.println("Select and option..");
			System.out.println("1. Enrolled a student");
			System.out.println("2. Find a student with studentID");
			System.out.println("3. List all student information");
			System.out.println("4. List all student in sorted order");
			System.out.println("5. Exit");

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				enrollStudent(scanner);
				break;
			case 2:
				findStudentbyID(scanner);
				break;
			case 3:
				printAllStudentData();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("Please Enter the valid input Between 1 to 5");

			}
		}
	}

	private static void exit() {

		System.exit(0);
	}

	private static void printAllStudentData() {

		if (StudentList.size() > 0) {
			System.out.println("=========PRINT ALL STUDENT DATA========");
			for (Student student : StudentList) {
				student.printStudentInfo();
			}
		} else {
			System.err.println("Student List is empty, Please Enter the Student Information");
		}

	}

	private static void findStudentbyID(Scanner scanner2) {

		Student studentfound = null;
		System.out.println("Please Enter the Student ID for search");
		String studentID = scanner2.next();
		try {
			studentfound = StudentList.stream().filter(x -> x.getStudentID().equalsIgnoreCase(studentID)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found!!"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentID + " not found");
		}

		studentfound.printStudentInfo();
	}

	private static void enrollStudent(Scanner scanner2) {

		System.out.println("Enter the student name...");
		String studentname = scanner2.next();

		System.out.println("Please Enter the age");
		int studentage = scanner2.nextInt();

		System.out.println("Please Enter the StudentID");
		String studentID = scanner2.next();

		Student newstudent = new Student(studentname, studentage, studentID);
		StudentList.add(newstudent);

		while (true) {
			System.out.println("Please enter the course to be enrolled.. and type exit to quit");
			String coursename = scanner2.next();
			if (coursename.equalsIgnoreCase("exit")) {
				break;
			}
			newstudent.enrollCourse(coursename);

		}
		newstudent.printStudentInfo();

	}

	private static void sortByName() {

		Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
		Collections.sort(StudentList, studentNameComparator);
		//System.out.println(StudentList);
		printAllStudentData();

	}

}
