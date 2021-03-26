/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

package it.polito.oop.galaxy;

public class GiantPlanet extends Planet {
	public int rings;
	
	public void describe() {
		System.out.println("Giant planet " + name + " with " + rings + " rings");
	}
	
	public void sing() {
		System.out.println("Giant planet " + name + " starts to sing");
		for(int t = 0; t < rings; ++t) {
			System.out.println("Obtjh dljfdf gkldfg ldkf");
		}
	}
	
}
