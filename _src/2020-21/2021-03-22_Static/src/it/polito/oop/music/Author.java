/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

package it.polito.oop.music;

public class Author {
	final private String name;
	private Song[] songs;
	
	public Author(String name) {
		this.name = name;
	}
	
	public Author() {
		this.name = "Queen";
	}
	
	public Song[] getSongs() {
		return songs;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name;
	}
}
