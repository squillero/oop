/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Apr 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import it.polito.oop.movie.*;

public class TestApp {

	public static void main(String[] args) throws MovieException {
		TestApp ta = new TestApp();
		// throw new Error("Kaboom!");
		// throw new RuntimeException("Kaboom!");

		try {
			System.out.println("One");
			System.out.println("Two");
			if(3 > 2)
				throw new Exception("Hey!?");
			System.out.println("Three");
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Final!");
		}
		
		
	}

	void addDirectors() throws MovieException {
		System.out.println("Adding Japanese Directors");
		addJapaneseDirectors();
		System.out.println("Adding again Japanese Directors");
		addJapaneseDirectors();
		System.out.println("Adding American Directors");
		addAmericanDirectors();
		System.out.println("Adding again American Directors");
		addAmericanDirectors();
	}

	void addItalianDirectors() throws MovieException {
		Staff staff = Staff.getInstance();

		staff.addDirector(new Director("Sergio Leone"));
	}

	void addJapaneseDirectors() {
		Staff staff = Staff.getInstance();

		try {
			staff.addDirector(new Director("Yasujirō Ozu"));
		} catch (MovieException me) {
			System.err.println("Yeuch! " + me.getMessage());
		}
	}

	void addAmericanDirectors() throws MovieException {
		Staff staff = Staff.getInstance();

		try {
			staff.addDirector(new Director("Stanley Kubrick"));
			staff.addDirector(null);
			staff.addDirector(new Director("David Lynch"));
		} catch (MovieDirectorException mde) {
			System.err.println("Yeuch! " + mde.getMessage());
		} catch (MovieDisasterException me) {
			throw new RuntimeException("PANIK!", me);
		}
	}
}
