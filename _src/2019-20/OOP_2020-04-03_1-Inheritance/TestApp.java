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

public class TestApp {

	public static void main(String[] args) {
		Movie gone = new Movie();
		gone.setTitle("Gone with the wind");
		gone.describe();
		
		HorrorMovie oneCut = new HorrorMovie();
		oneCut.setTitle("カメラを止めるな!");		// One Cut of the Dead
		oneCut.setScaringLevel(0.0);
		oneCut.describe();
		
		// HorrorMovie cantDoIt = new Movie();	// can't do it
		// cantDoIt.setScaringLevel(1.0);		// correct (in theory)
		// Movie hm2 = new HorrorMovie();		// correct
		// hm2.setScaringLevel(0.0);			// can't do it
		
		ZombieApocalypseMovie wwz = new ZombieApocalypseMovie();
		wwz.setTitle("World War Z");
		wwz.setScaringLevel(.4);
		wwz.setBradPitt(true);

		ZombieApocalypseMovie days = new ZombieApocalypseMovie();
		days.setTitle("28 Days Later");
		days.setScaringLevel(.6);
		days.setBradPitt(false);
		
		JapaneseMovie tokyoStory = new JapaneseMovie();
		tokyoStory.setTitle("東京物語"); // Tokyo Story

		System.out.println("==[ LIBRARY ]========================");
		Movie[] library = {gone, oneCut, wwz, days, tokyoStory};
		for(Movie m: library) {
			m.describe();		// polymorphism
			System.out.println("");
		}
		
	}

}
