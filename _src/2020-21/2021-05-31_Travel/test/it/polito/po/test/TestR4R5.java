package it.polito.po.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import travelPortal.*;

public class TestR4R5 {
		TravelPortal tp = null;
		List<String> ls = null;
		int j = 0;
		String string = null;
		SortedMap<String, List<String>> mapSLS = null;
	    @Before
	    
	    public void setUp() { //Context: activity types, travel agencies, proposals, activities, participants
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
		    	tp.addProposal ("pr4", "ag1", "Berlin", "4:2-10", 3, 5, 800); 
		    	j = tp.addActivity ("pr1", "Museum visit", "descr1", 20);
		    	j = tp.addActivity ("pr1", "Park visit", "descr2", 40);
		    	j = tp.addActivity ("pr3", "Museum visit", "descr3", 30);
	    		ls = tp.addParticipants ("pr1", "pt3", "pt1", "pt2", "pt4");
	    		ls = tp.addParticipants ("pr3", "pt8", "pt1", "pt2", "pt9");
	    		ls = tp.addParticipants ("pr4", "pt8", "pt1", "pt2");
	    } catch(TPException ex) {System.out.println(ex.getMessage()); fail("no exception expected");}
	    }
	
    @Test
    public void addRatings1 () throws TPException {
    	try {
        	string = tp.addRatings ("pr1", 2, 4, 6, 8);
        	assertEquals(string, "pt3:2, pt1:4, pt2:6, pt4:8");
 	    } catch(TPException ex) {fail("no exception expected");}
    }
	
    @Test(expected=TPException.class)
    public void addRatings2 () throws TPException {
    	tp.addRatings ("pr1", 2, 4, 6, 8, 10);
     }
    
    @Test
    public void addRatings3 () throws TPException {
    	try {
        	string = tp.addRatings ("pr3", 2, 8);
        	assertEquals(string, "pt8:2, pt9:8");
 	    } catch(TPException ex) {fail("no exception expected");}
    }
	
    @Test(expected=TPException.class)
    public void addRatings4 () throws TPException {
    	tp.addRatings ("pr3", 2, 4, 6);
     }

    @Test
    public void getTotalRatingsForParticipants () throws TPException {
       	try {
       		string = tp.addRatings ("pr1", 2, 4, 6, 8);
       		//System.out.println(string); pt3:2, pt1:4, pt2:6, pt4:8
        	string = tp.addRatings ("pr3", 2, 8);
        	//System.out.println(string); pt8:2, pt9:8
        	string = tp.addRatings ("pr4", 2, 5, 7);
        	//System.out.println(string); pt8:2, pt1:5, pt2:7
	    } catch(TPException ex) {fail("no exception expected");}
    	SortedMap<String, Integer> mapSI = tp.getTotalRatingsForParticipants ();
    	assertNotNull(mapSI);
    	//System.out.println (mapSI); {pt1=9, pt2=13, pt3=2, pt4=8, pt8=4, pt9=8}
    	assertEquals(mapSI.toString(), "{pt1=9, pt2=13, pt3=2, pt4=8, pt8=4, pt9=8}");
    }
    
    
    @Test
    public void incomeForActivityTypes1 () {
	    SortedMap<String, Integer> mapSI2 = tp.incomeForActivityTypes();
	    //System.out.println (mapSI2);
	    assertEquals(mapSI2.toString(), "{Museum visit=50, Park visit=40}");
    }
    
    @Test
    public void incomeForActivityTypes2 () {
	    SortedMap<String, Integer> mapSI2 = tp.incomeForActivityTypes();
	    //System.out.println (mapSI2);
	    assertEquals(mapSI2.keySet().size(), 2);
    }
    
    @Test
    public void participantsWithSameNofProposals1 () {
	    SortedMap<Integer, List<String>> mapILS = tp.participantsWithSameNofProposals ();
	    //System.out.println (mapILS);
	    assertEquals(mapILS.toString(), "{1=[pt3, pt4, pt9], 2=[pt1, pt2, pt8]}");
    }
    
    @Test
    public void participantsWithSameNofProposals2 () {
	    SortedMap<Integer, List<String>> mapILS = tp.participantsWithSameNofProposals ();
	    assertEquals(mapILS.keySet().size(), 2);
    }
}
