/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) May 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;
//import java.util.stream.Collectors;
import java.util.Comparator;

public final class Main {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("gargle", "foobar", "alice", "bob", "jack", "jane", "mortimer", "giovanni",
				"adolfo", "pio", "pietro", "foo", "bar", "baz", "whirl", "foo", "baz");

		System.out.println(words.stream().collect(groupingBy(String::length)));
		System.out.println(
				words.stream().collect(groupingBy(String::length, () -> new TreeMap<>(reverseOrder()), toList())));
		System.out.println(words.stream().distinct()
				.collect(collectingAndThen(groupingBy(String::length, () -> new TreeMap<>(reverseOrder()), toList()),
						m -> m.entrySet().stream().limit(3).flatMap(e -> e.getValue().stream()).collect(toList()))));
		
		System.out.println(words.stream().distinct().sorted(Comparator.comparing(String::length).reversed()).limit(3).collect(toList()));
	}

}
