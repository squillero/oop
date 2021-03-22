/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

package it.polito.oop.paintings;

public class Painting {
	private String title;
	private Painter author;
	private Period period;
	private String medium = null;
	private int year;
	
	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public int getYear() {
		return year;
	}

	public Painting(String title, int year) {
		this.title = title;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public Painter getAuthor() {
		return author;
	}

	public void setAuthor(Painter author) {
		if(author.getBirth() > year) {
			System.err.println(author + " was not born yet!");
			System.exit(1);
		}
		if(author.getDeath() < year && author.getDeath() > 0) {
			System.err.println(author + " was already dead!");
			System.exit(1);
		}
		this.author = author;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
	
	public String toString() {
		String tag = title + " (" + year + ") by " + author;
		if(medium != null) {
			tag = tag + " [" + medium + "]";
		}
		return tag;
	}
}
