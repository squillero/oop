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

import static it.polito.oop.constants.CrazyConstants.*;
import it.polito.oop.constants.Singleton;

public class TestApp {

	private String foo;
	private String bar;
	static String baz;
	
	public static void main(String[] args) {
		// I can use STATIC methods & access STATIC attributes
		TestApp.baz = "Foo";
		TestApp.simpleStaticFunction();
		System.out.println("GARGLE is " + GARGLE);
		System.out.println("ZAP: " + ZAP);
		System.out.println("ZAP: " + ZAP);
		System.out.println("SINGLETON: " + Singleton.getInstance());
		
		// ... but I need an object to call NON-STATIC ones
		TestApp tapp = new TestApp();
		tapp.simpleFunction();
	}
	
	void simpleFunction() {
		System.out.println("Hello!? I'm a simple function...");
		System.out.println("SINGLETON: " + Singleton.getInstance());
	}

	static void simpleStaticFunction() {
		final int yeah;
		yeah = 13;
		System.out.println("Hello!? I'm simply a static function...");
		System.out.println("Yeah: " + yeah);
		System.out.println("SINGLETON: " + Singleton.getInstance());
	}

}
