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

abstract class StudentsArray {
	private Student[] enrolledStudents = new Student[300];
	private int numStudents = 0;

	public void addStudent(Student student) {
		this.enrolledStudents[this.numStudents++] = student;
	}

	public Student addStudent(String id, String name) {
		Student student = new Student(id, name);
		this.addStudent(student);
		return student;
	}

	public void printStudents() {
		for (int i = 0; i < numStudents; ++i)
			System.out.println(i + 1 + ": " + enrolledStudents[i].getName() + " (" + enrolledStudents[i].getId() + ")");
	}
}
