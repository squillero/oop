/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) May 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import it.polito.oop.threads.*;

public final class MainApp {

	public static void main(String[] args) throws InterruptedException {
		Worker b = new Worker();
		synchronized (b) {
			b.start();
			try {
				System.out.println("Waiting for b to complete");
				b.wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Total is: " + b.total);
	}

}
