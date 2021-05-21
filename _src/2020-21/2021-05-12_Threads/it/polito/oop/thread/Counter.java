/*-************************************************************************-*\
*             *  CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)      *
*   #####     *  (!) May-2021, Giovanni Squillero <squillero@polito.it>      *
*  ######     *                                                              *
*  ###   \    *  Copying and distributing this file, either with or without  *
*   ##G  c\   *  modification, are permitted in any medium without royalty,  *
*   #     _\  *  provided that this 10-line comment is preserved.            *
*   |  _/     *                                                              *
*             *  ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <===  *
\*-************************************************************************-*/

package it.polito.oop.thread;

public class Counter implements Runnable {

	private int number;
	private String name;
		
	public Counter(int number, String name) {
		this.number = number;
		this.name = name;
	}

	@Override
	public void run() {
		for(int t = number; t > 0; --t) {
			System.out.println(name + ": " + t);
		}
		System.out.println(name + " BOOM");
	}

}
