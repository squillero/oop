package it.polito.po.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import rentacar.*;

public class TestR3 {
    Agency ag;
    List<String> ls = null;

    @Before
    public void setUp() throws AgencyException {
        ag = new Agency();
        
        ag.definePoints(10.0, 15.0, 20.0, 25.0, 30.0, 35.0, 40.0);//ABCDEFG
        
        ag.addCar("Fiat", "Tipo", 2015, "automatic", "grey", 'C', 5);//id 0
		ag.addCar("Fiat", "500", 2016, "manual", "grey", 'A', 4);//id 1
		ag.addCar("Alfa Romeo", "Giulietta", 2019, "automatic", "red", 'D', 5);// id 2
		ag.addVan("Volkswagen", "Transporter", 2016, "automatic", "black", 'F', 8, 4250); //id 3
		ag.addVan("Volkswagen", "California", 2017, "manual", "while", 'F', 7, 7750);// id 4
		ag.addCar("BMW", "X5", 2018, "automtic", "blue", 'E', 5);//id 5
		ag.addCar("Alfa Romeo", "Stelvio", 2017, "manual", "grey", 'E', 5);//id 6
		ag.addCar("Fiat", "Panda", 2015, "manual", "red", 'B', 4);// id 7
		ag.addCar("Fiat", "Panda", 2015, "manual", "red", 'B', 4);// id 8
		
		ag.registerUser("Ac Ba", "Turin");
		ag.registerUser("Km Op", "Berlin");
		ag.registerUser("Ab Nn", "Rome");
		ag.registerUser("Tr Ss", "London");
		ag.registerUser("Sc Er", "Rome");
		ag.registerUser("Km Op", "London");
		ag.registerUser("Ij Fg", "London");
    }

    @Test(expected=AgencyException.class)
    public void testMakeReservationsNonExistingCategory() throws AgencyException {
    	ag.makeReservation(0, 'H', 4, 5);
    }
    
    @Test
    public void testMakeReservations2() throws AgencyException {
    	int v_id = ag.makeReservation(0, 'B', 4, 5);
    	assertEquals(7, v_id);
    	v_id = ag.makeReservation(1, 'A', 4, 5);
    	assertEquals(1, v_id);
    	v_id = ag.makeReservation(2, 'C', 5, 3);
    	assertEquals(0, v_id);
    	v_id = ag.makeReservation(3, 'E', 4, 2);
    	assertEquals(5, v_id);
    	v_id = ag.makeReservation(2, 'B', 4, 14);
    	assertEquals(8, v_id);
    	v_id = ag.makeReservation(1, 'D', 5, 4);
    	assertEquals(2, v_id);
    	
    }
    
    
    @Test(expected=AgencyException.class)
    public void testMakeReservationsNonExistentUser() throws AgencyException {
    	ag.makeReservation(10, 'G', 4, 5);
    }
    
    @Test
    public void testMakeReservations() throws AgencyException {
    	int v_id = ag.makeReservation(0, 'G', 4, 5);
    	assertEquals(Agency.NO_VEHICLE, v_id);
    }
    
    @Test
    public void testEmptyListTakenCars() throws AgencyException {
    	
    	ag.makeReservation(1, 'A', 4, 5);
    	ag.makeReservation(2, 'C', 5, 3);
    	ag.makeReservation(3, 'E', 4, 2);
    	ag.makeReservation(2, 'B', 4, 14);
    	ag.makeReservation(1, 'D', 5, 4);
    	
    	ls = ag.getUserNamesForTakenCars('F');
    	assertEquals("[]", ls.toString());
    }
    
    @Test
    public void testListTakenCars() throws AgencyException {
    	ag.makeReservation(1, 'A', 4, 5);
    	ag.makeReservation(2, 'C', 5, 3);
    	ag.makeReservation(3, 'E', 4, 2);
    	ag.makeReservation(2, 'B', 4, 14);
    	ag.makeReservation(1, 'E', 5, 4);
    	
    	ls = ag.getUserNamesForTakenCars('E');
    	assertNotNull(ls);
    	assertEquals("[Km Op, Tr Ss]", ls.toString());
    }
    
    @Test
    public void testAvailableVehicles() throws AgencyException {
    	ls = ag.getAvailableVehicles(5);
    	assertNotNull(ls);
    	assertEquals("[  0 C:Fiat:Tipo,   2 D:Alfa Romeo:Giulietta,   5 E:BMW:X5,   6 E:Alfa Romeo:Stelvio,   3 F:Volkswagen:Transporter,   4 F:Volkswagen:California]", ls.toString());
    }
    
    @Test
    public void testEmptyListAvailableVehicles() throws AgencyException {
    	ls = ag.getAvailableVehicles(10);
    	assertNotNull(ls);
    	assertEquals("[]", ls.toString());
    }
}
