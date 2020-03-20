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

public class Main {

	public static void main(String[] args) {
		Dog dog = new Dog("Rex");
		dog.bark();
		dog.setName("Fluffy");	// correct
		dog.bark();
		// dog.name = "Fuffy";		// incorrect AND not allowed
		dog.bark();

		Dog dog2 = new Dog("Pluto");
		dog2.bark();
		
		String name = dog2.getName();
		System.out.println("The name of dog2 is " + name);
	}
}
