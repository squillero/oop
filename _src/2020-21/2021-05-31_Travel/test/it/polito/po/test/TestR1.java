package it.polito.po.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.SortedMap;

import org.junit.Before;
import org.junit.Test;

import travelPortal.*;

public class TestR1 {
	TravelPortal tp = null;
	List<String> ls = null;
	int j = 0;
	SortedMap<String, List<String>> mapSLS = null;
    @Before
    public void setUp() {
        tp = new TravelPortal();
        ls = null;
        j = 0;
        mapSLS = null;
    }

    @Test
    public void addActivityTypes () {
    	ls = tp.addActivityTypes ("Park visit", "Museum visit", "Theatre show");
    	assertNotNull(ls);
    	assertEquals(ls.toString(), "[Museum visit, Park visit, Theatre show]");
    }
    
    @Test
    public void AddTravelAgency1 () throws TPException {
    	tp.addActivityTypes ("Park visit", "Museum visit", "Theatre show");
	    try {
	    	j = tp.AddTravelAgency ("ag3", "Museum visit", "Theatre show");
		    assertEquals(j, 2);
	    } catch(TPException ex) {fail("no exception expected");}
    }
    @Test
    public void AddTravelAgency2 () throws TPException {
    	tp.addActivityTypes ("Park visit", "Museum visit", "Theatre show");
	    try {
	    	j = tp.AddTravelAgency ("ag3", "Museum visit", "Theatre show");
		    assertEquals(j, 2);
	    } catch(TPException ex) {fail("no exception expected");}
	    try {
	    	j = tp.AddTravelAgency ("ag3", "Park visit");
	    	fail("dup travel agency");
	    } catch(TPException ex) {} //ok
    }
    @Test(expected=TPException.class)
    public void AddTravelAgency3 () throws TPException {
    	tp.addActivityTypes ("Park visit", "Museum visit", "Theatre show");
    	tp.AddTravelAgency ("ag3", "Football match");
    }
    @Test
    public void getAgenciesForActivityTypes1 () {
    	tp.addActivityTypes ("Park visit", "Museum visit", "Theatre show");
	    try {
	    	j = tp.AddTravelAgency ("ag3", "Museum visit", "Theatre show");
	    	j = tp.AddTravelAgency ("ag2", "Museum visit", "Theatre show");
	    	j = tp.AddTravelAgency ("ag1", "Museum visit", "Park visit");
	    } catch(TPException ex) {fail("no exception expected");}
    	mapSLS = tp.getAgenciesForActivityTypes();
    	//System.out.println(mapSLS);
	    assertEquals(mapSLS.toString(), 
	    "{Museum visit=[ag1, ag2, ag3], Park visit=[ag1], Theatre show=[ag2, ag3]}");
    }
    @Test
    public void getAgenciesForActivityTypes2 () {
    	tp.addActivityTypes ("Park visit", "Museum visit", "Theatre show", "Football match");
	    try {
	    	j = tp.AddTravelAgency ("ag3", "Museum visit", "Theatre show");
	    	j = tp.AddTravelAgency ("ag2", "Museum visit", "Theatre show");
	    	j = tp.AddTravelAgency ("ag1", "Museum visit", "Park visit");
	    } catch(TPException ex) {fail("no exception expected");}
    	mapSLS = tp.getAgenciesForActivityTypes();
    	//System.out.println(mapSLS);
	    assertEquals(mapSLS.toString(), 
	    "{Museum visit=[ag1, ag2, ag3], Park visit=[ag1], Theatre show=[ag2, ag3]}");
    }
}
