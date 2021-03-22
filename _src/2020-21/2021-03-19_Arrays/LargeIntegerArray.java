/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

public class LargeIntegerArray {
	private int[] array;
	
	public LargeIntegerArray() {
		array = new int[100];
	}
	
	public int get(int index) {
		if(index < array.length)
			return array[index];
		else
			return 0;
	}

	public void set(int index, int value) {
		if(array.length <= index) {
			int[] array2 = new int[index+1];
			for(int i = 0; i < array.length; ++i) {
				array2[i] = array[i];
			}
			array = array2;
		}
		array[index] = value;
	}
}
