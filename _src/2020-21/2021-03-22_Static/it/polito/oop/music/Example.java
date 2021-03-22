/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

package it.polito.oop.music;

public class Example {
	public static void run() {
		Song song = new Song();
		System.out.println(song);

		Author a = new Author("The Zombies");
		song.setAuthor(a);
		song.setTitle("Time of the Season");
		song.setYear(1968);
		System.out.println(song);
	}
	
	public static void test(int a, final int b) {
		a += 1;
		System.out.println(a);
		
		// b += 1;	// incorrect: b is final
	}
}
