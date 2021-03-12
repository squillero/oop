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
		Planet earth = new Planet("Earth", 149598023);
		Planet mars = new Planet("Mars", 227939200);	
		earth.describe();
		mars.describe();
		
		earth.set("Jdkfrjlkfd-Khvnm");
		earth.set(42E9);
		earth.describe();
	}

}
