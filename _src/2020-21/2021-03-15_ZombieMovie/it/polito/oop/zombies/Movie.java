/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

package it.polito.oop.zombies;

public class Movie {
	private String title;
	private int year;
	// private String director;
	Director director;
	private boolean runningZombies = false;

	public Movie() {
		// THE standard zombie movie
		year = -1;
		title = "**ERROR**";
	}

	public String getDirector() {
		return director.getName();
	}

	public void setDirector(String director) {
		this.director = new Director(director);
	}

	public Movie(String title, int year, String director) {
		// custom zombie movie
		this.title = title;
		this.year = year;
		this.director = new Director(director);	
	}

	public Movie(String title, int year, String director, boolean runningZombies) {
		// custom zombie movie with explicit runningZombies
		this.title = title;
		this.year = year;
		this.director = new Director(director);
		this.runningZombies = runningZombies;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year < 1888 || year > 2030) {
			System.err.println("Yeuch!?");
		} else {
			this.year = year;
		}
	}

	public void watch() {
		if(year < 0) {
			System.out.println("Can't see a non-existing movie!");
		} else {
			System.out.println("I'm watching \"" + title + "\" (" + year + ") by " + director.getName());
		}
	}
	
	public void move() {
		move(3);
	}

	public void move(int speed) {
		if(speed <= 6) {
			System.out.println("Zombies in \"" + title + "\" are walking at " + speed + " km/h");
		} else if(speed <= 15 && runningZombies) {
			System.out.println("Zombies in \"" + title + "\" are running at " + speed + " km/h");
		} else {
			System.out.println("Yeuch: Zombies in \"" + title + "\" can't move so fast!");
		}
	}
	
	public void finalize() {
		System.out.println("Disposing " + this);
	}
	
	public void setRunningZombies(boolean runningZombies) {
		this.runningZombies = runningZombies;	
	}
	
	public boolean getRunningZombies() {
		return this.runningZombies;
	}
}
