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

public class HorrorMovie extends Movie {
	private double scaringLevel = 0.5;

	public double getScaringLevel() {
		return scaringLevel;
	}

	public void setScaringLevel(double scaringLevel) {
		this.scaringLevel = scaringLevel;
	}

	@Override
	public void describe() {
		System.out.println("A horror movie. Title: \"" + this.getTitle() + "\"");
		if(scaringLevel == 0.0) {
			System.out.println("Not scaring at all");
		} else if(scaringLevel < 0.5) {
			System.out.println("Not so scaring");
		} else {
			System.out.println("Really scaring");
		}
	}


}
