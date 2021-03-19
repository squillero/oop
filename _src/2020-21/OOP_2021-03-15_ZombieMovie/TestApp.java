/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import it.polito.oop.zombies.Movie;

public class TestApp {

	public static void main(String[] args) {
		Movie m0 = new Movie("Night of the Living Dead", 1968, "George Romero");
		m0.watch();
		
		Movie m1;
		m1 = new Movie();
		m1.watch();
		m1 = null;
		// System.gc();		-- don't do it!
		
		Movie m2 = new Movie("Pride and Prejudice and Zombies", 2014, "Burr Steers");
		m2.watch();
		
		Movie alias = m2;
		alias.move();
		
		Movie m3 = new Movie("World War Z", 2013, "Marc Forster");
		m2.move(15);
		// m3.runningZombies = true;  -- nooooo: "info hiding" rules
		m3.setRunningZombies(true);
		m3.move(15);
		
		// Director has not been imported, I need to fully qualify it
		it.polito.oop.zombies.Director bob;
		bob = new it.polito.oop.zombies.Director("Dan O'Bannon");		
		
		it.polito.oop.zombies.PublicClass pc;
		pc = new it.polito.oop.zombies.PublicClass();
		pc.publicMethod();
	}
}
