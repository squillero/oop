/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Apr 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

package it.oop.polito.hero;

import java.util.function.Consumer;

public class ExtraterrestrialHero extends Hero {
	private String planetOfOrigin;

	ExtraterrestrialHero(String name, String planetOfOrigin) {
		super(name);
		this.planetOfOrigin = planetOfOrigin;
	}
	
	@Override
	public String toString() {
		return "Hero \"" + name + "\" from " + planetOfOrigin;
	}
}
