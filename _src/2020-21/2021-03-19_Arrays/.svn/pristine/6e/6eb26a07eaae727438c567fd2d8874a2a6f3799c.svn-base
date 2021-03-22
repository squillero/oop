/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

public class Example {

	public static void main(String[] args) {
		int[] array;
		
		array = new int[12];
		for(int t = 0; t < array.length; ++t) {
			array[t] = t * 2 + 1;
		}
		
		System.out.println(array);
		for(int element: array) {		// the NEW for
			System.out.print(element + " ");
		}
		System.out.println();	
		
		LargeIntegerArray baz = new LargeIntegerArray();
		System.out.println(baz.get(1000));	
		baz.set(1000, 42);
		System.out.println(baz.get(1000));	
		System.out.println(baz.get(2000));	
	}
}
