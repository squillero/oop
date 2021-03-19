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

public class Painter {
	private String name;
	private int birth, death;
	
	public Painter(String name, int birth, int death) {
		this.name = name;
		this.birth = birth;
		this.death = death;
	}

	String getName() {
		return name;
	}

	int getBirth() {
		return birth;
	}

	int getDeath() {
		return death;
	}

	public String toString() {
		String tag;
		tag = name + " (" + birth + "-";
		if(death > birth) {
			tag = tag + death;
		}
		tag = tag + ")";
		return tag;
	}
}
