/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

package it.polito.oop.fly;

public abstract class FlyingObject {
	private double speed;

	public FlyingObject(double speed) {
		System.err.println("Default constructor for Flying Object");
		this.speed =speed;  
	}
	
	public abstract void fly(double miles);
	
	public void trip(double miles) {
		// core algorithm
		System.out.println("Go");
		fly(miles);
		System.out.println("... and return");
		fly(-miles);
	}
	
	public void setSpeed(double speed) {
		this.speed =speed;  
	}

	public void test() {
		System.out.println("FlyingObject's test");
	}	

	@Override
	public String toString() {
		return "Flying object";
	}

	protected double getSpeed() {
		return speed;
	}
}
