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

public class Course extends StudentsArray {
	private String code;
	private String title;

	Course(String code, String title) {
		this.code = code;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public String getCode() {
		return code;
	}

	void setTitle(String title) {
		this.title = title;
	}
}
