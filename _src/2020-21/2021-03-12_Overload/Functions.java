/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

public class Functions {
	
	void foo(int i) {
		System.out.println("Integer: " + i);
	}

//	Error: same signature
//	int foo(int i) {
//		System.out.println("Integer: " + i);
//		return 42;
//	}

	String foo(int a, int b) {
		int sum = a + b;
		System.out.println("Two integers: " + sum);
		return "!";		// bad idea: they should have the same return type
	}

	void foo(String str) {
		System.out.println("String: \"" + str + "\"");
	}


}
