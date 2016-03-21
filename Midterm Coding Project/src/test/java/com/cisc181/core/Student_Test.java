package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {

	static ArrayList<Course> CourseList = new ArrayList <Course>();
	static ArrayList<Semester> SemesterList = new ArrayList< Semester>();
	static ArrayList<Section> SectionList = new ArrayList <Section>();
	static ArrayList<Student> StudentList = new ArrayList <Student>();
	static ArrayList<Enrollment> EnrollmentList = new ArrayList <Enrollment>();
	
	@BeforeClass
	public static void setup() {
		
	//Courses
	Course Math = new Course(UUID.randomUUID(), "Math", 100, eMajor.BUSINESS);
	Course Science = new Course(UUID.randomUUID(), "Science", 100, eMajor.CHEM);
	Course English = new Course(UUID.randomUUID(), "English", 100, eMajor.BUSINESS);
	
	CourseList.add(Math);
	CourseList.add(Science);
	CourseList.add(English);
	
	//Semester
	Calendar StartDate = Calendar.getInstance();
	StartDate.set(2015, Calendar.AUGUST, 22);
	Date Start = StartDate.getTime();
	StartDate.set(2015, Calendar.JANUARY, 22);
	Date Start2 = StartDate.getTime();
	
	Calendar EndDate = Calendar.getInstance();
	EndDate.set(2015, Calendar.DECEMBER, 15);
	Date End = EndDate.getTime();
	EndDate.set(2016, Calendar.JUNE, 15);
	Date End2 = EndDate.getTime();
	
	Semester Spring = new Semester(UUID.randomUUID(), Start, End);
	Semester Fall = new Semester(UUID.randomUUID(), Start2, End2);
	
	SemesterList.add(Spring);
	SemesterList.add(Fall);
	
	//Sections	
	Section MathS = new Section(SemesterList.get(0).getSemesterID(), CourseList.get(0).getCourseID(), UUID.randomUUID(), 1);
	Section MathF = new Section(SemesterList.get(1).getSemesterID(), CourseList.get(0).getCourseID(), UUID.randomUUID(), 1);
	Section ScienceS = new Section(SemesterList.get(0).getSemesterID(), CourseList.get(1).getCourseID(), UUID.randomUUID(), 2);
	Section ScienceF = new Section(SemesterList.get(1).getSemesterID(), CourseList.get(1).getCourseID(), UUID.randomUUID(), 2);
	Section EnglishS = new Section(SemesterList.get(0).getSemesterID(), CourseList.get(2).getCourseID(), UUID.randomUUID(), 3);
	Section EnglishF = new Section(SemesterList.get(1).getSemesterID(), CourseList.get(2).getCourseID(), UUID.randomUUID(), 3);
	
	SectionList.add(MathS);
	SectionList.add(MathF);
	SectionList.add(ScienceS);
	SectionList.add(ScienceF);
	SectionList.add(EnglishS);
	SectionList.add(EnglishF);
	
	//Students (all will have the same DOB, Phone, Address, and Email.)
	Calendar Date1 = Calendar.getInstance();
	Date1.set(1997, Calendar.DECEMBER, 23);
	Date DOB = Date1.getTime();
	
	Student Student1 = new Student("Henry", "C.", "Werth", DOB, eMajor.BUSINESS,
			"123 Fake Street", "3025555555", "publicEmail@udel.edu"); 
	
	Student Student2 = new Student("Sarah", "W.", "Kiln", DOB, eMajor.NURSING,
			"123 Fake Street", "3025555555", "publicEmail@udel.edu");
	
	Student Student3 = new Student("Harrison", "F.", "Ford", DOB, eMajor.BUSINESS,
			"123 Fake Street", "3025555555", "publicEmail@udel.edu"); 
	
	Student Student4 = new Student("John", "F.", "Kennedy", DOB, eMajor.COMPSI,
			"123 Fake Street", "3025555555", "publicEmail@udel.edu"); 
	
	Student Student5 = new Student("David", "C.", "Heck", DOB, eMajor.COMPSI,
			"123 Fake Street", "3025555555", "publicEmail@udel.edu");
	
	Student Student6 = new Student("Allison", "V.", "Keel", DOB, eMajor.CHEM,
			"123 Fake Street", "3025555555", "publicEmail@udel.edu"); 
	
	Student Student7 = new Student("Andrew", "K.", "Constantine", DOB, eMajor.PHYSICS,
			"123 Fake Street", "3025555555", "publicEmail@udel.edu");
	
	Student Student8 = new Student("Peter", "L.", "Doob", DOB, eMajor.CHEM,
			"123 Fake Street", "3025555555", "publicEmail@udel.edu"); 
	
	Student Student9 = new Student("Owen", "M.", "Porth", DOB, eMajor.PHYSICS,
			"123 Fake Street", "3025555555", "publicEmail@udel.edu"); 
	
	Student Student10 = new Student("Jake", "C.", "Rankin", DOB, eMajor.BUSINESS,
			"123 Fake Street", "3025555555", "publicEmail@udel.edu"); 

	StudentList.add(Student1);
	StudentList.add(Student2);
	StudentList.add(Student3);
	StudentList.add(Student4);
	StudentList.add(Student5);
	StudentList.add(Student6);
	StudentList.add(Student7);
	StudentList.add(Student8);
	StudentList.add(Student9);
	StudentList.add(Student10);
	
	}

	@Test
	public void testEnrollmentGrades() {
		/*
		 * I'm adding each student to each section with a grade of 100 so the GPA and Average is easy to keep track of.
		 * Since we can choose whatever grades we want I believe this is legal.
		 */
		
		//Section 1 (MathS)
		for(Student i: StudentList){
			Enrollment A = new Enrollment(SectionList.get(0).getSectionID(), i.getStudentID());
			A.setGrade(100);
			EnrollmentList.add(A);
		}
		// Section 2 (MathF)
		for (Student i : StudentList) {
			Enrollment A = new Enrollment(SectionList.get(1).getSectionID(), i.getStudentID());
			A.setGrade(100);
			EnrollmentList.add(A);
		}
		// Section 3 (ScienceS)
		for (Student i : StudentList) {
			Enrollment A = new Enrollment(SectionList.get(2).getSectionID(), i.getStudentID());
			A.setGrade(100);
			EnrollmentList.add(A);
		}
		// Section 4 (ScienceF)
		for (Student i : StudentList) {
			Enrollment A = new Enrollment(SectionList.get(3).getSectionID(), i.getStudentID());
			A.setGrade(100);
			EnrollmentList.add(A);
		}
		// Section 5 (EnglishS)
		for (Student i : StudentList) {
			Enrollment A = new Enrollment(SectionList.get(4).getSectionID(), i.getStudentID());
			A.setGrade(100);
			EnrollmentList.add(A);
		}
		// Section 6 (EnglishF)
		for (Student i : StudentList) {
			Enrollment A = new Enrollment(SectionList.get(5).getSectionID(), i.getStudentID());
			A.setGrade(100);
			EnrollmentList.add(A);
		}
		
		/*
		 * Since The GPA for each student will be 4.0, it is not necessary to test for different GPA calculations.
		 * I will simply be testing that each student does in fact have 100 in each class and setting the GPA to 4.0.
		 */
		
		// Determining Student GPA Student 1
		double Student1 = 0;
		double Student1_GPA = 0;
		for (int i = 0; i < EnrollmentList.size(); i += 10) {
			// Checking manually to see if student ID is the same for all sections, if it is average it out.
			// System.out.println(EnrollmentList.get(i).getStudentID()); // All good, continue with GPA test.
			Student1 += EnrollmentList.get(i).getGrade();
		}
		if (Student1 == 100.0 * 6) {
			Student1_GPA += 4.0;
		}
		assertTrue(Student1_GPA == 4.0);

		
		// Determining Student GPA Student 2
		double Student2 = 0;
		double Student2_GPA = 0;
		for (int i = 1; i < EnrollmentList.size(); i += 10) {
			// Checking manually to see if student ID is the same for all sections, if it is average it out.
			// System.out.println(EnrollmentList.get(i).getStudentID()); // All good, continue with GPA test.
			Student2 += EnrollmentList.get(i).getGrade();
		}
		if (Student2 == 100.0 * 6) {
			Student2_GPA += 4.0;
		}
		assertTrue(Student2_GPA == 4.0);
		
		
		// Determining Student GPA Student 3
		double Student3 = 0;
		double Student3_GPA = 0;
		for (int i = 2; i < EnrollmentList.size(); i += 10) {
			// Checking manually to see if student ID is the same for all sections, if it is average it out.
			// System.out.println(EnrollmentList.get(i).getStudentID()); // All good, continue with GPA test.
			Student3 += EnrollmentList.get(i).getGrade();
		}
		if (Student3 == 100.0 * 6) {
			Student3_GPA += 4.0;
		}
		assertTrue(Student3_GPA == 4.0);
		
		
		// Determining Student GPA Student 4
		double Student4 = 0;
		double Student4_GPA = 0;
		for (int i = 3; i < EnrollmentList.size(); i += 10) {
			// Checking manually to see if student ID is the same for all sections, if it is average it out.
			// System.out.println(EnrollmentList.get(i).getStudentID()); // All good, continue with GPA test.
			Student4 += EnrollmentList.get(i).getGrade();
		}
		if (Student4 == 100.0 * 6) {
			Student4_GPA += 4.0;
		}
		assertTrue(Student4_GPA == 4.0);
		
		
		// Determining Student GPA Student 5
		double Student5 = 0;
		double Student5_GPA = 0;
		for (int i = 4; i < EnrollmentList.size(); i += 10) {
			// Checking manually to see if student ID is the same for all sections, if it is average it out.
			// System.out.println(EnrollmentList.get(i).getStudentID()); // All good, continue with GPA test.
			Student5 += EnrollmentList.get(i).getGrade();
		}
		if (Student5 == 100.0 * 6) {
			Student5_GPA += 4.0;
		}
		assertTrue(Student5_GPA == 4.0);

		
		// Determining Student GPA Student 6
		double Student6 = 0;
		double Student6_GPA = 0;
		for (int i = 5; i < EnrollmentList.size(); i += 10) {
			// Checking manually to see if student ID is the same for all sections, if it is average it out.
			// System.out.println(EnrollmentList.get(i).getStudentID()); // All good, continue with GPA test.
			Student6 += EnrollmentList.get(i).getGrade();
		}
		if (Student6 == 100.0 * 6) {
			Student6_GPA += 4.0;
		}
		assertTrue(Student6_GPA == 4.0);

		
		// Determining Student GPA Student 7
		double Student7 = 0;
		double Student7_GPA = 0;
		for (int i = 6; i < EnrollmentList.size(); i += 10) {
			// Checking manually to see if student ID is the same for all sections, if it is average it out.
			// System.out.println(EnrollmentList.get(i).getStudentID()); // All good, continue with GPA test.
			Student7 += EnrollmentList.get(i).getGrade();
		}
		if (Student7 == 100.0 * 6) {
			Student7_GPA += 4.0;
		}
		assertTrue(Student7_GPA == 4.0);
		
		
		// Determining Student GPA Student 8
		double Student8 = 0;
		double Student8_GPA = 0;
		for (int i = 7; i < EnrollmentList.size(); i += 10) {
			// Checking manually to see if student ID is the same for all sections, if it is average it out.
			// System.out.println(EnrollmentList.get(i).getStudentID()); // All good, continue with GPA test.
			Student8 += EnrollmentList.get(i).getGrade();
		}
		if (Student8 == 100.0 * 6) {
			Student8_GPA += 4.0;
		}
		assertTrue(Student8_GPA == 4.0);
		
		
		// Determining Student GPA Student 9
		double Student9 = 0;
		double Student9_GPA = 0;
		for (int i = 8; i < EnrollmentList.size(); i += 10) {
			// Checking manually to see if student ID is the same for all sections, if it is average it out.
			// System.out.println(EnrollmentList.get(i).getStudentID()); // All good, continue with GPA test.
			Student9 += EnrollmentList.get(i).getGrade();
		}
		if (Student9 == 100.0 * 6) {
			Student9_GPA += 4.0;
		}
		assertTrue(Student9_GPA == 4.0);
		
		
		// Determining Student GPA Student 10
		double Student10 = 0;
		double Student10_GPA = 0;
		for (int i = 9; i < EnrollmentList.size(); i += 10) {
			// Checking manually to see if student ID is the same for all sections, if it is average it out.
			// System.out.println(EnrollmentList.get(i).getStudentID()); // All good, continue with GPA test.
			Student10 += EnrollmentList.get(i).getGrade();
		}
		if (Student10 == 100.0 * 6) {
			Student10_GPA += 4.0;
		}
		assertTrue(Student10_GPA == 4.0);
		
		/*
		 * Determining each courses average grade, once again since each grade is 100 I will just test to
		 * make sure that each course contains an 100 point average.
		 */
		
		//Determining Class Average for MathS
		double AverageMS = 0;
		for (int i = 0; i < 10; i++) {
			//Making sure that each of the 10 students are in the same section/course.
			//System.out.println(EnrollmentList.get(i).getSectionID()); // All good, continue with Course tests.
			AverageMS += EnrollmentList.get(i).getGrade();
		}
		assertTrue((AverageMS/10) == 100.0);

		//Determining Class Average for MathF
		double AverageMF = 0;
		for (int i = 10; i < 20; i++) {
			//Making sure that each of the 10 students are in the same section/course.
			//System.out.println(EnrollmentList.get(i).getSectionID()); // All good, continue with Course tests.
			AverageMF += EnrollmentList.get(i).getGrade();
		}
		assertTrue((AverageMF/10) == 100.0);
		
		//Determining Class Average for ScienceS
		double AverageSS = 0;
		for (int i = 20; i < 30; i++) {
			//Making sure that each of the 10 students are in the same section/course.
			//System.out.println(EnrollmentList.get(i).getSectionID()); // All good, continue with Course tests.
			AverageSS += EnrollmentList.get(i).getGrade();
		}
		assertTrue((AverageSS/10) == 100.0);

		//Determining Class Average for ScienceF
		double AverageSF = 0;
		for (int i = 30; i < 40; i++) {
			//Making sure that each of the 10 students are in the same section/course.
			//System.out.println(EnrollmentList.get(i).getSectionID()); // All good, continue with Course tests.
			AverageSF += EnrollmentList.get(i).getGrade();
		}
		assertTrue((AverageSF/10) == 100.0);
		
		//Determining Class Average for EnglishS
		double AverageES = 0;
		for (int i = 20; i < 30; i++) {
			//Making sure that each of the 10 students are in the same section/course.
			//System.out.println(EnrollmentList.get(i).getSectionID()); // All good, continue with Course tests.
			AverageES += EnrollmentList.get(i).getGrade();
		}
		assertTrue((AverageES/10) == 100.0);

		//Determining Class Average for EnglishF
		double AverageEF = 0;
		for (int i = 50; i < 60; i++) {
			//Making sure that each of the 10 students are in the same section/course.
			//System.out.println(EnrollmentList.get(i).getSectionID()); // All good, continue with Course tests.
			AverageEF += EnrollmentList.get(i).getGrade();
		}
		assertTrue((AverageEF/10) == 100.0);
	}


	@Test
	//Testing for a major change.
	public void testMajorChange() {
		StudentList.get(0).setMajor(eMajor.COMPSI);
		assertTrue(StudentList.get(0).getMajor() == eMajor.COMPSI);
	}
}