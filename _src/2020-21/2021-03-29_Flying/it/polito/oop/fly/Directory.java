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

public final class Directory {
	public static final int MAX_FLYING_OBJECT = 1024;
	
	private FlyingObject[] flyingObject;
	private int numFlyingObject;
	static private Directory root;
	
	private Directory() {
		flyingObject = new FlyingObject[MAX_FLYING_OBJECT];
		numFlyingObject = 0;
	}
	
	public void addFlyingObject(FlyingObject object) {
		this.flyingObject[numFlyingObject++] = object;
	}
	
	static public Directory getInstance() {
		if(root == null)
			root = new Directory();
		return root;
	}
	
	public boolean isPresent(FlyingObject fo) {
		for(int t = 0; t < numFlyingObject; ++t) 
			if(fo.equals(flyingObject[t]))
				return true;
		return false;
	}
}
