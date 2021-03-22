/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import it.polito.oop.paintings.*;

public class TestApplication {

	public static void main(String[] args) {
		Period preRaphaelite = new Period("Pre-Raphaelite Brotherhood", 1848, 1854);
		Painter millais = new Painter("John Everett Millais", 1829, 1896);
		
		System.out.println(preRaphaelite);
		System.out.println(millais);

		Painter cattelan = new Painter("Maurizio Cattelan", 1960, -1);
		System.out.println(cattelan);
		
		Painting ophelia = new Painting("Ophelia", 1851);
		ophelia.setAuthor(millais);
		ophelia.setPeriod(preRaphaelite);
		ophelia.setMedium("oil on canvas");
		System.out.println(ophelia);
	}

}
