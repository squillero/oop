package example;


import static org.junit.Assert.*;

import org.junit.Test;

import rentacar.Agency;
import rentacar.AgencyException;

public class TestApp {
	
	@Test
	public void test() throws AgencyException {
		//R1
		Agency a = new Agency();
		try {
			a.definePoints(5, 12, 10);
			fail("Did not detect points not increasing"); 
		} catch (Exception ex) {}// expected 
		a.definePoints(5, 12, 14, 18, 20, 24);
		
		a.addCar("Fiat", "Tipo", 2015, "automatic", "grey", 'E', 5);
		a.addCar("Fiat", "500", 2016, "manual", "grey", 'A', 4);
		a.addVan("Volkswagen", "Transporter", 2016, "automatic", "black", 'F', 8, 4250);
		a.addCar("BMW", "X5", 2018, "automtic", "blue", 'E', 5);
		a.addCar("Fiat", "Panda", 2015, "manual", "red", 'B', 4);

		System.out.println(a.getAvailableVehicles(2));
		System.out.println(a.getAvailableVehicles(4));
		System.out.println(a.getAvailableVehicles(5));
		System.out.println(a.getAvailableVehicles(1000));
		
		//R2
		int u1 = a.registerUser("P Maxwell", "Turin");
		int u2 = a.registerUser("J Brahms", "Berlin");
		int u3 = a.registerUser("A Turing", "Rome");
		
		assertEquals(3, a.countUsers());
		
		System.out.println(a.getUserInfo());
		System.out.println(a.getUserInfo().keySet());
		assertEquals("[Berlin, Rome, Turin]", a.getUserInfo().keySet().toString());
		
		//R3
		try {
			a.makeReservation(u1, 'J', 13, 5);
			fail("Category does not exist"); 
		} catch (Exception e) {}// expected
		
		int vi = a.makeReservation(u1, 'A', 7, 10);
		assertEquals(Agency.NO_VEHICLE, vi);;
		vi = a.makeReservation(u1, 'A', 4, 2);
		assertEquals(1, vi);
		a.makeReservation(u2, 'E', 5, 7);
		vi = a.makeReservation(u3, 'A', 5, 3);
		assertEquals(Agency.NO_VEHICLE,vi);
		
		assertEquals("[P Maxwell]", a.getUserNamesForTakenCars('A').toString());
		System.out.println(a.getAvailableVehicles(8));
		assertEquals("[  2 F:Volkswagen:Transporter]", a.getAvailableVehicles(8).toString());

		//R4	
		System.out.println(a.getUsersPerPoints().get(20.0).toString());
		assertEquals("[J Brahms]", a.getUsersPerPoints().get(20.0).toString());
		
		assertEquals("{1: J Brahms=7.0, 0: P Maxwell=2.0, 2: A Turing=0.0}", a.evaluateUsers().toString());
		
		//R5
		assertEquals("[BMW:X5:blue]", a.getCarInfoForYears().get(2018).toString());
		
		assertEquals("{0=[C, D], 1=[A, B, F], 2=[E]}", a.getCategoriesForVehicleNumber().toString()); 
		
		
	}
}
