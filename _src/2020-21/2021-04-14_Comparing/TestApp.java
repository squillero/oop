/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Apr 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import java.util.*;
import java.util.function.*;

import static java.util.Comparator.*;
import it.polito.oop.foo.ClassOne;

public final class TestApp {

	public static void main(String[] args) {
		ClassOne[] array = { new ClassOne(3, 2, 23, 23), new ClassOne(23, 1, 25, 10), new ClassOne(4, 99, 43, 18),
				new ClassOne(1, 23, 17, 5) };

		for (ClassOne c : array) {
			System.out.println(c);
		}
		System.out.println("");

		Arrays.sort(array);

		for (ClassOne c : array) {
			System.out.println(c);
		}
		System.out.println("");

		// "Explicit" unnamed class implementing an iface
		Arrays.sort(array, new Comparator<ClassOne>() {
			public int compare(ClassOne o1, ClassOne o2) {
				return Integer.compare(o1.foo, o2.foo);
			}
		});

		for (ClassOne c : array) {
			System.out.println(c);
		}
		System.out.println("");

		// lambda!
		Arrays.sort(array, (o1, o2) -> Integer.compare(o1.bar, o2.bar));

		for (ClassOne c : array) {
			System.out.println(c);
		}
		System.out.println("");

		// Factory w/ explicit
		// Arrays.sort(array, comparing(new Function<ClassOne, Integer>(){
		// public Integer apply(ClassOne o) {
		// return o.baz;
		// }
		// }));

		// Factory w/ lambda
		// Arrays.sort(array, comparing(o -> o.baz+o.bar/o.foo));

		// Factory w/ reference
		Arrays.sort(array, comparing(ClassOne::getBaz));

		for (ClassOne c : array) {
			System.out.println(c);
		}
		System.out.println("");

		// Composing 2
		Arrays.sort(array, comparing(ClassOne::getBaz).reversed());

		for (ClassOne c : array) {
			System.out.println(c);
		}
		System.out.println("");

	}

}
