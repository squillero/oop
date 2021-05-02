/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Apr 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

package it.polito.oop.movie;

import java.util.HashSet;
import java.util.Set;

public final class Staff {
	private Set<Director> directors;
	static Staff instance = null;

	private Staff() {
		directors = new HashSet<>();
	}

	public static Staff getInstance() {
		if(instance == null)
			instance = new Staff();
		return instance;
	}
	
	
	public void addDirector(Director director) throws MovieException {
		if(director == null) {
			throw new MovieDisasterException("NULL director");
		} else if(directors.contains(director)) {
			throw new MovieDirectorException("Duplicated director: " + director.getName());
		}
		directors.add(director);
	}
}
