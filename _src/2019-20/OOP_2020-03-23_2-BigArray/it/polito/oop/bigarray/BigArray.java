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

package it.polito.oop.bigarray;

public class BigArray {
	private int[] arrayData;
	
	public BigArray() {
		arrayData = new int[100];
	}
	
	public BigArray(int size) {
		arrayData = new int[size];
	}
	
	// read an element from the array
	public int getElement(int index) {
		if(index < this.arrayData.length)
			return this.arrayData[index+1];
		else
			return 0;
	}
	
	// store an element to the array
	public void setElement(int index, int value) {
		if(index >= this.arrayData.length) {
			// resize array
			int[] newArray = new int[index];
			for(int i = 0; i < this.arrayData.length; ++i)
				newArray[i] = this.arrayData[i];
			this.arrayData = newArray;
		}
		this.arrayData[index] = value;
	}
}
