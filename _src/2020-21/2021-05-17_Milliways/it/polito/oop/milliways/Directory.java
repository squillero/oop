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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Directory {
	private static Directory instance = null;
	
	private Map<String,Race> racesDirectory = null;
	private LinkedList<Hall> hallDirectory = null;
	
	private Directory() {
		racesDirectory = new HashMap<>();
		hallDirectory = new LinkedList<>();
	}
	
	static public Directory getInstance() {
		if(instance == null)
			instance = new Directory();
		return instance;
	}
	
	static public void reset() {
		instance = new Directory();
	}
	
	public Race getRace(String name) {
		return racesDirectory.get(name);
	}
	
	public void addRace(Race race) {
		racesDirectory.put(race.getName(), race);
	}
	
	public void addHall(Hall hall) {
		hallDirectory.addLast(hall);
	}
	
	public Hall getHall(int id) {
		for(Hall h: hallDirectory)
			if(h.getId() == id)
				return h;
		return null;
	}
	
	public List<Hall> getHallList() {
		return new ArrayList<>(hallDirectory);
	}
}
