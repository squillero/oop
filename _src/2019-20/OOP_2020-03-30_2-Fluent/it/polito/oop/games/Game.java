/*-************************************************************************-*\
*             *  CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)      *
*   #####     *  (!) Mar-2020, Giovanni Squillero <squillero@polito.it>      *
*  ######     *                                                              *
*  ###   \    *  Copying and distributing this file, either with or without  *
*   ##G  c\   *  modification, are permitted in any medium without royalty,  *
*   #     _\  *  provided that this 10-line comment is preserved.            *
*   |  _/     *                                                              *
*             *  ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <===  *
\*-************************************************************************-*/

package it.polito.oop.games;

public class Game {
	public enum Type { NON_COOPERATIVE, COOPERATIVE }; 
	public enum Genre { STRATEGY, ROLEPLAY, SHOOTER }; 
	
	private String name;
	private Type type;
	private Genre genre;
	private int numMaxPlayer;
	
	private Game(String name) {
		this.name = name;
	}

	public static Game named(String name) {
		return new Game(name);
	}
	
	public Game ofType(Game.Type type) {
		this.type = type;
		return this;
	}
	
	public Game withMaxPlayers(int numMaxPlayer) {
		this.numMaxPlayer = numMaxPlayer;
		return this;
	}
	
	public void finalize() {
		System.out.println("Trashing game: " + this);
	}
}
