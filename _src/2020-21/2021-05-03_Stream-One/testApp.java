/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) May 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class testApp {

	public static void main(String[] args) {
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
		List<String> l3 = new ArrayList<>();
		List<Integer> lx = new ArrayList<>();
		

		l1.add("John");
		l1.add("Paul");
		l1.add("George");
		l1.add("Ringo");

		l2.add("Mick");
		l2.add("Keith");
		l2.add("Charlie");
		l2.add("Ronnie");
		
		l3.add("Carl");
		l3.add("Dennis");
		l3.add("David");
		l3.add("Rickie");
		l3.add("Blondie");

		lx.add(42);
		
		Stream.of(l1, l2, l3, lx).flatMap(List::stream).map(Object::toString).sorted().forEach(System.out::println);
		
		
		
	}
	
	void oldExample() {
		// Stream.generate(() ->
		// Math.random()).limit(10).sorted().forEach(System.out::println);
		// Stream.of("John", "Paul", "Geroge", "Ringo").filter((x) -> x.equals("Stu")).forEach(System.out::println);

		Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);

		Stream.generate(() -> Math.random())
			.limit(10)
			.map((n) -> "I said: " + n)
			.forEach(System.out::println);

		Stream.of("John", "Paul", "Geroge", "Ringo").map(String::length).forEach(System.out::println);
	}

}
