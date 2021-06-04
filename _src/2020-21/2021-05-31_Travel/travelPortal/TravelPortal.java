package travelPortal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TravelPortal {

	private class Pair<T> {
		T a, b;

		Pair(T a, T b) {
			this.a = a;
			this.b = b;
		}

		public String toString() {
			return a + ":" + b;
		}
	};

	private Set<String> activities = new HashSet<>();
	private Map<String, TravelAgency> travelAgencies = new HashMap<>();
	private Map<String, Proposal> proposals = new HashMap<>();

	private List<String> getActivityList() {
		ArrayList<String> list = new ArrayList<>(activities);
		Collections.sort(list);
		return list;
	}

//R1
	public List<String> addActivityTypes(String... names) {
		for (String activity : names) {
			activities.add(activity);
		}
		return getActivityList();
	}

	public int AddTravelAgency(String name, String... activityTypes) throws TPException {
		if (travelAgencies.containsKey(name))
			throw new TPException("Already defined agency: " + name);
		TravelAgency ta = new TravelAgency(name);
		travelAgencies.put(name, ta);
		for (String activity : activityTypes) {
			if (!activities.contains(activity))
				throw new TPException("Undefined activity type: " + activity);
			ta.addActivity(activity);
		}
		return ta.getActivities().size();
	}

	private SortedMap<String, List<String>> getAgenciesForActivityTypes_jcf() {
		SortedMap<String, List<String>> afa = new TreeMap<>();
		for (String agency : travelAgencies.keySet()) {
			for (String activity : travelAgencies.get(agency).getActivities()) {
				if (!afa.containsKey(activity))
					afa.put(activity, new ArrayList<>());
				afa.get(activity).add(agency);
			}
		}
		for (String activity : afa.keySet())
			Collections.sort(afa.get(activity));
		return afa;
	}

	private SortedMap<String, List<String>> getAgenciesForActivityTypes_stream() {
/** NOT WORKING!
		System.out.println(travelAgencies.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey, Comparator.reverseOrder()))
				.flatMap(e -> e.getValue().stream().map(a -> new Pair<String>(a, e.getKey()))).collect(Collectors
						.groupingBy(p -> p.a, TreeMap::new, Collectors.mapping(p -> p.b, Collectors.toList()))));
***/
 		return travelAgencies.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
 				.flatMap(e -> e.getValue().getActivities().stream().map(a -> new Pair<String>(a, e.getKey()))).collect(Collectors
						.groupingBy(p -> p.a, TreeMap::new, Collectors.mapping(p -> p.b, Collectors.toList())));
	}

	public SortedMap<String, List<String>> getAgenciesForActivityTypes() {
		return getAgenciesForActivityTypes_stream();
	}

//R2
	public int addProposal(String code, String agency, String destination, String period, int minNP, int maxNP,
			int price) throws TPException {
		if(proposals.containsKey(code))
			throw new TPException("Existing proposal: " + code);
		if(!travelAgencies.containsKey(agency))
			throw new TPException("Undefined agency: " + agency);
		
		Proposal newProposal = new Proposal(code, travelAgencies.get(agency), destination, period, minNP, maxNP,price);
		proposals.put(code, newProposal);
		return newProposal.getNumberOfDays();
	}

	public int addActivity(String code, String activityType, String description, int price) throws TPException {
		if(!proposals.containsKey(code))
			throw new TPException("Non-existing proposal: " + code);
		return proposals.get(code).addActivity(activityType, description, price);
	}

	public int getProposalPrice(String code) throws TPException {
		if(!proposals.containsKey(code))
			throw new TPException("Non-existing proposal: " + code);
		Proposal proposal = proposals.get(code);
		return proposal.getTotalPrice();
	}

//R3
	public List<String> addParticipants(String code, String... names) throws TPException {
		return null;
	}

	public int getIncome(String code) {
		return 0;
	}

//R4
	public String addRatings(String code, int... evaluations) throws TPException {
		return "";
	}

	public SortedMap<String, Integer> getTotalRatingsForParticipants() {
		return null;
	}

//R5
	public SortedMap<String, Integer> incomeForActivityTypes() {
		return null;
	}

	public SortedMap<Integer, List<String>> participantsWithSameNofProposals() {
		return null;
	}
}
