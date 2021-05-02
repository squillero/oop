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

public interface Vaccine {
	double getEfficacy();
	double getCost();
	int getNumberOfDoses();
	int getIntervalBetweenDoses();

	default double totalCost() {
		return getCost() * getNumberOfDoses();
	}

	static String describe(Vaccine v) {
		return "cost:" + v.getCost() + "*" 
				+ v.getNumberOfDoses() + "; efficacy: " + v.getEfficacy();
	}
}
