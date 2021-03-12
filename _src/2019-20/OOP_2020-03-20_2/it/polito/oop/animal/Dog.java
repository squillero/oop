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

package it.polito.oop.animal;

public class Dog {
	private String name;
	private Collar collar;

	public Dog(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private void privateBark() {
		System.out.println(name + " is barking (privately)");
	}
	
	void bark() {
		System.out.println(name + " is barking!");
	}
	
	public void publicMethod() {
		this.bark();
		if(this.collar != null) {
			System.out.println("Wearing a " + this.collar.getColor() + " collar");
		}
}
	
	public void buyCollar(String color) {
		this.collar = new Collar(color);
	}
}
