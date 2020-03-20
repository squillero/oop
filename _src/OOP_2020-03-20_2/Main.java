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

import it.polito.oop.animal.Dog;
import it.polito.oop.animal.Cat;

// import it.polito.oop.animal.Collar; -- can't do it!

public class Main {

	public static void main(String[] args) {
		Dog dog = new Dog("Doggy");
		dog.publicMethod();
		dog.buyCollar("blue");
		dog.publicMethod();
				
		// Collar collar = new Collar("gold"); -- can't do it
		
		Cat cat = new Cat("Kitty");
		cat.publicMethod();
		cat.cook();
		cat.publicMethod();
		
	}

}
