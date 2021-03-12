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

public class ArrayExperiments {	
	public static void main(String[] args) {
		Integer[] array = new Integer[4];
		System.out.println(array);
		
		array[2] = 42;	// autoboxing!
		for(int i = 0; i < array.length; ++i)
			System.out.println(array[i]);
		
		System.out.println(array[999]);
	}
}
