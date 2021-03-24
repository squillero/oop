/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

package it.polito.oop.books;

public class Book {
	public static final int MAX_CHAPTERS = 100;
	public enum GENRES {NON_FICTION, FANTASY, THRILLER, SCIFI, COMIC}
	
	// STATIC NESTED CLASS
	public static class Cover {
		public enum TYPE {SOFT, HARD}
		public String color;
		public TYPE type;
	}
	
	// NON-STATIC NESTED CLASS (YOU CAN USE "this")
	public class Chapter {
		public int num;
		public String text;
		
		public String toString() {
			return "Chapter " + num + " of \"" + title + "\"";
			
		}
	}
	
	private String title;
	private String author;
	private GENRES genre;
	private Chapter[] chapter;
	private int numChapters = 0;
	
	Book() {
		chapter = new Chapter[MAX_CHAPTERS];
	}

	public Book(String title, String author, GENRES genre) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.chapter = new Chapter[MAX_CHAPTERS];
	}

	public Chapter addChapter(String text) {
		chapter[numChapters] = new Chapter();
		chapter[numChapters].text = text;
		chapter[numChapters].num = numChapters+1;
		++numChapters;
		return chapter[numChapters-1];
	}
	
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public GENRES getGenre() {
		return genre;
	}

	void setTitle(String title) {
		this.title = title;
	}

	void setAuthor(String author) {
		this.author = author;
	}

	void setGenre(GENRES genre) {
		this.genre = genre;
	}
}
