package example;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;
import travelPortal.*;

public class TestApp {
    @Test
    public void test() throws TPException {
        TravelPortal tp = new TravelPortal();
        List<String> ls = null;
        SortedMap<String, List<String>> map = null;
        int j = 0;
        String string = null;
        //R1
        ls = tp.addActivityTypes ("park visit", "museum visit", "theatre show");
        assertEquals("[museum visit, park visit, theatre show]", ls.toString());

        j = tp.AddTravelAgency ("ag3", "museum visit", "theatre show");
        assertEquals(2, j);
        try {
            j = tp.AddTravelAgency ("ag3", "museum visit", "theatre show");
            fail("dup travel agency");
        } catch(TPException ex) {} //ok

        j = tp.AddTravelAgency ("ag1", "museum visit", "park visit");
        assertEquals(2, j);

        map = tp.getAgenciesForActivityTypes();
        assertEquals("{museum visit=[ag1, ag3], park visit=[ag1], theatre show=[ag3]}",
                map.toString());
        //R2
        j = tp.addProposal ("pr1", "ag3", "Paris", "8:10-20", 3, 6, 1500);
        assertEquals(10, j);

        j = tp.addActivity ("pr1", "museum visit", "descr1", 20);
        assertEquals(20, j);

        j = tp.addActivity ("pr1", "theatre show", "descr2", 40);
        assertEquals(60, j);

        try {
            j = tp.addActivity ("pr1", "park visit", "descr3", 10);
            fail("activity not supported");
        } catch(TPException ex) {} //ok

        j = tp.getProposalPrice ("pr1");
        assertEquals(1560, j);

        j = tp.addProposal ("pr4", "ag3", "London", "8:10-15", 3, 6, 1300);
        assertEquals(5, j);

        j = tp.addProposal ("pr5", "ag1", "Berlin", "8:15-22", 3, 6, 1600);
        assertEquals(7, j);

        j = tp.addProposal ("pr6", "ag1", "Dublin", "8:1-7", 3, 6, 1000);
        assertEquals(6, j);

        //R3
        ls = tp.addParticipants ("pr1", "pt2", "pt4", "pt6", "pt8");
        //all requestors accepted
        assertEquals("[pt2, pt4, pt6, pt8]", ls.toString());

        try {
            ls = tp.addParticipants ("pr4", "pt4", "pt2", "pt6", "pt8", "pt7");
            //4 requestors rejected; 1 participant non in range
            fail("exception expected");
        } catch(TPException ex) {} //ok

        ls = tp.addParticipants ("pr5", "pt4", "pt3", "pt5", "pt9", "pt8", "pt7");
        //pt4 and pt8 rejected
        assertEquals("[pt3, pt5, pt9, pt7]", ls.toString());

        ls = tp.addParticipants ("pr6", "pt4", "pt3", "pt5");
        //all requestors accepted
        assertEquals("[pt4, pt3, pt5]", ls.toString());


        j = tp.getIncome("pr1");
        assertEquals(j, 6240);

        //R4
        string = tp.addRatings ("pr1", 10, 12, 14, 16);
        //ok: 4 participants, shown in line 78
        assertEquals("pt2:10, pt4:12, pt6:14, pt8:16", string);

        string = tp.addRatings ("pr5", 8, 6, 2, 8);
        //ok: 4 participants, shown in line 90
        assertEquals("pt3:8, pt5:6, pt9:2, pt7:8", string);

        string = tp.addRatings ("pr6", 8, 6, 10);
        //ok: 4 participants, shown in line 96
        assertEquals("pt4:8, pt3:6, pt5:10", string);

        SortedMap<String, Integer> mapSI = tp.getTotalRatingsForParticipants ();
        assertEquals("{pt2=10, pt3=14, pt4=20, pt5=16, pt6=14, pt7=8, pt8=16, pt9=2}", mapSI.toString());

        //R5
        SortedMap<String, Integer> mapSI2 = tp.incomeForActivityTypes();
        assertEquals("{museum visit=20, theatre show=40}", mapSI2.toString());

        SortedMap<Integer, List<String>> mapILS = tp.participantsWithSameNofProposals ();
        assertEquals("{1=[pt2, pt6, pt7, pt8, pt9], 2=[pt3, pt4, pt5]}", mapILS.toString());

    }
}
