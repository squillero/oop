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
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Restaurant {
	public Race defineRace(String name) throws MilliwaysException {
		if (Directory.getInstance().getRace(name) != null)
			throw new MilliwaysException("Duplicated Race: '" + name + "'");
		Race race = new Race(name);
		Directory.getInstance().addRace(race);
		return race;
	}

	public Party createParty() {
		return new Party();
	}

	public Hall defineHall(int id) throws MilliwaysException {
		if (Directory.getInstance().getHall(id) != null)
			throw new MilliwaysException("Duplicated Hall: '" + id + "'");
		Hall hall = new Hall(id);
		Directory.getInstance().addHall(hall);
		return hall;
	}

	public List<Hall> getHallList() {
		return Directory.getInstance().getHallList();
	}

	public Hall seat(Party party, Hall hall) throws MilliwaysException {
		if (!hall.isSuitable(party))
			throw new MilliwaysException("Can't seat party!");
		hall.seat(party);
		return hall;
	}

	public Hall seat(Party party) throws MilliwaysException {
		for (Hall h : getHallList())
			if (h.isSuitable(party))
				return seat(party, h);
		throw new MilliwaysException("Can't seat party!");
	}

	public Map<Race, Integer> statComposition_stream() {
		/** debug
		Directory.getInstance().getHallList().stream().flatMap(Hall::streamSeatedParties).forEach(System.out::println);
		System.out.println("\n");
		Directory.getInstance().getHallList().stream().flatMap(Hall::streamSeatedParties)
				.flatMap(p -> p.getCompanions().entrySet().stream()).forEach(System.out::println);
		System.out.println("\n");
		**/
		return Directory.getInstance().getHallList().stream().flatMap(Hall::streamSeatedParties)
				.flatMap(p -> p.getCompanions().entrySet().stream())
				.collect(Collectors.groupingBy(Entry::getKey, TreeMap::new, Collectors.summingInt(Entry::getValue)));
	}

	public Map<Race, Integer> statComposition_jcf() {
		Map<Race, Integer> result = new TreeMap<>();
		
		for(Hall hall: Directory.getInstance().getHallList()) {
			for(Party party: hall.getSeatedParties()) {
				Map<Race, Integer> companions = party.getCompanions();
				for(Race race: companions.keySet()) {
					int val = 0;
					if(result.containsKey(race))
						val = result.get(race);
					result.put(race, val+companions.get(race));
				}
			}
		}
		return result;
	}

}
