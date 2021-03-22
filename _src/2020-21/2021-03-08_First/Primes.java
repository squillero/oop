/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) Mar 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/


public class Primes {

	public static void main(String[] args) {
		System.out.print("Prime numbers:");
		for(int n = 2; n < 1000; ++n) {
			boolean prime = true;
			for(int t = 2; t < n; ++t) {
				if(n % t == 0) {
					prime = false;
				}
			}
			if(prime) {
				System.out.print(" ");
				System.out.print(n);
			}	
		}
	}

}
