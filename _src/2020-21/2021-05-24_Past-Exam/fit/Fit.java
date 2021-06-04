package fit;
import java.util.*;
import java.util.stream.Collectors;


public class Fit {
	private int CustomerN = 0;
	private SortedMap<Integer, Customer> customers = new TreeMap<>();
	private ArrayList<Gymn> gymns = new ArrayList<>();
	
	
	public Fit() {
	
	}
	// R1 
	
	public void addGymn (String name) throws FitException {

	}
	
	public int getNumGymns() {
		return 0;
	}
	
	//R2
	
	public void addLesson (String gymnname, int day, int timeslot, String activity, int maxattendees) throws FitException
	{
		

	}
	
	//R3
	public int addCustomer(String name) {
		return 0;

	}
	
	public Customer getCustomer (int customerid) throws FitException{
		return null;

	}
	
	//R4
	
	public void placeReservation(int customerid, String gymnname, int day, int slot) throws FitException{

	}
	
	
	//R5
	
	public String mostActiveGymn() {
		return null;
	}
	
	public Map<String, Integer> totalLessonsPerGymn() {		
		return null;
	}
	

	
	
	
	


}
