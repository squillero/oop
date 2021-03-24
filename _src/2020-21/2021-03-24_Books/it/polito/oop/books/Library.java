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

public class Library {
	private static final int MAX_SHELF_SIZE = 50;
	
	private static class Shelf {
		Book[] book;
		Book.GENRES genre;
	}
	
	Shelf[] shelf;

	public Library() {
		Book.GENRES[] genres = Book.GENRES.values();

		shelf = new Shelf[genres.length];
		for(int i = 0; i < genres.length; ++i) {
			shelf[i] = new Shelf();
			shelf[i].book = new Book[MAX_SHELF_SIZE];
			shelf[i].genre = genres[i];
		}
	}
	
	public void addBook(Book book) {
		Shelf correctShelf;
	}
}
