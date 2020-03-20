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

package it.polito.oop.space;

public class Planet {
	private String name;
	private double mass;
	private double radius;
	private char planetaryClass = '?';
	// private boolean habitableZone; (useless)

	// constructors
	public Planet(String name) {
		this.name = name;
	}

	public Planet(String name, double mass, double radius, char planetaryClass) {
		this.name = name;
		this.mass = mass;
		this.radius = radius;
		this.planetaryClass = planetaryClass;
	}
	
	// getters n' setters
	public String getName() {
		return name;
	}
	
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public char getPlanetaryClass() {
		return planetaryClass;
	}
	public void setPlanetaryClass(char planetaryClass) {
		this.planetaryClass = planetaryClass;
	}
	
	public boolean getHabitableZone() {
		if(planetaryClass == 'M' && radius > 0.0 && mass > 0.0) {
			return true;
		} else {
			return false;
		}
	}
}
