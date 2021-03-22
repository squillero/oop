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

public class Directory {
	public final static int MAX_ELEMENTS = 1024;
	private static Directory root;

	private Author[] authors;
	private Song[] songs;

	private Directory() {
		System.out.println("Creating arrays...");
		authors = new Author[MAX_ELEMENTS];
		songs = new Song[MAX_ELEMENTS];
	}

	public static Directory getInstance() {
		if(Directory.root == null) {
			Directory.root = new Directory();
		}
		return Directory.root;
	}
	
	public Author addAuthor(String authorName) {
		int index = 0;
		while (root.authors[index] != null && !root.authors[index].getName().equals(authorName)) {
			index += 1;
		}
		if (root.authors[index] == null) {
			Author newAuthor = new Author(authorName);
			System.out.println("Adding new author: " + newAuthor);
			root.authors[index] = newAuthor;
		}
		return root.authors[index];
	}

	static private boolean sameSong(Song song, String songTitle, String authorName, int songYear) {
		// KISS
		if(song.getYear() != songYear)
			return false;
		if(!song.getTitle().equals(songTitle))
			return false;
		if(!song.getAuthor().getName().equals(authorName))
			return false;
		return true;
	}
	
	public Song addSong(String songTitle, String authorName, int songYear) {
		Author author = Directory.getInstance().addAuthor(authorName);
		int index = 0;
		
		while (root.songs[index] != null && !sameSong(root.songs[index], songTitle, authorName, songYear)) { 
			index += 1;
		}
		if (root.songs[index] == null) {
			Song newSong = new Song(songTitle, author, songYear);
			root.songs[index] = newSong;
			System.out.println("Adding new song: " + newSong);
		}
		return root.songs[index];
	}

	public Song addSong(String songTitle, String authorName, int songYear, Song.Genres genre) {
		Song song = addSong(songTitle, authorName, songYear);
		song.setGenre(genre);
		return song;
	}
	
	public static void debug() {
		System.out.println("# AUTHORS:");
		for(Author a: Directory.getInstance().authors) {
			if(a != null) {
				System.out.println("* " + a);
			}
		}

		System.out.println("\n# SONGS:");
		for(Song s: Directory.getInstance().songs) {
			if(s != null) {
				System.out.println("* " + s);
			}
		}
}
}
