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

import it.polito.oop.wrapup.Banana;

public class TestApp {

	static void printList(String title, String... elements) {
		System.out.println(title);
		for(String e: elements) {
			System.out.println("* " + e);
		}
	}
	
	void crazyMethod() {
		int localVariable = 0;
		
		class LocalInnerClass {
			void zap() {
				System.out.println("Hello, I'm " + this + ": loc=" + localVariable);
			}
		}
		
		LocalInnerClass foo = new LocalInnerClass();
		LocalInnerClass bar = new LocalInnerClass();
		
		foo.zap();
		bar.zap();
		// ++localVariable; -- can't do it!
		foo.zap();
		bar.zap();
	}
	
	public static void main(String[] args) {
		//Banana.showBananaTypes();
		printList("TODO LIST", "Buy some bananas", "Keep practicing Java");
		
		String[] test = { "Hey", "Hoy" };
		printList("TEST", test);
		
		Banana myFirstBanana = new Banana(Banana.BananaType.CAVENDISH);		
		Banana mySecondBanana = new Banana(Banana.BananaType.PISANG);		
		System.out.println("Total number of bananas: " + Banana.Statistics.totalNumberBananas);
		System.out.println(myFirstBanana.getRipe());
		
		Banana.Riper rip0 = myFirstBanana.makeRiper();
		Banana.Riper rip1 = myFirstBanana.makeRiper();

		rip0.doRipe();
		System.out.println("1: " + myFirstBanana.getRipe());
		rip1.doRipe();
		System.out.println("1: " + myFirstBanana.getRipe());
		System.out.println("2: " + mySecondBanana.getRipe());
		
		TestApp tapp = new TestApp();
		tapp.crazyMethod();
		
	}
}
