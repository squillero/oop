/*-************************************************************************-*\
*             *  CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)      *
*   #####     *  (!) Mar-2020, Giovanni Squillero <squillero@polito.it>      *
*  ######     *                                                              *
*  ###   \    *  Copying and distributing this file, either with or without  *
*   ##G  c\   *  modification, are permitted in any medium without royalty,  *
*   #     _\  *  provided that this 10-line comment is preserved.            *
*   |  _/     *                                                              *
*             *  ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <===  *
\*-************************************************************************-*/

package it.polito.oop.university;

public class University {
	private String name;
	private Course[] courseArray = new Course[100];
	private int numCourses = 0; // technically useless (0 is the default)
	private Student[] studentArray = new Student[100];
	private int numStudents = 0; // technically useless (0 is the default)

	public University(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Course createCourse(String code, String title) {
		Course course = new Course(code, title);
		courseArray[numCourses++] = course;
		return course;
	}

	public Student createStudent(String id, String name) {
		Student student = new Student(id, name);
		studentArray[numStudents++] = student;
		return student;
	}

	public void printCourses() {
		for (int i = 0; i < numCourses; ++i)
			System.out.println(i + 1 + ": " + courseArray[i].getTitle() + " (" + courseArray[i].getCode() + ")");
	}

	public void printStudents() {
		for (int i = 0; i < numStudents; ++i)
			System.out.println(i + 1 + ": " + studentArray[i].getName() + " (" + studentArray[i].getId() + ")");
	}

	public void enroll(Course course, Student student) {
		course.addStudent(student);
	}
}
