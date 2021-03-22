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

public class Song {
	public enum Genres { 
			POP, ROCK, JAZZ, BLUES
	}

	public final static String VERSION = "0.1-beta";
	private static int numberSongs;
	

	private String title;
	private Author author;
	private int year;
	private Genres genre;

	Song() {
		// Package visibility
		numberSongs += 1;
	}

	public static void debug() {
		System.out.println("This is song v" + VERSION + " -- Created " + numberSongs + " songs");
	}
	
	public Song(String title, Author author, int year) {
		numberSongs += 1;

		this.title = title;
		this.author = author;
		this.year = year;
	}

	public Song(String title, Author author, int year, Genres genre) {
		numberSongs += 1;

		this.title = title;
		this.author = author;
		this.year = year;
		this.genre = genre;
	}
	
	public Genres getGenre() {
		return genre;
	}

	public void setGenre(Genres genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	void setAuthor(Author author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	void setYear(int year) {
		this.year = year;
	}

	public String toString() {
		if (title == null) {
			return "<UNDEF>";
		} else {
			return "\"" + this.title + "\" by " + this.author + " (" + this.year + ")";
		}
	}
}
