package it.polito.po.test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import rentacar.*;


public class TestR4R5 {
    private Agency ag;

    @Before
    public void setUp() throws AgencyException {
    	ag = new Agency();
        
        ag.definePoints(10.0, 15.0, 20.0, 25.0, 30.0, 35.0, 40.0);
        
        ag.addCar("Fiat", "Tipo", 2015, "automatic", "grey", 'C', 5);//id 0
		ag.addCar("Fiat", "500", 2016, "manual", "grey", 'A', 4);//id 1
		ag.addCar("Alfa Romeo", "Giulietta", 2019, "automatic", "red", 'D', 5);// id 2
		ag.addVan("Volkswagen", "Transporter", 2016, "automatic", "black", 'F', 8, 4250); //id 3
		ag.addVan("Volkswagen", "California", 2017, "manual", "while", 'F', 7, 7750);// id 4
		ag.addCar("BMW", "X5", 2018, "automtic", "blue", 'E', 5);//id 5
		ag.addCar("Alfa Romeo", "Stelvio", 2017, "manual", "grey", 'E', 5);//id 6
		ag.addCar("Fiat", "Panda", 2015, "manual", "red", 'B', 4);// id 7
		ag.addCar("Fiat", "Panda", 2015, "manual", "red", 'B', 4);// id 8
		ag.addCar("Lancia", "Ypsilon", 2016, "manual", "grey", 'A', 4);//id 1
		
		ag.registerUser("Ac Ba", "Turin");
		ag.registerUser("Km Op", "Berlin");
		ag.registerUser("Ab Nn", "Rome");
		ag.registerUser("Tr Ss", "London");
		ag.registerUser("Sc Er", "Rome");
		ag.registerUser("Km Op", "London");
		ag.registerUser("Ij Fg", "London");
		
		ag.makeReservation(1, 'A', 4, 5);
    	ag.makeReservation(2, 'C', 5, 3);
    	ag.makeReservation(3, 'E', 4, 7);
    	ag.makeReservation(2, 'B', 4, 14);
    	ag.makeReservation(4, 'D', 5, 8);
    	ag.makeReservation(1, 'E', 5, 4);
    	ag.makeReservation(3, 'A', 4, 2);
    }

    @Test 
    public void testPointsUser() {
    	Map<Double, List<String>> sm = ag.getUsersPerPoints();
    	assertNotNull(sm);
    	assertEquals("[40.0, 35.0, 25.0]", sm.keySet().toString());
    	assertTrue(sm.get(40.0).containsAll(Arrays.asList("Km Op", "Tr Ss")));
    	assertEquals(2, sm.get(40.0).size());
    	assertEquals("[Ab Nn]", sm.get(35.0).toString());
    	assertEquals("[Sc Er]", sm.get(25.0).toString());
    }
    
    @Test
    public void testEvaluateUsers() {
    	Map<String, Double> sm = ag.evaluateUsers();
    	assertNotNull(sm);
    	assertEquals("{2: Ab Nn=8.5, 4: Sc Er=8.0, 1: Km Op=4.5, 3: Tr Ss=4.5, 0: Ac Ba=0.0, 6: Ij Fg=0.0, 5: Km Op=0.0}", sm.toString());
    }

    
    @Test 
    public void testCarInfoYears() {
    	Map<Integer, List<String>> sm = ag.getCarInfoForYears();
    	
    	assertNotNull(sm);
    	assertEquals("[2019, 2018, 2017, 2016, 2015]", sm.keySet().toString());
    	assertEquals(
    			"[Alfa Romeo:Giulietta:red]", 
    			sm.get(2019).toString());
    	assertEquals(1, sm.get(2019).size());
    	
    	assertEquals(
    			"[BMW:X5:blue]", 
    			sm.get(2018).toString());
    	assertEquals(1, sm.get(2018).size());
    	
    	assertTrue(sm.get(2017).containsAll(Arrays.asList("Alfa Romeo:Stelvio:grey", "Volkswagen:California:while")));
    	assertEquals(2, sm.get(2017).size());
    	assertTrue(sm.get(2016).containsAll(Arrays.asList("Fiat:500:grey", "Lancia:Ypsilon:grey", "Volkswagen:Transporter:black")));
    	assertEquals(3, sm.get(2016).size());
    	assertTrue(sm.get(2015).containsAll(Arrays.asList("Fiat:Tipo:grey", "Fiat:Panda:red")));
    	assertEquals(3, sm.get(2015).size());
    	

    	
    }
    
    @Test 
    public void testCategoriesForVehicleNumber() {
    	Map<Long, List<String>> sm = ag.getCategoriesForVehicleNumber();
    	assertNotNull(sm);
    	assertEquals("{0=[G], 1=[C, D], 2=[A, B, E, F]}", sm.toString());
    }
    
    
}
