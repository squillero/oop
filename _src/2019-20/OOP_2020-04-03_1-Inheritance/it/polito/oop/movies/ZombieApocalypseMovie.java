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

package it.polito.oop.movies;

public class ZombieApocalypseMovie extends HorrorMovie {
	private boolean bradPitt = false;

	public boolean isBradPitt() {
		return bradPitt;
	}

	public void setBradPitt(boolean bradPitt) {
		this.bradPitt = bradPitt;
	}

	@Override
	public void describe() {
		System.out.println("A zombie-apocalyptic horror movie. Title: \"" + this.getTitle() + "\"");
		if(this.getScaringLevel() == 0.0) {
			System.out.println("Not scaring at all");
		} else if(this.getScaringLevel() < 0.5) {
			System.out.println("Not so scaring");
		} else {
			System.out.println("Really scaring");
		}
		if(bradPitt) 
			System.out.println("With Brad Pitt!");
		else
			System.out.println("Without Brad Pitt!");
	}

}
