/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Apr 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import javax.print.attribute.standard.PrinterLocation;

import it.oop.polito.hero.ExtraterrestrialHero;
import it.oop.polito.hero.Hero;
import it.oop.polito.hero.HeroDirectory;
import it.oop.polito.hero.Heroes;

public final class TestApp {

	public static void main(String[] args) {
		TestApp tap = new TestApp();
		
		HeroDirectory directory = HeroDirectory.getInstance(); 

		ExtraterrestrialHero superman = Heroes.addExtraterrestrialHero("Superman", "Kripton");
		ExtraterrestrialHero thor = Heroes.addExtraterrestrialHero("Thor", "Asgard");
		Hero batman = Heroes.addHero("Batman");
		
		directory.listHeroes();
		
		Set<ExtraterrestrialHero> leagueOfOOP = new HashSet<>();
		leagueOfOOP.add(superman);
		leagueOfOOP.add(thor);
		tap.printLeague(leagueOfOOP);
		
		Set<Hero> league2 = new HashSet<>(leagueOfOOP);
		league2.add(batman);
		tap.printLeague(league2);
		
		Set<Consumer<Hero>> gargle = new HashSet<>();
		gargle.add(superman);
		gargle.add(thor);
		tap.worksWith(Heroes.addHero("Iron Man"), gargle);
	}

	void worksWith(Hero hero, Set<Consumer<Hero>> team) {
		System.out.println("");
		for(Consumer<Hero> h: team)
			h.accept(hero);
	}
	
	void printLeague(Set<? extends Hero> league) {
		System.out.println("");
		for(Hero h: league) {
			System.out.println(">>>>" + h);
		}
	}
	
	void stringTest() {
		String s1 = "Foo";
		String s2 = "Foo";
		String s3 = new String("Foo");
		
		System.out.println(s1.equals(s2) + " -- " + (s1==s2));
		System.out.println(s1.equals(s3) + " -- " + (s1==s3));
		
		StringBuffer sb = new StringBuffer("ooF");
		sb.reverse();
		String s4 = sb.toString();
		System.out.println(s1.equals(s4) + " -- " + (s1==s4));		
	}
	
}
