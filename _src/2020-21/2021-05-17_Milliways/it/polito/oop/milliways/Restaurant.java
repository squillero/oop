/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) May 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

package it.polito.oop.milliways;

public class Restaurant {
	public Race defineRace(String name) throws MilliwaysException {
		if(Directory.getInstance().getRace(name) != null)
			throw new MilliwaysException("Duplicated Race: '" + name + "'");		
		Race race = new Race(name);
		Directory.getInstance().addRace(race);
		return race;
	}

	public Party createParty() {
	    return new Party();
	}
}
