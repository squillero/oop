package it.polito.po.test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import rentacar.*;

public class TestR2 {
    Agency ag;
    List<String> ls = null;

    @Before
    public void setUp() throws AgencyException {
        ag = new Agency();
        ls = null;
        ag.definePoints(10.0, 15.0, 20.0, 25.0, 30.0, 35.0);
        
        ag.addCar("Fiat", "Tipo", 2015, "automatic", "grey", 'E', 5);//id 0
		ag.addCar("Fiat", "500", 2016, "manual", "grey", 'A', 4);//id 1
		ag.addCar("Alfa Romeo", "Giulietta", 2019, "automatic", "red", 'D', 5);// id 2
		ag.addVan("Volkswagen", "Transporter", 2016, "automatic", "black", 'F', 8, 4250); //id 3
		ag.addVan("Volkswagen", "California", 2017, "manual", "while", 'F', 7, 7750);// id 4
		ag.addCar("BMW", "X5", 2018, "automtic", "blue", 'E', 5);//id 5
		ag.addCar("Alfa Romeo", "Stelvio", 2017, "manual", "grey", 'E', 5);//id 6
		ag.addCar("Fiat", "Panda", 2015, "manual", "red", 'B', 4);// id 7
		ag.addCar("Fiat", "Panda", 2015, "manual", "red", 'B', 4);// id 8
    }
    
    

    @Test
    public void testAddUsers() throws AgencyException {

		int u1 = ag.registerUser("Ac Ba", "Turin");
		int u2 = ag.registerUser("Km Op", "Berlin");
		ag.registerUser("Ab Nn", "Rome");
		ag.registerUser("Tr Ss", "London");
		int u5 = ag.registerUser("Sc Er", "Rome");
		int u6 = ag.registerUser("Ij Fg", "London");
		assertEquals(u1, 0);
		assertEquals(u2, 1);
		assertEquals(u5, 4);
		assertEquals(u6, 5);
		
		assertEquals(6,  ag.countUsers());
    }

    @Test(expected=AgencyException.class)
    public void testGroupDuplicateNameCity() throws AgencyException {
    	ag.registerUser("Ac Ba", "Turin");
		ag.registerUser("Km Op", "Berlin");
		ag.registerUser("Sc Er", "Rome");
		ag.registerUser("Ac Ba", "Turin");
    }
    
    @Test
    public void testGroupDuplicateName() throws AgencyException {
    	int u1 = ag.registerUser("Ac Ba", "Turin");
    	ag.registerUser("Km Op", "Berlin");
    	ag.registerUser("Sc Er", "Rome");
    	int u4 = ag.registerUser("Ac Ba", "London");
    	assertEquals(0, u1);
    	assertEquals(3, u4);
    	assertEquals(4,  ag.countUsers());
    }

    @Test
    public void testUserInfo() throws AgencyException {
    	ag.registerUser("Ac Ba", "Turin");
		ag.registerUser("Km Op", "Berlin");
		ag.registerUser("Ab Nn", "Rome");
		ag.registerUser("Tr Ss", "London");
		ag.registerUser("Sc Er", "Rome");
		ag.registerUser("Ij Fg", "London");
		
		Map<String, List<String>> ui = ag.getUserInfo();
		assertNotNull(ui);
		assertEquals("{Berlin=[Km Op], London=[Tr Ss, Ij Fg], Rome=[Sc Er, Ab Nn], Turin=[Ac Ba]}", ui.toString());
    }
}
