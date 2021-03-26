/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import it.polito.oop.galaxy.GiantPlanet;
import it.polito.oop.galaxy.Planet;

public class TestApp {
	public static void main(String[] args) {		
		Planet normalPlanet = new Planet();
		normalPlanet.name = "Mars";
		GiantPlanet giantPlanet = new GiantPlanet();
		giantPlanet.name = "Saturn";
		giantPlanet.rings = 13;

		Planet[] planet = {normalPlanet, giantPlanet};
		for(Planet p: planet) {
			// Polymorphism
			p.describe();
		}

		GiantPlanet jupiter = new GiantPlanet();
		jupiter.name = "Jupiter";
		jupiter.rings = 3;
		Planet o = jupiter; 	// safe upcast
		o.describe();			// polymorphism / dynamic binding

		jupiter.sing();
		//o.sing();				// illegal (syntax)
		
		GiantPlanet gp;
		gp = (GiantPlanet)o;	// unsafe downcast must be explicit!
		gp.sing();		
		
		Planet x = new Planet();
		gp = (GiantPlanet)x;	// unsafe downcast must be explicit!
		gp.sing();		
	}
}
