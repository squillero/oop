/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import it.polito.oop.fly.*;

public class MyOwnTestApp {

	public static void main(String[] args) {
		Rocket r1 = new Rocket("Saturn V", 900);
		Rocket r2 = new Rocket("Saturn V", 900);
		Airplane a = new Airplane();
		
		Directory.getInstance().addFlyingObject(r1);
		System.out.println(Directory.getInstance().isPresent(r2));
		
		a.trip(100);
		r1.trip(100);
	}
}
