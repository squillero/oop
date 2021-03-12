/*-************************************************************************-*\
*             *  CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)      *
*   #####     *  (!) Mar-2020, Giovanni Squillero <squillero@polito.it>      *
*  ######     *                                                              *
*  ###   \    *  Copying and distributing this file, either with or without  *
*   ##G  c\   *  modification, are permitted in any medium without royalty,  *
*   #     _\  *  provided that this 10-line comment is preserved.            *
*   |  _/     *                                                              *
*             *  ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <===  *
\*-************************************************************************-*/

import it.polito.oop.space.Planet;

public class Test01 {

	static void describePlanet(Planet p) {
		System.out.println(p.getName() + ": " + p.getHabitableZone());
	}
	
	public static void main(String[] args) {
		Planet earth = new Planet("Earth");
		Planet mars = new Planet("Mars", 75348.0, 2131342, 'M');
		
		describePlanet(earth);
		describePlanet(mars);
	}

}
