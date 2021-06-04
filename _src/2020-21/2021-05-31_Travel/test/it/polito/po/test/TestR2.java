package it.polito.po.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import travelPortal.*;

public class TestR2 {

	TravelPortal tp = null;
	List<String> ls = null;
	int j = 0;
	SortedMap<String, List<String>> mapSLS = null;
    @Before
    public void setUp() { //Context: activity types, travel agencies
        tp = new TravelPortal();
        ls = null;
        j = 0;
        mapSLS = null;
        tp.addActivityTypes ("Park visit", "Museum visit", "Theatre show");
	    try {
	    	j = tp.AddTravelAgency ("ag3", "Museum visit", "Theatre show");
	    	j = tp.AddTravelAgency ("ag2", "Museum visit", "Theatre show");
	    	j = tp.AddTravelAgency ("ag1", "Museum visit", "Park visit");
	    } catch(TPException ex) {fail("no exception expected");}
    }
    
    @Test
    public void addProposal1 () throws TPException {
    	try {
        	j = tp.addProposal ("pr1", "ag3", "Paris", "9:12-20", 4, 6, 1400);
        	assertEquals(j, 8);
	    } catch(TPException ex) {fail("no exception expected");}
    }
    
    @Test (expected=TPException.class)
    public void addProposal2 () throws TPException {
    	tp.addProposal ("pr1", "ag3", "Paris", "9:12-20", 3, 6, 1500);
    	tp.addProposal ("pr1", "ag3", "Paris", "9:12-20", 3, 6, 1500); //code dup
    }
    
    @Test (expected=TPException.class)
    public void addProposal3 () throws TPException {
    	tp.addProposal ("pr1", "ag4", "Paris", "9:12-20", 3, 6, 1500); //undef agency
    }
    

    
    @Test
    public void addActivity1 () throws TPException {
    	try {
        	j = tp.addProposal ("pr1", "ag3", "Paris", "9:12-20", 4, 6, 1400);
        	assertEquals(j, 8);
	    } catch(TPException ex) {fail("no exception expected");}
	    try {
	    	j = tp.addActivity ("pr1", "Museum visit", "descr1", 15);
		    assertEquals(j, 15);
	    } catch(TPException ex) {fail("no exception expected");}
    }
    
    @Test (expected=TPException.class)
    public void addActivity2 () throws TPException {
    	try {
        	j = tp.addProposal ("pr1", "ag1", "Paris", "9:12-20", 4, 6, 1400);
        	assertEquals(j, 8);
	    } catch(TPException ex) {fail("no exception expected");}
	    j = tp.addActivity ("pr1", "Theatre show", "descr1", 15); //mismatch activity type - agency
    }   
    
    @Test
    public void addActivity3 () throws TPException {
    	try {
        	j = tp.addProposal ("pr1", "ag3", "Paris", "9:12-20", 4, 6, 1400);
        	assertEquals(j, 8);
	    } catch(TPException ex) {fail("no exception expected");}
	    try {
	    	j = tp.addActivity ("pr1", "Museum visit", "descr1", 15);
	    	j = tp.addActivity ("pr1", "Theatre show", "descr2", 40);
		    assertEquals(j, 55);
	    } catch(TPException ex) {fail("no exception expected");}
    }
    
    @Test
    public void getProposalPrice1 () throws TPException {
    	try {
        	j = tp.addProposal ("pr1", "ag3", "Paris", "9:12-20", 4, 6, 1400);
 	    } catch(TPException ex) {fail("no exception expected");}
	    try {
	    	j = tp.getProposalPrice ("pr1");
		    assertEquals(j, 1400);
	    } catch(TPException ex) {fail("no exception expected");}
    }
    
    @Test
    public void getProposalPrice2 () throws TPException {
    	try {
        	j = tp.addProposal ("pr1", "ag3", "Paris", "9:12-20", 4, 6, 1400);
	    	j = tp.addActivity ("pr1", "Museum visit", "descr1", 15);
	    	j = tp.addActivity ("pr1", "Theatre show", "descr2", 35);
 	    } catch(TPException ex) {fail("no exception expected");}
	    try {
	    	j = tp.getProposalPrice ("pr1");
		    assertEquals(j, 1450);
	    } catch(TPException ex) {fail("no exception expected");}
    }
 
    @Test (expected=TPException.class)
    public void getProposalPrice3 () throws TPException {
    	try {
        	j = tp.addProposal ("pr1", "ag3", "Paris", "9:12-20", 4, 6, 1400);
 	    } catch(TPException ex) {fail("no exception expected");}
	    j = tp.getProposalPrice ("pr5");
    }
    
}
