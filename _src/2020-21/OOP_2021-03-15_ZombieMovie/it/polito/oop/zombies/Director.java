/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

package it.polito.oop.zombies;

public class Director {
	private String name;
	private int foo, bar, baz;
	
	public Director(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getFoo() {
		return foo;
	}

	public void setFoo(int foo) {
		this.foo = foo;
	}

	public int getBar() {
		return bar;
	}

	public void setBar(int bar) {
		this.bar = bar;
	}

	public int getBaz() {
		return baz;
	}

	public void setBaz(int baz) {
		this.baz = baz;
	}
	
	public void Test() {
		PrivateClass foo = new PrivateClass();
		
		foo.publicMethod();
		foo.method();
		
		PublicClass bar = new PublicClass();
		bar.publicMethod();
		bar.method();
		
	}
}
