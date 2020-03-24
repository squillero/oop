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

import it.polito.oop.university.University;
import it.polito.oop.university.Course;
import it.polito.oop.university.Student;

public class TestApplication {
	public static void main(String[] args) {
		University polito = new University("Politecnico di Torino");
		
		Course oop = polito.createCourse("04JEY", "Object Oriented Programming");		
		Course dep = polito.createCourse("01TXH", "Data Ethics and Protection");
		polito.printCourses();
		
		Student alice = polito.addStudent("123456", "Alice");
		Student bob = polito.addStudent("654321", "Bob");
		Student carla = polito.addStudent("162534", "Carla");
		Student david = polito.addStudent("615243", "David");
		polito.printStudents();
		
		polito.enroll(oop, alice);
		polito.enroll(oop, david);
		oop.printStudents();
	}
}
