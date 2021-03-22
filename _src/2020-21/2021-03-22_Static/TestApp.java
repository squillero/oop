/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import it.polito.oop.music.*;

public class TestApp {

	public static void main(String[] args) {
		System.out.println("Using Song v" + Song.VERSION);
		
		Song song1 = Directory.getInstance().addSong("Lemon Tree", "Fool's Garden", 1995);
		Song song2 = Directory.getInstance().addSong("Time of the Season", "The Zombies", 1968);
		Song song3 = Directory.getInstance().addSong("Take Five", "Dave Brubeck", 1959, Song.Genres.JAZZ);

		System.out.println(song3);
		
		Directory.getInstance().debug();
		//Example.run();

		// song.debug(); 	// not a good idea as we don't stress that it is static
		//Song.debug();
	}

}
