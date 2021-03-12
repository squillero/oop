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

import it.oop.polito.arrays.DummyClass;

public class TestApp {

	public static void main(String[] args) {
		DummyClass[][] array = new DummyClass[10][];
		
		for(int i = 0; i < array.length; ++i)
			array[i] = new DummyClass[1+i*10];
		
		array[5][42] = new DummyClass(0, 0);	// line ok
		array[6][52] = new DummyClass(0, 0);	// line ok
		array[5][52] = new DummyClass(0, 0);	// line NOT ok
		
	}

}
