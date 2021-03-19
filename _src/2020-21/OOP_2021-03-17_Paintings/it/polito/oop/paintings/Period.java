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

public class Period {
	private String name;
	private int beginning, end;

	public Period(String name, int beginning, int end) {
		this.name = name;
		this.beginning = beginning;
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public int getBeginning() {
		return beginning;
	}

	public int getEnd() {
		return end;
	}

	public String toString() {
		if (beginning % 100 == 0 && end == beginning + 100) {
			return name + " (" + (beginning / 100 + 1) + "th century)";
		} else if (beginning % 100 == 0 && end % 100 == 0) {
			return name + " (" + (beginning / 100 + 1) + "th-" + (end / 100 + 1) + "th century)";
		} else {
			return name + " (" + beginning + "-" + end + ")";
		}
	}
}
