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

import java.nio.file.FileSystemNotFoundException;

public class Rocket extends FlyingObject {
	private String name;
	private double fuel;

	public Rocket(String name, double speed) {
		super(speed);
		this.name = name;
		System.err.println("Default constructor for Rocket");
	}

	@Override
	public String toString() {
		return super.toString() + " (rocket \"" + name + "\")";
	}

	@Override
	public void setSpeed(double speed) {
		if (speed < 1) {
			System.err.println("Too slow!");
			System.exit(1);
		} else if (speed > 1000) {
			System.err.println("Too fast!");
			System.exit(1);
		} else {
			super.setSpeed(speed);
		}
	}

	@Override
	public void test() {
		System.out.println("Rocket's test");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + name.hashCode();
		result = prime * result + Double.hashCode(this.getSpeed());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Rocket))
			return false;
		Rocket other = (Rocket) obj; // the only safe downcast
		
		// the names & speed should be equal
		if (!name.equals(other.name)) {
			return false;
		} else if (this.getSpeed() != other.getSpeed()) {
			return false;
		}
		return true;
	}

	public double getFuel() {
		return fuel;
	}

	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	@Override
	public void fly(double miles) {
		System.out.println("Rocket is flying " + miles + " miles");
		
	}

}
