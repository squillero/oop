/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

package it.polito.oop.vaccines;

abstract public class AdenovirusVaccine implements Vaccine {
	private String technology;

	private double efficacy;
	private double cost;
	private int numberOfDoses;
	private int intervalBetweenDoses;
	
	public AdenovirusVaccine(String technology, double efficacy, double cost, int numberOfDoses,
			int intervalBetweenDoses) {
		this.technology = technology;
		this.efficacy = efficacy;
		this.cost = cost;
		this.numberOfDoses = numberOfDoses;
		this.intervalBetweenDoses = intervalBetweenDoses;
	}

	public String getTechnology() {
		return technology;
	}

	@Override
	public double getEfficacy() {
		return efficacy;
	}

	@Override
	public double getCost() {
		return cost;
	}

	@Override
	public int getNumberOfDoses() {
		return numberOfDoses;
	}

	@Override
	public int getIntervalBetweenDoses() {
		return intervalBetweenDoses;
	}
	
	@Override
	public String toString() {
		return "Adenovirus Vaccine (" + technology + ") " + Vaccine.describe(this);
	}
}
