/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Apr 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.polito.oop.jcf.Coffee;

public class TestApp {

	static final long ELEMENTS = 100000;

	public static void main(String[] args) {
		TestApp ta = new TestApp();

		// ta.queueTest();
		// ta.setTest();
		ta.sortedSetTest();
	}

	void sortedSetTest() {
		// SortedSet<Coffee> foo = new TreeSet<>(Comparator.comparing(o->o.getBrand() + "%#%" + o.getType()));
		SortedSet<Coffee> foo = new TreeSet<>(Comparator.comparing(Coffee::getBrand).thenComparing(Coffee::getType));

		foo.add(new Coffee("Robusta", "Lavazza"));
		foo.add(new Coffee("Arabica", "Lavazza"));
		foo.add(new Coffee("Robusta", "Illy"));
		foo.add(new Coffee("Arabica", "Illy"));

		for (Coffee x : foo) {
			System.out.println(x);
		}
	}

	void setTest() {
		Set<Coffee> yongxi;

		yongxi = new HashSet<>();

		Coffee c1a = new Coffee("Java");
		c1a.setBrand("Lavazza");
		c1a.setInternalValueUsedSometime(.8);
		yongxi.add(c1a);

		Coffee c1b = new Coffee("Java");
		c1b.setBrand("Lavazza");
		c1b.setInternalValueUsedSometime(.7);
		System.out.println(yongxi.contains(c1b));

		Coffee c1c = new Coffee("Java");
		c1c.setBrand("Lavazza");
		c1c.setInternalValueUsedSometime(.7);
		yongxi.add(c1c);

		Coffee c2 = new Coffee("Java");
		c2.setBrand("Illy");
		yongxi.add(c2);

		for (Coffee c : yongxi) {
			System.out.println(c);
		}

	}

	void queueTest() {
		Queue<String> beatles; // ie. you want to poll & peek

		System.out.println("\nFIFO!");
		beatles = new LinkedList<>(); // notez bien: ArrayList wouln't work
		beatles.add("John");
		beatles.add("Paul");
		beatles.add("George");
		beatles.add("Ringo");
		while (!beatles.isEmpty()) {
			System.out.println(beatles.poll());
		}
		System.out.println(beatles.poll()); // won't fail!

		System.out.println("\nPriority Queue!");
		beatles = new PriorityQueue<>();
		beatles.add("John");
		beatles.add("Paul");
		beatles.add("George");
		beatles.add("Ringo)");
		while (!beatles.isEmpty()) {
			System.out.println(beatles.poll());
		}

		System.out.println("\nPriority Queue with different comparison!");
		beatles = new PriorityQueue<>(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return Integer.compare(o1.hashCode(), o2.hashCode());
			}
		});
		beatles.add("John");
		beatles.add("Paul");
		beatles.add("George");
		beatles.add("Ringo");
		while (!beatles.isEmpty()) {
			String s = beatles.poll();
			System.out.println(s + " " + s.hashCode());
		}

		System.out.println("\nPriority Queue with different comparison!");
		// beatles = new PriorityQueue<>(Comparator.comparing(o -> o.length()));
		beatles = new PriorityQueue<>(Comparator.comparing(String::length).reversed());
		beatles.add("John");
		beatles.add("Paul");
		beatles.add("George");
		beatles.add("Ringo");
		for (String s : beatles) {
			System.out.println(s + " " + s.length());
		}

	}

	void foo() {
		LinkedList<String> test = new LinkedList<>();

		test.add("Foo");
		test.add("Bar");
		test.add("Baz");
		System.out.println(test.removeFirst());
	}

	void speedTest() {
		List<Integer> test;
		long start, end;
		long sum;

		System.out.println("Accessing " + ELEMENTS + " elements (last)");

		test = new LinkedList<>();
		for (long t = 0; t < 2 * ELEMENTS; ++t) {
			test.add(42);
		}
		start = System.nanoTime();
		sum = 0;
		for (long t = 0; t < ELEMENTS; ++t) {
			sum += test.get((int) ELEMENTS / 2);
		}
		end = System.nanoTime();
		System.out.println("LinkedList: " + (end - start) / 1000.0 + "μs");

		test = new ArrayList<>();
		for (long t = 0; t < 2 * ELEMENTS; ++t) {
			test.add(42);
		}
		start = System.nanoTime();
		sum = 0;
		for (long t = 0; t < ELEMENTS; ++t) {
			sum += test.get((int) ELEMENTS / 2);
		}
		end = System.nanoTime();
		System.out.println("ArrayList : " + (end - start) / 1000.0 + "μs");
	}

}
