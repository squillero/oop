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

import it.polito.oop.bigarray.BigArray;

public class TestApplication {

	public static void main(String[] args) {
		BigArray ba = new BigArray(50);
		
		ba.setElement(23, 10);
		ba.setElement(10, 23);
		
		System.out.println("10: " + ba.getElement(10));
		System.out.println("18: " + ba.getElement(18));
		System.out.println("23: " + ba.getElement(23));

		ba.setElement(1800, 500);

		System.out.println("1000: " + ba.getElement(1000));
		System.out.println("1800: " + ba.getElement(1800));
		System.out.println("2300: " + ba.getElement(2300));
		System.out.println("10: " + ba.getElement(10));
		System.out.println("18: " + ba.getElement(18));
		System.out.println("23: " + ba.getElement(23));
	}

}
