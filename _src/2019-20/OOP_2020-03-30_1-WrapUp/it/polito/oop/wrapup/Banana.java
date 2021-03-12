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

package it.polito.oop.wrapup;

public class Banana {
	public enum BananaType { APPLE, CAVENDISH, LADYS_FINGER, PISANG, RED };
	
	public static class Statistics {
		public static int totalNumberBananas = 0;
	}
	
	public class Riper {
		public void doRipe() {
			ripe += 1;
		}
	}
	
	private BananaType type;
	private int ripe = 0;
	
	public Banana(BananaType type) {
		this.type = type;
		Banana.Statistics.totalNumberBananas += 1;
	}
	
	public Riper makeRiper() {
		return new Riper();
	}

	public BananaType getType() {
		return type;
	}
	
	public static void showBananaTypes() {
		System.out.println("Known bana types:");
		for(BananaType b: Banana.BananaType.values()) {
			System.out.println("* " + b);
		}
	}

	public int getRipe() {
		return ripe;
	}
	
}
