/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Apr 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

package it.polito.oop.foo;

import java.util.Comparator;

public class ClassOne implements Comparable<ClassOne> {
	public int foo, bar, baz, gargle;
	
	public ClassOne(int foo, int bar, int baz, int gargle) {
		this.foo = foo;
		this.bar = bar;
		this.baz = baz;
		this.gargle = gargle;
	}

	
	
	@Override
	public int compareTo(ClassOne o) {
		return Integer.compare(this.gargle, o.gargle);
	}


	@Override
	public String toString() {
		return "ClassOne [foo=" + foo + ", bar=" + bar + ", baz=" + baz + ", gargle=" + gargle + "]";
	}



	public int getFoo() {
		return foo;
	}



	public int getBar() {
		return bar;
	}



	public int getBaz() {
		return baz;
	}



	public int getGargle() {
		return gargle;
	}


}
