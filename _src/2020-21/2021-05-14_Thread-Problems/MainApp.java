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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class MainApp {

	synchronized static int globalCounter;

	public static void main(String[] args) throws InterruptedException {
		Thread up = new Thread(() -> {
			for (int t = 0; t < 100000; ++t)
				++globalCounter;
		});
		Thread down = new Thread(() -> {
			for (int t = 0; t < 100000; ++t) {
				--globalCounter ;
			}
		});

		up.start();
		down.start();
		up.join();
		down.join();
		
		System.out.println(globalCounter);

	}
}
