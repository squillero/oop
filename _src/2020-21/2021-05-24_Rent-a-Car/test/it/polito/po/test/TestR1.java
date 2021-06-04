package it.polito.po.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import rentacar.*;

public class TestR1 {
    Agency ag;

    @Before
    public void setUp() {
        ag = new Agency();
    }

    @Test
    public void testPointsOfLevel1() throws AgencyException{
        ag.definePoints(10, 20, 30);
        assertTrue(ag.getPointsOfCategory('A')>0);
    }
    
    @Test(expected=AgencyException.class)
    public void testPointsOfLevel2() throws AgencyException {
        ag.definePoints(10, 20, 30);
        ag.getPointsOfCategory('D');
    }

    @Test
    public void testPointsOfLastCategory() throws AgencyException {
        ag.definePoints(10.2, 15.74, 32.5);
        assertEquals("Wrong number of points", 32.5, ag.getPointsOfCategory('C'), 0.0);
    }
   
    @Test(expected=AgencyException.class)
    public void testaddPointsForCategories2() throws AgencyException {
        ag.definePoints(10, 20, 15);
    }
    
    @Test
    public void addCars() throws AgencyException {
    	ag.definePoints(10, 14.5, 23, 31, 45.1, 50);
    	
    	int v1 = ag.addCar("Fiat", "Tipo", 2015, "automatic", "grey", 'E', 5);
		ag.addCar("Fiat", "500", 2016, "manual", "grey", 'A', 4);
		ag.addCar("Alfa Romeo", "Giulietta", 2019, "automatic", "red", 'D', 5);
		int v2 = ag.addVan("Volkswagen", "Transporter", 2016, "automatic", "black", 'F', 8, 4250);
		int v3 = ag.addVan("Volkswagen", "California", 2017, "manual", "while", 'F', 7, 7750);
		int v4 = ag.addCar("BMW", "X5", 2018, "automtic", "blue", 'E', 5);
		ag.addCar("Alfa Romeo", "Stelvio", 2017, "manual", "grey", 'E', 5);
		int v5 = ag.addCar("Fiat", "Panda", 2015, "manual", "red", 'B', 4);
		
		assertEquals(0, v1);
		assertEquals(3, v2);
		assertEquals(4, v3);
		assertEquals(5, v4);
		assertEquals(7, v5);
    }
    
    @Test(expected=AgencyException.class)
    public void testAddCarsUnknownCategory() throws AgencyException {
    	ag.definePoints(10, 14.5, 23, 31);
    	ag.addCar("Mercedes-Benz", "C220", 2019, "automatic", "red", 'E', 4);
    }
    
    @Test
    public void testVehiclesOfAGivenManufacturer1() throws AgencyException {
        List<String> ls = null;
        ag.definePoints(10,15,20,25,30,35);
        ag.addCar("Fiat", "Tipo", 2015, "automatic", "grey", 'E', 5);//id 0
		ag.addCar("Fiat", "500", 2016, "manual", "grey", 'A', 4);//id 1
		ag.addCar("Alfa Romeo", "Giulietta", 2019, "automatic", "red", 'D', 5);// id 2
		ag.addVan("Volkswagen", "Transporter", 2016, "automatic", "black", 'F', 8, 4250); //id 3
		ag.addVan("Volkswagen", "California", 2017, "manual", "while", 'F', 7, 7750);// id 4
		ag.addCar("BMW", "X5", 2018, "automtic", "blue", 'E', 5);//id 5
		ag.addCar("Alfa Romeo", "Stelvio", 2017, "manual", "grey", 'E', 5);//id 6
		ag.addCar("Fiat", "Panda", 2015, "manual", "red", 'B', 4);// id 7
		ag.addCar("Fiat", "Panda", 2015, "manual", "red", 'B', 4);// id 8
        
        ls = ag.getVehiclesOfAManufacturer("Fiat");
        assertNotNull(ls);
        assertEquals ("[Tipo:2015:grey, 500:2016:grey, Panda:2015:red, Panda:2015:red]", ls.toString());
        
        ls = ag.getVehiclesOfAManufacturer("Volkswagen");
        assertNotNull(ls);
        assertEquals ("[Transporter:2016:black, California:2017:while]", ls.toString());
        
        ls = ag.getVehiclesOfAManufacturer("Alfa Romeo");
        assertNotNull(ls);
        assertEquals ("[Giulietta:2019:red, Stelvio:2017:grey]", ls.toString());
        
        ls = ag.getVehiclesOfAManufacturer("BMW");
        assertNotNull(ls);
        assertEquals ("[X5:2018:blue]", ls.toString());
    }
    
    @Test
    public void testVehiclesOfAGivenManufacturer2() throws AgencyException {
        List<String> ls = null;
        ag.definePoints(10,15,20,25,30);
        ag.addCar("Fiat", "Tipo", 2015, "automatic", "grey", 'E', 5);//id 0
		ag.addCar("Fiat", "500", 2016, "manual", "grey", 'A', 4);//id 1
		ag.addCar("Alfa Romeo", "Giulietta", 2019, "automatic", "red", 'D', 5);// id 2
		ag.addVan("Fiat", "Multipla", 2015, "manual", "red", 'B', 6, 1000);// id 3
        
        ls = ag.getVehiclesOfAManufacturer("Renault");
        assertEquals ("[]", ls.toString());
    }
}
