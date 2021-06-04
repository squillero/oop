package it.polito.po.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import travelPortal.*;

public class TestR3 {

	TravelPortal tp = null;
	List<String> ls = null;
	int j = 0;
	SortedMap<String, List<String>> mapSLS = null;
    @Before
    public void setUp() { //Context: activity types, travel agencies, proposals, activities
        tp = new TravelPortal();
        ls = null;
        j = 0;
        mapSLS = null;
        tp.addActivityTypes ("Park visit", "Museum visit", "Theatre show");
	    try {
	    	j = tp.AddTravelAgency ("ag3", "Museum visit", "Theatre show");
	    	j = tp.AddTravelAgency ("ag2", "Museum visit", "Theatre show");
	    	j = tp.AddTravelAgency ("ag1", "Museum visit", "Park visit");
	    	tp.addProposal ("pr3", "ag3", "Paris", "9:12-20", 2, 4, 1400);
	    	tp.addProposal ("pr1", "ag1", "Rome", "9:12-16", 4, 6, 800); 
	    	j = tp.addActivity ("pr1", "Museum visit", "descr1", 20);
	    	j = tp.addActivity ("pr1", "Park visit", "descr2", 40);
	    } catch(TPException ex) {System.out.println(ex.getMessage()); fail("no exception expected");}
    }
    
    @Test
    public void addParticipants1 () {
    	try {
    		ls = tp.addParticipants ("pr1", "pt3", "pt1", "pt2", "pt4");
    		assertEquals(ls.toString(), "[pt3, pt1, pt2, pt4]");
    	} catch(TPException ex) {fail("no exception expected");}
    }
    
    @Test (expected=TPException.class)
    public void addParticipants2 () throws TPException {
    	tp.addParticipants ("pr1", "pt3", "pt1", "pt2");
    }
    
    @Test (expected=TPException.class)
    public void addParticipants3 () throws TPException {
    	tp.addParticipants ("pr1", "pt3", "pt1", "pt2", "pt4", "pt8", "pt7", "pt9");
    }
    
    @Test
    public void addParticipants4 () { //pt discarded
    	try {
    		ls = tp.addParticipants ("pr1", "pt3", "pt1", "pt2", "pt4");
    		ls = tp.addParticipants ("pr3", "pt8", "pt1", "pt2", "pt9");
    		assertEquals(ls.toString(), "[pt8, pt9]");
    	} catch(TPException ex) {fail("no exception expected");}
    }
    
    @Test (expected=TPException.class)
    public void addParticipants5 () throws TPException { //pt discarded, too few participants
    	try {
    		ls = tp.addParticipants ("pr1", "pt3", "pt1", "pt2", "pt4");
    	} catch(TPException ex) {fail("no exception expected");}
    	ls = tp.addParticipants ("pr3", "pt8", "pt1", "pt2");
     }
    
    @Test
    public void getIncome1 () {
    	try {
    		ls = tp.addParticipants ("pr1", "pt3", "pt1", "pt2", "pt4");
    		j = tp.getIncome ("pr1");
    		assertEquals(j, 3440);
    	} catch(TPException ex) {fail("no exception expected");}
    }
        
    @Test
    public void getIncome2 () {
    	try {
    		ls = tp.addParticipants ("pr1", "pt3", "pt1", "pt2", "pt4");
    		ls = tp.addParticipants ("pr3", "pt8", "pt1", "pt2", "pt9");
    		j = tp.getIncome ("pr3");
    		assertEquals(j, 2800);
    	} catch(TPException ex) {fail("no exception expected");}
    }

}
