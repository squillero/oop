/*-************************************************************************-*\
*             *  CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)      *
*   #####     *  (!) May-2021, Giovanni Squillero <squillero@polito.it>      *
*  ######     *                                                              *
*  ###   \    *  Copying and distributing this file, either with or without  *
*   ##G  c\   *  modification, are permitted in any medium without royalty,  *
*   #     _\  *  provided that this 10-line comment is preserved.            *
*   |  _/     *                                                              *
*             *  ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <===  *
\*-************************************************************************-*/

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import it.polito.oop.thread.Counter;

public final class MainApp {

	public static void main(String[] args) throws InterruptedException {
		MainApp ma = new MainApp();
		ma.example2();
	}

	void example2() throws InterruptedException {
		ExecutorService manager = Executors.newFixedThreadPool(4);

		Thread alice = new Thread(new Counter(1000, "Alice"));
		alice.setPriority(Thread.MAX_PRIORITY);
		manager.submit(alice);

		Thread bob = new Thread(new Counter(1000, "Bob"));
		bob.setPriority(Thread.NORM_PRIORITY);
		manager.submit(bob);
		
		Thread carl = new Thread(new Counter(1000, "Carl"));
		carl.setPriority(Thread.MIN_PRIORITY);
		manager.submit(carl);

		
		manager.shutdown();
		manager.awaitTermination(1, TimeUnit.DAYS);
		System.out.println("That's all!");
	}

	void example3() throws InterruptedException {
		ExecutorService manager = Executors.newFixedThreadPool(2);
		List<Callable<Object>> jobs = new ArrayList<>();

		jobs.add(Executors.callable(new Counter(100, "Alice")));
		jobs.add(Executors.callable(new Counter(100, "Bob")));
		jobs.add(Executors.callable(new Counter(100, "Carl")));
		jobs.add(Executors.callable(new Counter(100, "Diana")));
		manager.invokeAll(jobs);
		System.out.println("That's all!");
	}

	void promise() throws InterruptedException {
		ExecutorService srv = Executors.newCachedThreadPool();
		Callable<Integer> function = () -> 42 / 0;
		Future<Integer> promise = srv.submit(function);

		int x;
		try {
			x = promise.get();
		} catch (ExecutionException e) {
			System.err.println("Yeuch: " + e);
			x = 0;
		}
		System.out.println(x);

	}

}
