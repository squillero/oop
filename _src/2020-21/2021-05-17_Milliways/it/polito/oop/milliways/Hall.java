/*-************************************************************************-*\
*             *  CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)      *
*   #####     *  (!) May-2021, Giovanni Squillero <squillero@polito.it>      *
*  ######     *                                                              *
*  ###   \    *  Copying and distributing this file, either with or without  *
*   ##G  c\   *  modification, are permitted in any medium without royalty,  *
*   #     _\  *  provided that this 10-line comment is preserved.            *
*   |  _/     *                                                              *
*             *  ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <===  *
\*-************************************************************************-*/

package it.polito.oop.milliways;

import java.util.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;

public class Hall implements Comparable<Hall> {
	private int id;
	private Set<String> facilities;
	private List<Party> seatedParties;
	
	static long differentChars(String string) {
		return Stream.of(string.split("")).distinct().collect(Collectors.counting());
	}
	
	Hall(int id) {
		this.id = id;
		this.facilities = new TreeSet<>();
		this.seatedParties = new ArrayList<>();
	}

	public int getId() {
		return id;
	}
	
	public void addFacility(String facility) throws MilliwaysException {
		if(!facilities.add(facility))
			throw new MilliwaysException("Duplicated facility: '" + facility + "'");
	}
	
	public List<String> getFacilities() {
		return new ArrayList<>(facilities);
	}
	
	public boolean isSuitable(Party party) {
		for(String requirement: party.getRequirements())
			if(!facilities.contains(requirement))
				return false;
		return true;
	}

	public List<String> getFacilitiesCrazy() {
		TreeSet<String> crazy = new TreeSet<>(Comparator.comparing(Hall::differentChars));
		crazy.addAll(facilities);
		return new ArrayList<>(crazy);
	}
	
	void seat(Party party) {
		seatedParties.add(party);
	}
	
	Stream<Party> streamSeatedParties() {
		return seatedParties.stream();
	}

	List<Party> getSeatedParties() {
		return new ArrayList<>(seatedParties);
	}

	@Override
	public String toString() {
		return "Hall [id=" + id + ", facilities=" + facilities + "]";
	}

	@Override
	public int compareTo(Hall o) {
		return Integer.compare(id, o.id);
	}
}
