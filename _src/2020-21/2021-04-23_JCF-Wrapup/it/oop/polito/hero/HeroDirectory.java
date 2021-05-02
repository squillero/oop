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

import java.util.HashMap;
import java.util.Map;

final public class HeroDirectory {
	private static HeroDirectory instance;
	private Map<String,Hero> directory;
	
	private HeroDirectory() {
		directory = new HashMap<>();
	}
	
	static public HeroDirectory getInstance() {
		if(instance == null)
			instance = new HeroDirectory();
		
		return instance;
	}
	
	public boolean addHero(Hero hero) {
		if(directory.containsKey(hero.getName())) {
			return false;
		} else {
			directory.put(hero.getName(), hero);
			return true;
		}
	}
	
	public Hero getHero(String string) {
		if(!directory.containsKey(string)) {
			System.err.println("Yeuch, there is no: " + string);
		}
		return directory.get(string);
	}

	public void listHeroes() {
		for(Hero h: directory.values()) {
			System.out.println(h);
		}
	}
}
