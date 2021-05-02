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

public class Heroes {
	public static Hero addHero(String name) {
		Hero hero = new Hero(name);
		HeroDirectory.getInstance().addHero(hero);
		
		return hero;
	}

	public static ExtraterrestrialHero addExtraterrestrialHero(String name, String planet) {
		ExtraterrestrialHero hero = new ExtraterrestrialHero(name, planet);
		HeroDirectory.getInstance().addHero(hero);
		
		return hero;
	}
}
