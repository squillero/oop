/*-************************************************************************-*\
*             *  CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)      *
*   #####     *  (!) Apr-2020, Giovanni Squillero <squillero@polito.it>      *
*  ######     *                                                              *
*  ###   \    *  Copying and distributing this file, either with or without  *
*   ##G  c\   *  modification, are permitted in any medium without royalty,  *
*   #     _\  *  provided that this 10-line comment is preserved.            *
*   |  _/     *                                                              *
*             *  ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <===  *
\*-************************************************************************-*/

import it.polito.oop.movies.Movie;
import it.polito.oop.movies.HorrorMovie;
import it.polito.oop.movies.ZombieApocalypseMovie;
import it.polito.oop.movies.JapaneseMovie;

public class TestApp2 {

	public static void main(String[] args) {
		System.out.println("Test App 2!");

		ZombieApocalypseMovie zam = new ZombieApocalypseMovie();
		zam.setTitle("Dawn of the Dead");
		zam.setBradPitt(false);
		zam.setScaringLevel(-1);
		zam.describe();
		
		HorrorMovie h;
		h = zam;
		h.describe();
		
		ZombieApocalypseMovie temp = (ZombieApocalypseMovie)h;
		temp.setBradPitt(true);
		System.out.println("--------");
		h.describe();
		
		
		JapaneseMovie j = new JapaneseMovie();
		Movie genericMovie = j;
		HorrorMovie horror = (HorrorMovie)genericMovie;	// run-time error!
		//HorrorMovie horror2 = (HorrorMovie)j;			// compile-time error!
		horror.describe();
	}

}
