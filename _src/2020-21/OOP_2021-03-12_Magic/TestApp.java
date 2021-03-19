/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

public class TestApp {

	public static void main(String[] args) {
		Spell s1 = new Spell();
		Spell s2 = new Spell();

		s1.name = "Charme";
		s2.name = "Fireball";

		s1.cast();
		s2.cast();
		
		Spell ref;
		ref = s1;	
		ref.name = "Magic hand";	// that is, change s1
		ref = s2;
		ref.name = "Magic hand";	// that is, change s2
		s1.cast();
		s2.cast();
		
		System.out.println("Spell " + s1.name + " has been casted " + s1.castCount + " times");
		System.out.println("Spell " + s2.name + " has been casted " + s2.castCount + " times");
	}

}
