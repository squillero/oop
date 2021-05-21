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

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashSet;

public class Race implements Comparable<Race> {
	private String name;
	private HashSet<String> requirements;

	public Race(String name) {
		this.name = name;
		this.requirements = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public void addRequirement(String requirement) throws MilliwaysException {
		boolean newRequirement = requirements.add(requirement);
		if (!newRequirement)
			throw new MilliwaysException("Duplicated requirement: '" + requirement + "'");
	}

	public List<String> getRequirements() {
		return requirements.stream().sorted().collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Race o) {
		return name.compareTo(o.name);
	}
}
