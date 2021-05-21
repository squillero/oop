/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) May 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import it.polito.oop.milliways.*;

public class TestApplication {
	public static void main(String... args) throws MilliwaysException {
	    Restaurant milliways = new Restaurant();

		// Create a fews standard races
		Race race1 = milliways.defineRace("Amoeboid Zingatularians");
		Race race2 = milliways.defineRace("Betelgeusians");
		Race race3 = milliways.defineRace("Blagulon Kappans");
		Race race4 = milliways.defineRace("Golgafrinchans");
		Race race5 = milliways.defineRace("Jatravartids");
		Race race6 = milliways.defineRace("Krikkiters");
		Race race7 = milliways.defineRace("Silastic Armourfiends of Striterax");

		// Add some random requirements
		for (Race r : new Race[] { race1, race2, race3, race4, race5 })
			r.addRequirement("Class M atmosphere (nitrogen-oxygen)");
		for (Race r : new Race[] { race6, race7 })
			r.addRequirement("Class X atmosphere (methane)");
		for (Race r : new Race[] { race1, race3, race5 })
			r.addRequirement("Low gravity (less than 2g)");

		race3.addRequirement("Soothing music");
		race5.addRequirement("Vegeterian meals");
		race7.addRequirement("Live food");
		
		race2.addRequirement("XXX");
		
		// Create party
		Party party1 = milliways.createParty();
		party1.addCompanions(race1, 1);
		party1.addCompanions(race2, 2);
		party1.addCompanions(race1, 2);
		System.out.println(party1);
		System.out.println(party1.getRequirements());
		System.out.println("");

	}
}
