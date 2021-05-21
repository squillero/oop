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

import java.util.Map;
import java.util.HashMap;

public class Directory {
	private static Directory instance = null;
	
	private Map<String,Race> racesDirectory = null;
	
	private Directory() {
		racesDirectory = new HashMap<>();
	}
	
	static public Directory getInstance() {
		if(instance == null)
			instance = new Directory();
		return instance;
	}
	
	public Race getRace(String name) {
		return racesDirectory.get(name);
	}
	
	public void addRace(Race race) {
		racesDirectory.put(race.getName(), race);
	}
}
