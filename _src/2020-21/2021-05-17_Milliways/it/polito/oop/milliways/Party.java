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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Party {
	private Map<Race, Integer> companions;

	Party() {
		companions = new HashMap<>();
	}

	public void addCompanions(Race race, int num) {
		int oldNumber = 0;
		if (companions.containsKey(race))
			oldNumber = companions.get(race);
		companions.put(race, oldNumber + num);
	}

	public int getNum() {
		return companions.values().stream().collect(Collectors.summingInt(Integer::intValue));
	}

	public List<String> getRequirements() {
		TreeSet<String> requirements = new TreeSet<>();
		for(Race r: companions.keySet())
			requirements.addAll(r.getRequirements());
		return new ArrayList<String>(requirements);
		
		
		//return companions.keySet().stream().flatMap(r -> r.getRequirements().stream()).sorted().distinct()
		//		.collect(Collectors.toList());
	}
}
